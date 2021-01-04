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
 * User Entity.
 */
@SuppressWarnings("checkstyle:MethodCount")
@Entity
@Table(name = "user", catalog = "idm")
@Getter
@Setter
public class UserEntity implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Length of  name.
     */
    public static final int FIFTY = 50;
    /**
     * Length of password and salt.
     */
    public static final int TWO_FIFTY_SIX = 256;
    /**
     * Length of email.
     */
    public static final int HUNDRED = 100;
    /**
     * Length of enterprise code.
     */
    public static final int FOURTEEN = 14;
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * User Name.
     */
    @Column(name = "USERNAME", nullable = false, length = FIFTY)
    private String username;
    /**
     * Email id.
     */
    @Column(name = "EMAIL_ID", nullable = false, length = HUNDRED)
    private String emailId;
    /**
     * Password.
     */
    @Column(name = "PASSWORD", length = TWO_FIFTY_SIX)
    private String password;
    /**
     * Salt.
     */
    @Column(name = "SALT", length = TWO_FIFTY_SIX)
    private String salt;
    /**
     * Password Created.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PASSWD_CREATED", length = NINETEEN)
    private Date passwdCreated;
    /**
     * Change password.
     */
    @Column(name = "CHANGE_PASSWD")
    private Boolean changePasswd;
    /**
     * Login Fail Count.
     */
    @Column(name = "LOGIN_FAIL_COUNT")
    private Integer loginFailCount;
    /**
     * Email Verified.
     */
    @Column(name = "EMAIL_VERIFIED")
    private Boolean emailVerified;
    /**
     * Enterprise code.
     */
    @Column(name = "ENTERPRISE_CODE", nullable = false, length = FOURTEEN)
    private String enterpriseCode;
    /**
     * Status.
     */
    @Column(name = "STATUS", length = 1)
    private Character status;
    /**
     * User type.
     */
    @Column(name = "USER_TYPE", nullable = false)
    private int userType;
    /**
     * Password Expiry.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PASSWORD_EXPIRY", length = NINETEEN)
    private Date passwordExpiry;
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
    /**
     * Last login date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN_DATE", length = NINETEEN)
    private Date lastLoginDate;
    /**
     * Name.
     */
    @Column(name = "NAME", nullable = false, length = FIFTY)
    private String name;
    /**
     * USer roles.
     */
    @OneToMany(fetch = FetchType.LAZY, targetEntity = UserRolesEntity.class,
        cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private Set<UserRolesEntity> userRoleEntities = new HashSet<>(0);
    /**
     * User password hist.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserPasswdHist> userPasswdHistEntities = new HashSet<>(0);
    /**
     * USer activation key.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserActivationKey> userActivationKeys = new HashSet<>(0);
}
