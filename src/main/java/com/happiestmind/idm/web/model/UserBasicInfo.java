package com.happiestmind.idm.web.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * User basic info dto.
 */
@Getter
@Builder
@JsonDeserialize(builder = UserBasicInfo.UserBasicInfoBuilder.class)
public class UserBasicInfo {
    /**
     * Email id.
     */
    private String emailId;
    /**
     * Name.
     */
    private String name;
    /**
     * User name.
     */
    private String userName;

    /**
     * User basic info dto Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBasicInfoBuilder {

    }
}
