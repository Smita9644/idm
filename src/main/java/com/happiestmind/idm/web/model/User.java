package com.happiestmind.idm.web.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * User model class.
 */
@Getter
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {
    /**
     * Id.
     */
    private Long id;
    /**
     * User Name.
     */
    private String username;
    /**
     * Name.
     */
    private String name;
    /**
     * Email id.
     */
    private String emailId;

    /**
     * Enterprise code.
     */
    private String enterpriseCode;
    /**
     * Status.
     */
    private Character status;
    /**
     * Roles.
     */
    private List<String> roleNames;
    /**
     * Permissions.
     */
    private List<String> permissionNames;
    /**
     * User type.
     */
    private int userType;

    /**
     * User Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {

    }
}
