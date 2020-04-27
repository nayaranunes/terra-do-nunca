package br.com.nayaranunes.terradonunca.exception;

public class ApiRequestException extends RuntimeException {
    //costumer exception

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
