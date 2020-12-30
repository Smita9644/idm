package com.happiestmind.idm.web.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Role permission with features.
 */
@Getter
@Builder
@JsonDeserialize(builder = RolePermissionsWithFeature.RolePermissionsWithFeatureBuilder.class)
public class RolePermissionsWithFeature {
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
    private Map<String, List<Permission>> permissionsByFeature;

    /**
     * Role Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class RolePermissionsWithFeatureBuilder {

    }
}
