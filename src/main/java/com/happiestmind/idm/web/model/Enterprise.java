package com.happiestmind.idm.web.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Enterprise.
 */
@Getter
@Builder
@JsonDeserialize(builder = Enterprise.EnterpriseBuilder.class)
public class Enterprise {
    /**
     * Enterprise id.
     */
    private Long id;
    /**
     * Enterprise name.
     */
    private String name;
    /**
     * Enterprise status.
     */
    private Character status;
    /**
     * Code for enterprise.
     */
    private String enterpriseCode;
    /**
     * Enterprise type.
     */
    private int enterpriseType;
    /**
     * Address.
     */
    private Set<Address> address;
    /**
     * User.
     */
    private User admin;
    /**
     * Created date of enterprise.
     */
    private Date createDate;
    /**
     * Last updated date of enterprise.
     */
    private Date lastUpdateDate;

    /**
     * Enterprise Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class EnterpriseBuilder {

    }
}
