package com.happiestmind.idm.web.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Getter;

/**
 * Address model class.
 */
@Getter
@Builder
@JsonDeserialize(builder = Address.AddressBuilder.class)
public class Address {
    /**
     * House name.
     */
    private String houseName;
    /**
     * Street.
     */
    private String street;
    /**
     * City.
     */
    private String city;
    /**
     * County.
     */
    private String county;
    /**
     * Postcode.
     */
    private String postCode;
    /**
     * Country.
     */
    private String country;
    /**
     * Create date.
     */
    private Date createDate;
    /**
     * Last updated date.
     */
    private Date lastUpdateDate;

    /**
     * Address  Builder inner class.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static class AddressBuilder {

    }
}
