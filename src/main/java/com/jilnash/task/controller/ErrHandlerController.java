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
     * Handles IOException caused in MainController
     * Triggered when parameter value is not valid
     *
     * @param ex
     * @return ErrorResponse object which contains error code and message
     */

    @ExceptionHandler (value = IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(IOException ex)
    {
        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
    }

    /**
     * Handles MethodArgumentTypeMismatchException caused in MainController.
     * Triggered when request parameter type is not matching with method argument type
     *
     * @param ex
     * @return ErrorResponse object which contains error code and message
     */

    @ExceptionHandler (value = MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(MethodArgumentTypeMismatchException ex)
    {
        String message = "Parameter value '" + ex.getValue() + "' is wrong type";

        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), message);
    }
}
