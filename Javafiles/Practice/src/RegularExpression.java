import java.util.regex.Pattern;

//ust-global 2023
public class RegularExpression {
    public static void main(String[] args) {
        String pattern="[a-zA-Z]+"; // * --> 0 or more  // + --> 1 or more
        String str="ajnmfonroain";
       boolean match= Pattern.matches(pattern,str);
        System.out.println(str.matches(pattern));
    }
}

/*
//Regular Expression
Examples - [abc] -> either a or b or c str = "a"

        [abc]* -> zero or more numbers of a or b or c str = "abaac";

        [abc]+ -> one or more numbers of a or b or c

[a-z]* -> zero or more character

[a-zA-Z]* -> zero or more character including uppercase

[a-zA-Z0-9]* -> zero or more character including digits

[0-9]{10} -> a 10 digit number

[0-9]{8,10} -> a digit with 8 to 10 numbers

[0-9]{,10} -> max 10

        [0-9]{10,} -> min 10

        \w == [a-zA-Z0-9]

        \d == [0-9]

        \s == white-space

\W == non character

\D == non-digit

\S == no space

Password Validation Given a method with a password in string format as input. Write code to validate the password using following rules:

Must contain at least one digit
Must contain at least one of the following special characters @, #, $
Length should be between 6 to 20 characters.
String password -> "^(?=.*\\d)(?=.*[@#$])[a-zA-Z0-9@#$]{6,20}$";
Explanation:

        ^ - the start of the string

        (?=.*\d) -> positive lookahead that checks if the string contains at least one digit

        (?=.*[@#$]) -> positive lookahead that checks if the string contains at least one of the special characters @, #, or $

[a-zA-Z0-9@#$]{6,20} -> matches any combination of upper or lowercase letters, digits, and the special characters @, #, and $, with a length between 6 and 20 characters

$ -> the end of the string
 */
