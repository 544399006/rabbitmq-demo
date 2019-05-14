package com.rabbitmq.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    // 方法参数校验异常
    @ExceptionHandler(value = ConstraintViolationException.class)
    public String constraintViolationException(Exception e) {
        if (e.getMessage() != null) {
            return e.getMessage();
        }
        return "";
    }


    // Bean 校验异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String notValidExceptionHandler(MethodArgumentNotValidException e) throws Exception {
        if (e.getBindingResult() != null && !CollectionUtils.isEmpty(e.getBindingResult().getAllErrors())) {
            return e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        } else {
            return e.getMessage();
        }
    }
}