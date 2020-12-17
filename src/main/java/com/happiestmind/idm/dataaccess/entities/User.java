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
 * User Entity.
 */
@SuppressWarnings("checkstyle:MethodCount")
@Entity
@Table(name = "user", catalog = "idm")
public class User implements java.io.Serializable {
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
    private Long id;
    /**
     * User Name.
     */
    private String username;
    /**
     * Email id.
     */
    private String emailId;
    /**
     * Password.
     */
    private String password;
    /**
     * Salt.
     */
    private String salt;
    /**
     * Password Created.
     */
    private Date passwdCreated;
    /**
     * Change password.
     */
    private Boolean changePasswd;
    /**
     * Login Fail Count.
     */
    private Integer loginFailCount;
    /**
     * Email Verified.
     */
    private Boolean emailVerified;
    /**
     * Enterprise code.
     */
    private String enterpriseCode;
    /**
     * Status.
     */
    private Character status;
    /**
     * User type.
     */
    private int userType;
    /**
     * Password Expiry.
     */
    private Date passwordExpiry;
    /**
     * Create date.
     */
    private Date createDate;
    /**
     * Last updated date.
     */
    private Date lastUpdateDate;
    /**
     * Last login date.
     */
    private Date lastLoginDate;
    /**
     * Name.
     */
    private String name;
    /**
     * USer roles.
     */
    private Set<UserRoles> userRoleEntities = new HashSet(0);
    /**
     * User password hist.
     */
    private Set<UserPasswdHist> userPasswdHistEntities = new HashSet(0);
    /**
     * USer activation key.
     */
    private Set<UserActivationKey> userActivationKeys = new HashSet(0);

    /**
     * Parameter less constructor.
     */
    public User() {
    }

    /**
     * Parameterised constructor.
     *
     * @param username       username
     * @param emailId        email id
     * @param enterpriseCode enterprise code
     * @param userType       user type
     * @param createDate     create date
     * @param lastUpdateDate last update date
     * @param name           name
     */
    public User(String username, String emailId, String enterpriseCode, int userType,
                Date createDate,
                Date lastUpdateDate, String name) {
        this.username = username;
        this.emailId = emailId;
        this.enterpriseCode = enterpriseCode;
        this.userType = userType;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.name = name;
    }

    /**
     * Paramterised constructor.
     *
     * @param username           username
     * @param emailId            email id
     * @param password           password
     * @param salt               salt
     * @param passwdCreated      password created
     * @param changePasswd       change password
     * @param loginFailCount     login fail count
     * @param emailVerified      email verified
     * @param enterpriseCode     enter prise code
     * @param status             status
     * @param userType           user type
     * @param passwordExpiry     password expiry
     * @param createDate         create date
     * @param lastUpdateDate     last update date
     * @param lastLoginDate      last login time
     * @param name               name
     * @param userRoleEntities          user roles
     * @param userPasswdHistEntities    user password hist
     * @param userActivationKeys user activation key
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public User(String username, String emailId, String password, String salt, Date passwdCreated,
                Boolean changePasswd,
                Integer loginFailCount, Boolean emailVerified, String enterpriseCode,
                Character status, int userType,
                Date passwordExpiry, Date createDate, Date lastUpdateDate, Date lastLoginDate,
                String name, Set<UserRoles> userRoleEntities,
                Set<UserPasswdHist> userPasswdHistEntities, Set<UserActivationKey> userActivationKeys) {
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.salt = salt;
        this.passwdCreated = passwdCreated;
        this.changePasswd = changePasswd;
        this.loginFailCount = loginFailCount;
        this.emailVerified = emailVerified;
        this.enterpriseCode = enterpriseCode;
        this.status = status;
        this.userType = userType;
        this.passwordExpiry = passwordExpiry;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastLoginDate = lastLoginDate;
        this.name = name;
        this.userRoleEntities = userRoleEntities;
        this.userPasswdHistEntities = userPasswdHistEntities;
        this.userActivationKeys = userActivationKeys;
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
     * Get user name.
     *
     * @return user name.
     */
    @Column(name = "USERNAME", nullable = false, length = FIFTY)
    public String getUsername() {
        return this.username;
    }

    /**
     * Set User name.
     *
     * @param username user name
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get email id.
     *
     * @return email id
     */
    @Column(name = "EMAIL_ID", nullable = false, length = HUNDRED)
    public String getEmailId() {
        return this.emailId;
    }

    /**
     * Set email id.
     *
     * @param emailId email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Get password.
     *
     * @return password.
     */
    @Column(name = "PASSWORD", length = TWO_FIFTY_SIX)
    public String getPassword() {
        return this.password;
    }

    /**
     * Set password.
     *
     * @param password password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get salt.
     *
     * @return salt.
     */
    @Column(name = "SALT", length = TWO_FIFTY_SIX)
    public String getSalt() {
        return this.salt;
    }

    /**
     * Set salt.
     *
     * @param salt salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Get password created.
     *
     * @return password created
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PASSWD_CREATED", length = NINETEEN)
    public Date getPasswdCreated() {
        return this.passwdCreated;
    }

    /**
     * Set password created.
     *
     * @param passwdCreated password Created.
     */
    public void setPasswdCreated(Date passwdCreated) {
        this.passwdCreated = passwdCreated;
    }

    /**
     * Get change password.
     *
     * @return get change password.
     */
    @Column(name = "CHANGE_PASSWD")
    public Boolean getChangePasswd() {
        return this.changePasswd;
    }

    /**
     * Set change password.
     *
     * @param changePasswd change password
     */
    public void setChangePasswd(Boolean changePasswd) {
        this.changePasswd = changePasswd;
    }

    /**
     * Get login fail count.
     *
     * @return login fail count
     */
    @Column(name = "LOGIN_FAIL_COUNT")
    public Integer getLoginFailCount() {
        return this.loginFailCount;
    }

    /**
     * Set login fail count.
     *
     * @param loginFailCount login fail count.
     */
    public void setLoginFailCount(Integer loginFailCount) {
        this.loginFailCount = loginFailCount;
    }

    /**
     * Get email verified.
     *
     * @return email verified
     */
    @Column(name = "EMAIL_VERIFIED")
    public Boolean getEmailVerified() {
        return this.emailVerified;
    }

    /**
     * Set email verified.
     *
     * @param emailVerified email verified
     */
    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    /**
     * Get enterprise code.
     *
     * @return enterprise code.
     */
    @Column(name = "ENTERPRISE_CODE", nullable = false, length = FOURTEEN)
    public String getEnterpriseCode() {
        return this.enterpriseCode;
    }

    /**
     * Set enterprise code.
     *
     * @param enterpriseCode enterprise code.
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * Get status.
     *
     * @return status.
     */
    @Column(name = "STATUS", length = 1)
    public Character getStatus() {
        return this.status;
    }

    /**
     * Set status.
     *
     * @param status status
     */
    public void setStatus(Character status) {
        this.status = status;
    }

    /**
     * Get user type.
     *
     * @return user type
     */
    @Column(name = "USER_TYPE", nullable = false)
    public int getUserType() {
        return this.userType;
    }

    /**
     * Set user type.
     *
     * @param userType user type
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * Get password expiry.
     *
     * @return password expiry
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PASSWORD_EXPIRY", length = NINETEEN)
    public Date getPasswordExpiry() {
        return this.passwordExpiry;
    }

    /**
     * Set password Expiry.
     *
     * @param passwordExpiry password expiry.
     */
    public void setPasswordExpiry(Date passwordExpiry) {
        this.passwordExpiry = passwordExpiry;
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
     * Get updated date.
     *
     * @return updated date
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

    /**
     * Get last login date.
     *
     * @return last login date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_LOGIN_DATE", length = NINETEEN)
    public Date getLastLoginDate() {
        return this.lastLoginDate;
    }

    /**
     * Set last login date.
     *
     * @param lastLoginDate last login date
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * Get name.
     *
     * @return name
     */
    @Column(name = "NAME", nullable = false, length = FIFTY)
    public String getName() {
        return this.name;
    }

    /**
     * Set name.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get user roles.
     *
     * @return user roles
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<UserRoles> getUserRoleEntities() {
        return this.userRoleEntities;
    }

    /**
     * Set user roles.
     *
     * @param userRoleEntities user roles
     */
    public void setUserRoleEntities(Set<UserRoles> userRoleEntities) {
        this.userRoleEntities = userRoleEntities;
    }

    /**
     * Get user password history.
     *
     * @return user password history
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<UserPasswdHist> getUserPasswdHistEntities() {
        return this.userPasswdHistEntities;
    }

    /**
     * Set user password History.
     *
     * @param userPasswdHistEntities user password hist
     */
    public void setUserPasswdHistEntities(Set<UserPasswdHist> userPasswdHistEntities) {
        this.userPasswdHistEntities = userPasswdHistEntities;
    }

    /**
     * Get user activation keys.
     *
     * @return user activation key
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<UserActivationKey> getUserActivationKeys() {
        return this.userActivationKeys;
    }

    /**
     * Set user activation keyys.
     *
     * @param userActivationKeys user activation keys
     */
    public void setUserActivationKeys(Set<UserActivationKey> userActivationKeys) {
        this.userActivationKeys = userActivationKeys;
    }

}
