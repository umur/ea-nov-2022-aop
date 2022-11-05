package labs.lab5;

public class AopIsAwesomeHeaderException extends RuntimeException {
    public AopIsAwesomeHeaderException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
