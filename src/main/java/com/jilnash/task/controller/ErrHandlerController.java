package com.jilnash.task.controller;

import com.jilnash.task.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;

/**
 * Controller for handling exceptions from MainController
 */

@ControllerAdvice
public class ErrHandlerController {

    /**
     *
     * @param ex
     * @return
     */

    @ExceptionHandler (value = IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(IOException ex)
    {
        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
    }

    @ExceptionHandler (value = MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(MethodArgumentTypeMismatchException ex)
    {
        String message = "Parameter value '" + ex.getValue() + "' is wrong type";

        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), message);
    }
}
