package com.happiestmind.idm.web.model;

import java.util.Date;
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
     * User Name.
     */
    private String username;
    /**
     * Email id.
     */
    private String emailId;
    /**
     * Password.
     */
    private String password;
    /**
     * Salt.
     */
    private String salt;
    /**
     * Password Created.
     */
    private Date passwdCreated;
    /**
     * Change password.
     */
    private Boolean changePasswd;
    /**
     * Login Fail Count.
     */
    private Integer loginFailCount;
    /**
     * Email Verified.
     */
    private Boolean emailVerified;
    /**
     * Enterprise code.
     */
    private String enterpriseCode;
    /**
     * Status.
     */
    private Character status;
    /**
     * User type.
     */
    private int userType;
    /**
     * Password Expiry.
     */
    private Date passwordExpiry;
    /**
     * Create date.
     */
    private Date createDate;
    /**
     * Last updated date.
     */
    private Date lastUpdateDate;
    /**
     * Last login date.
     */
    private Date lastLoginDate;
    /**
     * Name.
     */
    private String name;
    /**
     * Roles.
     */
    private List<String> roles;
    /**
     * Permissions.
     */
    private List<String> permissions;

    /**
     * User Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class UserBuilder {

    }
}
