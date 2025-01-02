package exceptions;

public class DuplicateProductException extends Exception{
    public DuplicateProductException(String msg)
    {
        super(msg);
    }
}
