H + V


SecurityConfig.java

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    JwtFilter jwtFilter;


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("register", "login").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}


JwtFilter.java

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;
    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUserName(token);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
            if (jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}


UserController.java

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) return jwtService.generateToken(user.getUsername());
        else return "Login Failed";
    }
}

repo

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private String tech;

}


@Data
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

}


UserPrincipal.java

public class UserPrincipal implements UserDetails {

    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}



JwtService.java

@Service
public class JwtService {

    private static final String SECRET = "TmV3U2VjcmV0S2V5Rm9ySldUU2lnbmluZ1B1cnBvc2VzMTIzNDU2Nzg=\r\n";
    private static final String SECRET1 = "0000000000000000000000000000000000000000000"; //43 Characters min

    private String secretKey;

    public JwtService() {
        secretKey = generateSecretKey();
    }

    public String generateSecretKey() {
        try {

            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("Secret Key : " + secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis() + 1000 * 60 * 3)))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build().parseClaimsJws(token).getBody();
    }


    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}


MyUserDetailsService.java

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("No user with this User Name: " + username);
            throw new UsernameNotFoundException("User Not Found");
        } else {
            return new UserPrincipal(user);
        }
    }
}

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return repo.save(user);
    }
}



<---HEMA--->

Security Config:

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthFilter authFilter;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);

////        UserDetails admin = User.builder()
////                .username("admin")
////                .password("$2a$12$6VNeAf2CNX1SsVpDeB65SunD5RfnnUQQHUTQ61lHSIoYbvyTwVzN2")
////                .roles("ADMIN")
////                .build();
////
////        UserDetails user = User.builder()
////                .username("USER")
////                .password("$2a$12$EbCYTojKcOJ57WrytHbwB.n64MmxWAz3QYPZNdKpcYvCkTWToerhe")
////                .roles("USER")
////                .build();
////
////        auth.inMemoryAuthentication().withUser(admin)
////                .withUser(user);
//
}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/api/public/register").permitAll()
                .antMatchers("/api/public/**").permitAll()
                .antMatchers("/api/secured/**").hasRole("ADMIN")
                .antMatchers("/api/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        ;

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}



AuthFilter:

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

//    @Autowired
//    UserRepository userRepo;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String header = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (header != null && header.startsWith("Bearer")) {
            token = header.substring(7);
        }

        if (token != null) {
            username = jwtUtil.getUsernameFromToken(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        }

        filterChain.doFilter(request, response);

    }
}



JwtUtil:


@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000)) // 5 minutes
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

}

or


@Component
public class JwtUtil {

    public static final long JWT_TOKEN_VALIDITY = 10 * 60; // secs

    @Value("${jwt.secret}")
    private String secret;



    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }



    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }


    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }


    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, username);
    }


    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }


    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}


user details:


public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private String roles;

    public UserDetailsImpl(UserModel user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+roles);
        return List.of(authority);

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


User details service implementation :

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Username Doesn't Exist"));

        return new UserDetailsImpl(user);

    }


    public UserDetails saveUser(UserModel model){
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        return new UserDetailsImpl(userRepo.save(model));
    }
}
