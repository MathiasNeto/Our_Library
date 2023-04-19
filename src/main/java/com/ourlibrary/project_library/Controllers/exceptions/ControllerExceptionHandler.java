package com.ourlibrary.project_library.Controllers.exceptions;

import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Excetions.ObjetDuplicator;
import com.ourlibrary.project_library.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError error = StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Not Found")
                .path(request.getRequestURI())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleValidationException(MethodArgumentNotValidException ex,
                                                                   HttpServletRequest request) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        String errorMessage = "";
        for (ObjectError error : errors) {
            errorMessage += error.getDefaultMessage();
        }
        return ResponseEntity.status(HttpStatus.OK).body(StandardError.builder()
                .timestamp(LocalDateTime.now())
                .error("Error")
                .message(errorMessage)
                .path(request.getRequestURI())
                .status(HttpStatus.NO_CONTENT.value())
                .build());
    }

//    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//    public ResponseEntity<StandardError> handleException(SQLIntegrityConstraintViolationException ex, HttpServletRequest request) {
//        return ResponseEntity.status(HttpStatus.OK).body(StandardError.builder()
//                .status(HttpStatus.OK.value())
//                .error("error of parameter")
//                .message(String.valueOf(new ObjectNotFoundException("Cpf D")))
//                .path(request.getRequestURI())
//                .status(HttpStatus.NO_CONTENT.value())
//                .timestamp(
//                        LocalDateTime.now
//                                ()).build());
//    }


    @ExceptionHandler(ObjetDuplicator.class)
    public ResponseEntity<StandardError> sqlException(ObjetDuplicator ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(StandardError.builder()
                .status(HttpStatus.CONFLICT.value())
                .error("error of parameter")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(
                        LocalDateTime.now
                                ()).build());
    }
}
