package Exception;

public class AgeIlegalException extends RuntimeException {
    public AgeIlegalException() {
    }
    public AgeIlegalException(String message) {
        super(message);
    }
}
