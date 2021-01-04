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
 * UserPasswdHist Entity.
 */
@Entity
@Table(name = "user_passwd_hist", catalog = "idm")
@Getter
@Setter
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
     * Password.
     */
    @Column(name = "PASSWORD", nullable = false, length = TWO_FIFTY_SIX)
    private String password;
    /**
     * Salt.
     */
    @Column(name = "SALT", length = TWO_FIFTY_SIX)
    private String salt;
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
