package com.simplePayment.simplePayment.infra;

import com.simplePayment.simplePayment.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já cadastrado");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(DataIntegrityViolationException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(EntityNotFoundException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}