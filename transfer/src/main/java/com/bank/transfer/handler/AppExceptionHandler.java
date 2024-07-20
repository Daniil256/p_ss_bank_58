package com.bank.transfer.handler;

import com.bank.transfer.exception.SQLTransferException;
import liquibase.repackaged.org.apache.commons.collections4.map.HashedMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> invalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashedMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errorMap.put(e.getField(), e.getDefaultMessage()));
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({SQLTransferException.class})
    public Map<String, String> handleBusinessException(SQLTransferException ex) {
        Map<String, String> errorMap = new HashedMap<>();
        errorMap.put("Error message", ex.getMessage());
        return errorMap;
    }
}
