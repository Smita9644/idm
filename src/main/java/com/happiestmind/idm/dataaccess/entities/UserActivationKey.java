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
 * UserActivationKey Entity.
 */
@Entity
@Table(name = "user_activation_key", catalog = "idm")
@Getter
@Setter
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * User.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;
    /**
     * Activation key.
     */
    @Column(name = "ACTIVATION_KEY", nullable = false, length = HUNDRED)
    private String activationKey;
    /**
     * Expiry date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRY_DATE", length = NINETEEN)
    private Date expiryDate;
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
