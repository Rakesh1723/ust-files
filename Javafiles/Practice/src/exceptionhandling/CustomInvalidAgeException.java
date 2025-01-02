package exceptionhandling;

public class CustomInvalidAgeException extends Exception{
    public CustomInvalidAgeException(String message) {
        super(message);
    }
}
