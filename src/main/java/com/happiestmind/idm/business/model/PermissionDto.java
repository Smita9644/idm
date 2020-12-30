package com.happiestmind.idm.business.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Permission model class .
 */
@Getter
@Builder
@JsonDeserialize(builder = PermissionDto.PermissionBuilder.class)
public class PermissionDto {
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
