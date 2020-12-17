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
 * UserPasswdHist Entity.
 */
@Entity
@Table(name = "user_passwd_hist", catalog = "idm")
public class UserPasswdHist implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Length of salt and password.
     */
    public static final int TWO_FIFTY_SIX = 256;
    /**
     * Id.
     */
    private Long id;
    /**
     * User.
     */
    private User user;
    /**
     * Password.
     */
    private String password;
    /**
     * Salt.
     */
    private String salt;
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
    public UserPasswdHist() {
    }

    /**
     * Parameterised constructor.
     *
     * @param user           user
     * @param password       password
     * @param createDate     created date
     * @param lastUpdateDate last updated date
     */
    public UserPasswdHist(User user, String password, Date createDate, Date lastUpdateDate) {
        this.user = user;
        this.password = password;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Parameterised constructor.
     *
     * @param user           user
     * @param password       password
     * @param salt           salt
     * @param createDate     created date
     * @param lastUpdateDate last updated date
     */
    public UserPasswdHist(User user, String password, String salt, Date createDate,
                          Date lastUpdateDate) {
        this.user = user;
        this.password = password;
        this.salt = salt;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get ID.
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
     * Get user.
     *
     * @return user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    public User getUser() {
        return this.user;
    }

    /**
     * Set user.
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get password.
     *
     * @return password
     */
    @Column(name = "PASSWORD", nullable = false, length = TWO_FIFTY_SIX)
    public String getPassword() {
        return this.password;
    }

    /**
     * Set password.
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get salt.
     *
     * @return salt
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
     * @param lastUpdateDate last update date
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
