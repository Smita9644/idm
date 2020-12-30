package com.happiestmind.idm.web.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Role.
 */
@Getter
@Builder
@JsonDeserialize(builder = Role.RoleBuilder.class)
public class Role {
    /**
     * Name of the role.
     */
    private String name;
    /**
     * Description of the role.
     */
    private String description;
    /**
     * List of permission ids.
     */
    private List<Long> permissionIds;

    /**
     * Role Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class RoleBuilder {

    }
}
