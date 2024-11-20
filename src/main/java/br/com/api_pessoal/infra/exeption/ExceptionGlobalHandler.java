package br.com.api_pessoal.infra.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException validationException) {
        var details = new ExceptionDetails(HttpStatus.BAD_REQUEST.value(), validationException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException authenticationException) {
        var details = new ExceptionDetails(HttpStatus.UNAUTHORIZED.value(), authenticationException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<?> handleAuthorizationDeniedException(AuthorizationDeniedException authorizationDeniedException) {
        var details = new ExceptionDetails(HttpStatus.UNAUTHORIZED.value(), authorizationDeniedException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResourceFoundException(NoResourceFoundException noResourceFoundException) {
        var details = new ExceptionDetails(HttpStatus.NOT_FOUND.value(), noResourceFoundException.getMessage());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

}
