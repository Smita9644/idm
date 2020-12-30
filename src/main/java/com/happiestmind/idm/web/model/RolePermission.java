package com.happiestmind.idm.web.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Role permission.
 */
@Getter
@Builder
@JsonDeserialize(builder = RolePermission.RolePermissionBuilder.class)
public class RolePermission {
    /**
     * Id.
     */
    private Long id;
    /**
     * Name of the role.
     */
    private String name;
    /**
     * Description of the role.
     */
    private String description;
    /**
     * Status.
     */
    private Character status;
    /**
     * List of permission ids.
     */
    private List<Permission> permissions;

    /**
     * Role Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class RolePermissionBuilder {

    }
}
