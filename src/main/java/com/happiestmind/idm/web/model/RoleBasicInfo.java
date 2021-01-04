package com.happiestmind.idm.web.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Role basic info.
 */
@Getter
@Builder
@JsonDeserialize(builder = RoleBasicInfo.RoleBasicInfoBuilder.class)
public class RoleBasicInfo {
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
    private Character status;

    /**
     * Role basic info Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class RoleBasicInfoBuilder {

    }
}
