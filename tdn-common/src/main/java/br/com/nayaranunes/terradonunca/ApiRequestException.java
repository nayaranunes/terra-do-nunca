package br.com.nayaranunes.terradonunca;

public class ApiRequestException extends RuntimeException {
    //costumer exception

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
