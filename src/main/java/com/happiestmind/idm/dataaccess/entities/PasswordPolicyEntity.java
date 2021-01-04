package com.happiestmind.idm.dataaccess.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

import lombok.Getter;
import lombok.Setter;

/**
 * PasswordPolicy Entity.
 */
@Entity
@Table(name = "password_policy", catalog = "idm")
@Getter
@Setter
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * Enterprise code.
     */
    @Column(name = "ENTERPRISE_CODE", nullable = false, length = FOURTEEN)
    private String enterpriseCode;
    /**
     * Policy name.
     */
    @Column(name = "POLICY_NAME", nullable = false, length = FIFTY)
    private String policyName;
    /**
     * Description of the policy.
     */
    @Column(name = "DESCRIPTION", length = TWO_FIFTY_SIX)
    private String description;
    /**
     * Status of the policy.
     */
    @Column(name = "STATUS", length = 1)
    private Character status;
    /**
     * Created date of password policy.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    private Date createDate;
    /**
     * Last updated date of password policy.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    private Date lastUpdateDate;
    /**
     * Password policy attributes.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true,
        mappedBy = "passwordPolicy")
    private Set<PasswordPolicyAttrEntity> passwordPolicyAttrEntities = new HashSet<>(0);
}
