package com.happiestmind.idm.dataaccess.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WeakPassword Entity.
 */
@Entity
@Table(name = "weak_password", catalog = "idm")
public class WeakPassword implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Length of  value.
     */
    public static final int FIFTY = 50;
    /**
     * Id.
     */
    private Long id;
    /**
     * Value.
     */
    private String value;
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
    public WeakPassword() {
    }

    /**
     * Prameter less constructor.
     *
     * @param value          value
     * @param createDate     create Date.
     * @param lastUpdateDate last update date
     */
    public WeakPassword(String value, Date createDate, Date lastUpdateDate) {
        this.value = value;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get id.
     *
     * @return id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * Set id.
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get value.
     *
     * @return value
     */
    @Column(name = "VALUE", nullable = false, length = FIFTY)
    public String getValue() {
        return this.value;
    }

    /**
     * Set value.
     *
     * @param value value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get created date.
     *
     * @return created date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set created date.
     *
     * @param createDate created date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get last updated date.
     *
     * @return last updated date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    /**
     * Set last updated date.
     *
     * @param lastUpdateDate last updated date
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
