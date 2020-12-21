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
 * PasswordPolicyAttr Entity.
 */
@Entity
@Table(name = "password_policy_attr", catalog = "idm")
public class PasswordPolicyAttrEntity implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Length of attribute  name and value.
     */
    public static final int FIFTY = 50;
    /**
     * Id.
     */
    private Long id;
    /**
     * Password policy.
     */
    private PasswordPolicyEntity passwordPolicy;
    /**
     * Attribute name.
     */
    private String attrName;
    /**
     * Attribute value.
     */
    private String attrValue;
    /**
     * Created date.
     */
    private Date createDate;
    /**
     * Last updated date.
     */
    private Date lastUpdateDate;

    /**
     * Parameter less constructor.
     */
    public PasswordPolicyAttrEntity() {
    }

    /**
     * Parameterised constructor.
     *
     * @param passwordPolicyEntity passwordPolicy
     * @param attrName       attrName
     * @param attrValue      attrValue
     * @param createDate     createDate
     * @param lastUpdateDate lastUpdateDate
     */
    public PasswordPolicyAttrEntity(PasswordPolicyEntity passwordPolicyEntity, String attrName, String attrValue,
                                    Date createDate,
                                    Date lastUpdateDate) {
        this.passwordPolicy = passwordPolicyEntity;
        this.attrName = attrName;
        this.attrValue = attrValue;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get id.
     *
     * @return id of password policy attribute.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * Set id to password policy attribute entity.
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get policy id.
     *
     * @return policy id if password policy attribute
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POLICY_ID", nullable = false)
    public PasswordPolicyEntity getPasswordPolicy() {
        return this.passwordPolicy;
    }

    /**
     * Set  password policy.
     *
     * @param passwordPolicyEntity passwordPolicy
     */
    public void setPasswordPolicy(PasswordPolicyEntity passwordPolicyEntity) {
        this.passwordPolicy = passwordPolicyEntity;
    }

    /**
     * Get password attribute.
     *
     * @return attribute name
     */
    @Column(name = "ATTR_NAME", length = FIFTY)
    public String getAttrName() {
        return this.attrName;
    }

    /**
     * Set the password attribute name.
     *
     * @param attrName attribute name
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     * Get attribute value.
     *
     * @return attribute value.
     */
    @Column(name = "ATTR_VALUE", length = FIFTY)
    public String getAttrValue() {
        return this.attrValue;
    }

    /**
     * Set attribute value.
     *
     * @param attrValue attrValue
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    /**
     * Get created date.
     *
     * @return created date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set created date.
     *
     * @param createDate created date.
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get last updated date.
     *
     * @return last updated date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    /**
     * Set last updated date.
     *
     * @param lastUpdateDate last updated date.
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
