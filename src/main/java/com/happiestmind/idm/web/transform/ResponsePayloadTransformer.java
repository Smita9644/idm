package com.happiestmind.idm.web.transform;

import com.happiestmind.idm.web.model.ResponsePayload;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Response payload transformer.
 */
@Component
public class ResponsePayloadTransformer {

    /**
     * Conversion to response payload.
     *
     * @param success status of api
     * @param message message to display
     * @return response payload
     */
    public ResponsePayload toResponsePayload(HttpStatus success, String message) {
        return ResponsePayload.builder().code(success.value())
            .message(message)
            .applicationErrorCode((long) 0).build();
    }

}
