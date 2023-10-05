package com.acount.move.exception;

import com.acount.move.util.CustomException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("error", "Error de integridad de datos");
        result.put("message", ex.getMessage());

        return new ResponseEntity<>(result, HttpStatus.CONFLICT); // Código de estado 409 Conflict
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("error", "Error negocio");
        result.put("message", ex.getMessage());

        return new ResponseEntity<>(result, HttpStatus.CONFLICT); // Código de estado 409 Conflict
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("error", "Error servidor");
        result.put("message", ex.getMessage());

        return new ResponseEntity<>(result, HttpStatus.CONFLICT); // Código de estado 409 Conflict
    }
}
