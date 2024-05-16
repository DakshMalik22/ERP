package com.ERP.exceptionHandler;

import com.ERP.entities.ExceptionMessage;
import com.ERP.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SalaryStructureNotFoundException.class)
    public ResponseEntity<ExceptionMessage> salaryStructureNotFoundException(SalaryStructureNotFoundException exception, WebRequest request){
        ExceptionMessage errorMessage = new ExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(HRNotFoundException.class)
    public ResponseEntity<ExceptionMessage> hrNotFoundException(HRNotFoundException exception,
                                                                WebRequest request){
        ExceptionMessage errorMessage = new ExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ExceptionMessage> taskNotFoundException(TaskNotFoundException exception,
                                                                  WebRequest request){
        ExceptionMessage errorMessage = new ExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ExceptionMessage> clientNotFoundException(ClientNotFoundException exception,
                                                                    WebRequest request){
        ExceptionMessage errorMessage = new ExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(LeavesNotFound.class)
    public ResponseEntity<ExceptionMessage> leavesNotFound(LeavesNotFound exception,
                                                                    WebRequest request){
        ExceptionMessage errorMessage = new ExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
