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
 * PasswordPolicyAttr Entity.
 */
@Entity
@Table(name = "password_policy_attr", catalog = "idm")
@Getter
@Setter
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * Password policy.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POLICY_ID", nullable = false)
    private PasswordPolicyEntity passwordPolicy;
    /**
     * Attribute name.
     */
    @Column(name = "ATTR_NAME", length = FIFTY)
    private String attrName;
    /**
     * Attribute value.
     */
    @Column(name = "ATTR_VALUE", length = FIFTY)
    private String attrValue;
    /**
     * Created date.
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
