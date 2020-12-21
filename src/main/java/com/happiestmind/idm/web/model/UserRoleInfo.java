package com.happiestmind.idm.web.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * User basic info dto.
 */
@Getter
@Builder
@JsonDeserialize(builder = UserRoleInfo.UserRoleInfoBuilder.class)
public class UserRoleInfo {
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
     * Roles.
     */
    private List<String> roles;

    /**
     * User basic info dto Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class UserRoleInfoBuilder {

    }
}
