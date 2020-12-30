package com.happiestmind.idm.web.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Response payload .
 */
@Getter
@Builder
@JsonDeserialize(builder = ResponsePayload.ResponsePayloadBuilder.class)
public class ResponsePayload {
    /**
     * Http status code.
     */
    private Integer code;
    /**
     * Message.
     */
    private String message;
    /**
     * Application error code.
     */
    private Long applicationErrorCode = 0L;

    /**
     * Response Payload  inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class ResponsePayloadBuilder {

    }
}
