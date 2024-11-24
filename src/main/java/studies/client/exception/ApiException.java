package studies.client.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
