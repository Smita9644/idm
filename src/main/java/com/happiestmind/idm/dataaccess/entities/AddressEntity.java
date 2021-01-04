package com.happiestmind.idm.dataaccess.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * Address Entity.
 */
@Entity
@Table(name = "address", catalog = "idm")
@Getter
@Setter
public class AddressEntity implements java.io.Serializable {
    /**
     * Size for string field.
     */
    private static final int HUNDERD = 100;
    /**
     * Length for date field.
     */
    private static final int NINETEEN = 19;
    /**
     * Address id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * Enterprise.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTERPRISE_ID", nullable = false)
    private EnterpriseEntity enterprise;
    /**
     * House name.
     */
    @Column(name = "HOUSE_NAME", length = HUNDERD)
    private String houseName;
    /**
     * Street.
     */
    @Column(name = "STREET", length = HUNDERD)
    private String street;
    /**
     * City.
     */
    @Column(name = "CITY", length = HUNDERD)
    private String city;
    /**
     * County.
     */
    @Column(name = "COUNTY", length = HUNDERD)
    private String county;
    /**
     * Postcode.
     */
    @Column(name = "POST_CODE", length = HUNDERD)
    private String postCode;
    /**
     * Country.
     */
    @Column(name = "COUNTRY", length = HUNDERD)
    private String country;
    /**
     * Create date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    private Date createDate;
    /**
     * Last updated date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    private Date lastUpdateDate;
}
