package com.happiestmind.idm.web.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Enterprise basic info.
 */
@Getter
@Builder
@JsonDeserialize(builder = EnterpriseBasicInfo.EnterpriseBasicInfoBuilder.class)
public class EnterpriseBasicInfo {
    /**
     * Enterprise name.
     */
    private String name;

    /**
     * User details.
     */
    private UserBasicInfo admin;

    /**
     * Enterprise basic info dto Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class EnterpriseBasicInfoBuilder {

    }
}
