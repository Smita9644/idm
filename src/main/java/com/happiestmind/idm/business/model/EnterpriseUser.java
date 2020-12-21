package com.happiestmind.idm.business.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.happiestmind.idm.dataaccess.entities.EnterpriseEntity;
import com.happiestmind.idm.dataaccess.entities.UserEntity;

import lombok.Builder;
import lombok.Getter;

/**
 * Response payload .
 */
@Getter
@Builder
@JsonDeserialize(builder = EnterpriseUser.EnterpriseUserBuilder.class)
public class EnterpriseUser {
    /**
     * Enterprise.
     */
    private EnterpriseEntity enterpriseEntity;
    /**
     * User entity.
     */
    private UserEntity userEntity;

    /**
     * Response Payload  inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class EnterpriseUserBuilder {

    }
}
