package com.happiestmind.idm.dataaccess.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Enterprise Entity.
 */
@Entity
@Table(name = "enterprise", catalog = "idm")
public class Enterprise implements java.io.Serializable {
    /**
     * Size for string field.
     */
    public static final int HUNDRED = 100;
    /**
     * Length for date field.
     */
    public static final int NINETEEN = 19;
    /**
     * Length for enterprise code.
     */
    public static final int FOURTEEN = 14;
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
     * Created date of enterprise.
     */
    private Date createDate;
    /**
     * Last updated date of enterprise.
     */
    private Date lastUpdateDate;
    /**
     * Addresses for the enterprise.
     */
    private Set<Address> addressEntities = new HashSet(0);

    /**
     * Parameter less constructor.
     */
    public Enterprise() {
    }

    /**
     * Parameterised constructor.
     *
     * @param enterpriseType enterpriseType
     * @param createDate     createDate
     * @param lastUpdateDate lastUpdateDate
     */
    public Enterprise(int enterpriseType, Date createDate, Date lastUpdateDate) {
        this.enterpriseType = enterpriseType;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Parameterised constructor.
     *
     * @param name           name
     * @param status         status
     * @param enterpriseCode enterprise code
     * @param enterpriseType enterprise type
     * @param createDate     created date
     * @param lastUpdateDate last updated date
     * @param addressEntities      address
     */
    public Enterprise(String name, Character status, String enterpriseCode, int enterpriseType,
                      Date createDate,
                      Date lastUpdateDate, Set<Address> addressEntities) {
        this.name = name;
        this.status = status;
        this.enterpriseCode = enterpriseCode;
        this.enterpriseType = enterpriseType;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.addressEntities = addressEntities;
    }

    /**
     * Get id of the enterprise.
     *
     * @return id of enterprise.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * Set id to the enterprise.
     *
     * @param id for enterprise.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get name of enterprise.
     *
     * @return name
     */
    @Column(name = "NAME", length = HUNDRED)
    public String getName() {
        return this.name;
    }

    /**
     * Set name to the enterprise.
     *
     * @param name enterprise name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get status of the enterprise.
     *
     * @return status
     */
    @Column(name = "STATUS", length = 1)
    public Character getStatus() {
        return this.status;
    }

    /**
     * Set Status to enterprise.
     *
     * @param status status
     */
    public void setStatus(Character status) {
        this.status = status;
    }

    /**
     * Get enterprise code.
     *
     * @return enterprise code.
     */
    @Column(name = "ENTERPRISE_CODE", length = FOURTEEN)
    public String getEnterpriseCode() {
        return this.enterpriseCode;
    }

    /**
     * Set enterprise code.
     *
     * @param enterpriseCode enterprise code
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * Get enterprise type.
     *
     * @return enterprise type
     */
    @Column(name = "ENTERPRISE_TYPE", nullable = false)
    public int getEnterpriseType() {
        return this.enterpriseType;
    }

    /**
     * Set enterprise type.
     *
     * @param enterpriseType enterprise type
     */
    public void setEnterpriseType(int enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    /**
     * Created date of enterprise.
     *
     * @return date of creation
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set Created date to enterprise.
     *
     * @param createDate date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Last updated date of enterprise.
     *
     * @return date of last updation
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    /**
     * Set last updated date to enterprise.
     *
     * @param lastUpdateDate date
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get addresses of the enterprise.
     *
     * @return list of address.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
    public Set<Address> getAddressEntities() {
        return this.addressEntities;
    }

    /**
     * Set the address to the Enterprise.
     *
     * @param addressEntities addresses
     */
    public void setAddressEntities(Set<Address> addressEntities) {
        this.addressEntities = addressEntities;
    }

}
