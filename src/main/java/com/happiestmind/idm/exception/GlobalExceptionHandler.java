package com.happiestmind.idm.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class is a Global Exception Handler
 * Token Validation approach:
 * 400 - Bad Token when given token can not be parsed or signature verification failed
 * - issuer of token can be different from Azure
 * - audience of token may be not current web API.
 * 401 - when token is valid however expired; this helps client to refresh token.
 * 403 - when token expired
 */

@RestControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Date time formatter.
     */
    private DateTimeFormatter dateTimeFormatter =
        new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").toFormatter();

    /**
     * Handling method for all exceptions resulting from Web Filter.
     *
     * @param exception   a Runtime exception
     * @param httpRequest a http request
     * @return ResponseEntity with ErrorResponse body.
     */
    public ResponseEntity<ErrorResponse> handleFilterException(RuntimeException exception,
                                                               HttpServletRequest httpRequest) {
        ResponseEntity<ErrorResponse> responseEntity = null;
        if (exception instanceof EntityNotFoundException) {
            responseEntity =
                handleEntityNotFoundException((EntityNotFoundException) exception, httpRequest);
        }
        return responseEntity;
    }

    /**
     * Handling method for Entity Not Found for given id case.
     *
     * @param exception a Runtime exception
     * @param request   a http request
     * @return ResponseEntity with ErrorResponse body.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(
        final EntityNotFoundException exception, final HttpServletRequest request) {
        return new ResponseEntity<>(buildErrorResponse(exception), HttpStatus.NOT_FOUND);
    }

    /**
     * Handling method for unexpected exceptions.
     *
     * @param exception a Runtime exception
     * @param request   a http request
     * @return ResponseEntity with ErrorResponse body.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(
        final RuntimeException exception,
        final HttpServletRequest request) {
        return new ResponseEntity<>(buildErrorResponse(exception),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse buildErrorResponse(
        RuntimeException exception) {
        exception.printStackTrace();
        Throwable rootCause = exception;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        final StringBuilder errorMessageBuilder = new StringBuilder(exception.getMessage());
        if (!rootCause.equals(exception)) {
            errorMessageBuilder.append(". Root cause: ");
            errorMessageBuilder.append(rootCause.getMessage());
        }

        return ErrorResponse.builder()
            .errorMessage(errorMessageBuilder.toString())
            .timestamp(LocalDateTime.now().format(this.dateTimeFormatter)).build();
    }
}
