package traineeapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("traineeapp")
@PropertySource("application.properties")
public class TraineeAppConfig {

    @Value("${db.url}")
    private  String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private  String password;

    @Bean("postgres")
    public Connection createConnection() throws SQLException{
       Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    @Bean("mysql") // in singleton all are created at first only
    @Lazy //it will create when needed only
    public Connection createMysqlConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ust_db","root","password");
        return connection;
    }
}
