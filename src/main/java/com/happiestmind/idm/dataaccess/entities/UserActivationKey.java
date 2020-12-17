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
 * UserActivationKey Entity.
 */
@Entity
@Table(name = "user_activation_key", catalog = "idm")
public class UserActivationKey implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Length of activation key.
     */
    public static final int HUNDRED = 100;
    /**
     * Id.
     */
    private Long id;
    /**
     * User.
     */
    private User user;
    /**
     * Activation key.
     */
    private String activationKey;
    /**
     * Expiry date.
     */
    private Date expiryDate;
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
    public UserActivationKey() {
    }

    /**
     * Parameterised constructor.
     *
     * @param user           user
     * @param activationKey  activation key
     * @param createDate     create date
     * @param lastUpdateDate last updated date
     */
    public UserActivationKey(User user, String activationKey, Date createDate,
                             Date lastUpdateDate) {
        this.user = user;
        this.activationKey = activationKey;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Parameterised constructor.
     *
     * @param user           user
     * @param activationKey  activation key
     * @param expiryDate     expiry key
     * @param createDate     created date
     * @param lastUpdateDate last updated date
     */
    public UserActivationKey(User user, String activationKey, Date expiryDate, Date createDate,
                             Date lastUpdateDate) {
        this.user = user;
        this.activationKey = activationKey;
        this.expiryDate = expiryDate;
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
     * Set Id to the user activation key entity.
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
     * Set User.
     *
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get Activation Key.
     *
     * @return activation key.
     */
    @Column(name = "ACTIVATION_KEY", nullable = false, length = HUNDRED)
    public String getActivationKey() {
        return this.activationKey;
    }

    /**
     * Set Activation key.
     *
     * @param activationKey activation key
     */
    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    /**
     * Get expiry date.
     *
     * @return expiry date of user activation key.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRY_DATE", length = NINETEEN)
    public Date getExpiryDate() {
        return this.expiryDate;
    }

    /**
     * Set expiry date to user activation key.
     *
     * @param expiryDate expiry date
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Get created date of user activation key.
     *
     * @return created date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set Create date to user activation key.
     *
     * @param createDate create date
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
