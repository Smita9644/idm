package com.happiestmind.idm.dataaccess.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PasswordPolicy Entity.
 */
@Entity
@Table(name = "password_policy", catalog = "idm")
public class PasswordPolicyEntity implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Length of enterprise code.
     */
    public static final int FOURTEEN = 14;
    /**
     * Length of policy name.
     */
    public static final int FIFTY = 50;
    /**
     * Length of description.
     */
    public static final int TWO_FIFTY_SIX = 256;
    /**
     * Password policy id.
     */
    private Long id;
    /**
     * Enterprise code.
     */
    private String enterpriseCode;
    /**
     * Policy name.
     */
    private String policyName;
    /**
     * Description of the policy.
     */
    private String description;
    /**
     * Status of the policy.
     */
    private Character status;
    /**
     * Created date of password policy.
     */
    private Date createDate;
    /**
     * Last updated date of password policy.
     */
    private Date lastUpdateDate;
    /**
     * Password policy attributes.
     */
    private Set<PasswordPolicyAttr> passwordPolicyAttrs = new HashSet(0);

    /**
     * Parameter less constructor for Password policy.
     */
    public PasswordPolicyEntity() {
    }

    /**
     * Parameterised constructor for Password policy.
     *
     * @param enterpriseCode enterpriseCode
     * @param policyName     policyName
     * @param createDate     createDate
     * @param lastUpdateDate lastUpdateDate
     */
    public PasswordPolicyEntity(String enterpriseCode, String policyName, Date createDate,
                                Date lastUpdateDate) {
        this.enterpriseCode = enterpriseCode;
        this.policyName = policyName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Parameterised constructor for Password policy.
     *
     * @param enterpriseCode      enterpriseCode
     * @param policyName          policyName
     * @param description         description
     * @param status              status
     * @param createDate          createDate
     * @param lastUpdateDate      lastUpdateDate
     * @param passwordPolicyAttrs passwordPolicyAttrs
     */
    public PasswordPolicyEntity(String enterpriseCode, String policyName, String description,
                                Character status,
                                Date createDate, Date lastUpdateDate,
                                Set<PasswordPolicyAttr> passwordPolicyAttrs) {
        this.enterpriseCode = enterpriseCode;
        this.policyName = policyName;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.passwordPolicyAttrs = passwordPolicyAttrs;
    }

    /**
     * Get password policy  id.
     *
     * @return id.
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * Set password policy id.
     *
     * @param id of password policy
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get enterprise code.
     *
     * @return enterprise code
     */
    @Column(name = "ENTERPRISE_CODE", nullable = false, length = FOURTEEN)
    public String getEnterpriseCode() {
        return this.enterpriseCode;
    }

    /**
     * Set enterprise code.
     *
     * @param enterpriseCode enterpriseCode
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * Get policy name.
     *
     * @return policy name
     */
    @Column(name = "POLICY_NAME", nullable = false, length = FIFTY)
    public String getPolicyName() {
        return this.policyName;
    }

    /**
     * Set policy name.
     *
     * @param policyName policy name.
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    /**
     * Get description.
     *
     * @return description of password policy.
     */
    @Column(name = "DESCRIPTION", length = TWO_FIFTY_SIX)
    public String getDescription() {
        return this.description;
    }

    /**
     * Set description.
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get satatus.
     *
     * @return status of password policy
     */
    @Column(name = "STATUS", length = 1)
    public Character getStatus() {
        return this.status;
    }

    /**
     * Set Status.
     *
     * @param status status
     */
    public void setStatus(Character status) {
        this.status = status;
    }

    /**
     * Get created date of password policy.
     *
     * @return created date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set created date to password policy.
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
     * @param lastUpdateDate lastUpdateDate
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get password attributes.
     *
     * @return password attributes
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "passwordPolicy")
    public Set<PasswordPolicyAttr> getPasswordPolicyAttrs() {
        return this.passwordPolicyAttrs;
    }

    /**
     * Set password attributes.
     *
     * @param passwordPolicyAttrs passwordPolicyAttrs
     */
    public void setPasswordPolicyAttrs(Set<PasswordPolicyAttr> passwordPolicyAttrs) {
        this.passwordPolicyAttrs = passwordPolicyAttrs;
    }

}
