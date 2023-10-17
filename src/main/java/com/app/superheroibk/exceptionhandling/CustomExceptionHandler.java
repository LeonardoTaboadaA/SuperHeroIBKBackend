package com.app.superheroibk.exceptionhandling;

import com.app.superheroibk.exception.AbilityNotFoundException;
import com.app.superheroibk.exception.SuperheroNotFoundException;
import com.app.superheroibk.util.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SuperheroNotFoundException.class)
    public ResponseEntity<Object> handleSuperheroNotFoundException(SuperheroNotFoundException ex) {
        // Crea un objeto de respuesta personalizado con un mensaje de error
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AbilityNotFoundException.class)
    public ResponseEntity<Object> handleAbilityNotFoundException(AbilityNotFoundException ex) {
        // Crea un objeto de respuesta personalizado con un mensaje de error
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
