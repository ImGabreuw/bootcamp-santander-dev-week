package me.gabreuw.bootcamp_santander_dev_week.exceptions.handler;

import me.gabreuw.bootcamp_santander_dev_week.exceptions.BusinessException;
import me.gabreuw.bootcamp_santander_dev_week.exceptions.ExceptionResponse;
import me.gabreuw.bootcamp_santander_dev_week.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handlerBusinessException(BusinessException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());

        return ResponseEntity
                .unprocessableEntity()
                .body(exceptionResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerNotFoundException(NotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }

}
