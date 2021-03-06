package com.feng.baby.config;

import com.feng.baby.support.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public GlobalControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(HttpServletRequest request, ValidationException ex) {
        String message = messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale());
        return new ErrorResponse(message, request.getServletPath());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleAccessDeniedException(HttpServletRequest request, AccessDeniedException ex) {
        return new ErrorResponse(
                messageSource.getMessage("error.access.denied", null, LocaleContextHolder.getLocale()),
                request.getServletPath());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleRuntimeException(HttpServletRequest request, RuntimeException ex) {
        log.warn("Internal server error:", ex);
        return new ErrorResponse(
                messageSource.getMessage("internal.server.error", null, LocaleContextHolder.getLocale()),
                request.getServletPath());
    }

}
