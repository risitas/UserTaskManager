package com.smzynm.UserTaskManager.exception;

import com.smzynm.UserTaskManager.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDto> generalException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, true, e.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<MessageDto> accessDeniedException(AccessDeniedException accessDeniedException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new MessageDto(HttpStatus.FORBIDDEN, true, "This resource cannot be accessed"));
    }

    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDto> throwAttributeException(AttributeException e) {
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, true, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDto> validationException(MethodArgumentNotValidException ex) {
        List<String> messages = new ArrayList<>();
        BindingResult results = ex.getBindingResult();
        for (FieldError e : results.getFieldErrors()) {
            messages.add(e.getField() + ": " + e.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, true, messages.toString()));
    }
}
