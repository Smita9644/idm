package com.happiestmind.idm.dataaccess.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Address Entity.
 */
@Entity
@Table(name = "address", catalog = "idm")
public class AddressEntity implements java.io.Serializable {
    /**
     * Size for string field.
     */
    public static final int HUNDERD = 100;
    /**
     * Length for date field.
     */
    public static final int NINETEEN = 19;
    /**
     * Address id.
     */
    private Long id;
    /**
     * Enterprise.
     */
    private EnterpriseEntity enterprise;
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
     * Parameter less constructor.
     */
    public AddressEntity() {
    }

    /**
     * Parameterised constructor for Address Entity.
     *
     * @param enterprise     enterprise
     * @param houseName      houseName
     * @param street         street
     * @param city           city
     * @param county         county
     * @param postCode       postCode
     * @param country        country
     * @param createDate     createDate
     * @param lastUpdateDate lastUpdateDate
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public AddressEntity(EnterpriseEntity enterprise, String houseName, String street, String city,
                         String county, String postCode,
                         String country, Date createDate, Date lastUpdateDate) {
        this.enterprise = enterprise;
        this.houseName = houseName;
        this.street = street;
        this.city = city;
        this.county = county;
        this.postCode = postCode;
        this.country = country;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Getting id of Address entity.
     *
     * @return id of address entity
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * Set the id of Address entity.
     *
     * @param id of address entity
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get Enterprise.
     *
     * @return Enterprise Entity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTERPRISE_ID", nullable = false)
    public EnterpriseEntity getEnterprise() {
        return this.enterprise;
    }

    /**
     * Set Enterprise to the Address.
     *
     * @param enterprise enterprise
     */
    public void setEnterprise(EnterpriseEntity enterprise) {
        this.enterprise = enterprise;
    }

    /**
     * Get house name.
     *
     * @return house name of address
     */
    @Column(name = "HOUSE_NAME", length = HUNDERD)
    public String getHouseName() {
        return this.houseName;
    }

    /**
     * Set House name.
     *
     * @param houseName house name.
     */
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    /**
     * Get Street.
     *
     * @return name of street of address.
     */
    @Column(name = "STREET", length = HUNDERD)
    public String getStreet() {
        return this.street;
    }

    /**
     * Set street name.
     *
     * @param street street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get city.
     *
     * @return city of address
     */
    @Column(name = "CITY", length = HUNDERD)
    public String getCity() {
        return this.city;
    }

    /**
     * Set city.
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get county.
     *
     * @return county of address
     */
    @Column(name = "COUNTY", length = HUNDERD)
    public String getCounty() {
        return this.county;
    }

    /**
     * Set county.
     *
     * @param county county.
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * Get post code.
     *
     * @return post code of address
     */
    @Column(name = "POST_CODE", length = HUNDERD)
    public String getPostCode() {
        return this.postCode;
    }

    /**
     * Set post code.
     *
     * @param postCode postcode
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Get country.
     *
     * @return country of the address.
     */
    @Column(name = "COUNTRY", length = HUNDERD)
    public String getCountry() {
        return this.country;
    }

    /**
     * Set Country.
     *
     * @param country country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get created date of the address.
     *
     * @return date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set created date to the address.
     *
     * @param createDate create date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get last update date.
     *
     * @return last updated date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    /**
     * Set last updated to the address.
     *
     * @param lastUpdateDate last updated date
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
