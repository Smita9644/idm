package com.happiestmind.idm.web.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Permission model class .
 */
@Getter
@Builder
@JsonDeserialize(builder = Permission.PermissionBuilder.class)
public class Permission {
    /**
     * Id.
     */
    private Long id;
    /**
     * Name of permission.
     */
    private String name;
    /**
     * Description.
     */
    private String description;
    /**
     * Status.
     */
    private Character status;

    /**
     * Permission  inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class PermissionBuilder {

    }
}
