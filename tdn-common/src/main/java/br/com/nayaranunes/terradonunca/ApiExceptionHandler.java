package br.com.nayaranunes.terradonunca;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        //Payload
        HttpStatus unprocessableEntity = HttpStatus.UNPROCESSABLE_ENTITY; //error de ngc 422
        ApiException apiException = new ApiException(
                e.getMessage(),
                unprocessableEntity,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, unprocessableEntity);
    }
}
