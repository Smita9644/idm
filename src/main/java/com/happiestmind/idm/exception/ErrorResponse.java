package com.happiestmind.idm.exception;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * This class is used for custom response message.
 */
@Builder
@Getter
@JsonDeserialize(builder = ErrorResponse.ErrorResponseBuilder.class)
public class ErrorResponse {
    /**
     * Error message.
     */
    private String errorMessage;

    /**
     * Requested URI.
     */
    private String requestedUri;

    /**
     * Timestamp in string format.
     */
    private String timestamp;

    /**
     * Error response builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class ErrorResponseBuilder {

    }
}
