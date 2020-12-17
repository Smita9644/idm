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

/**
 * UserRoles Entity.
 */
@Entity
@Table(name = "user_roles", catalog = "idm")
public class UserRoles implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Id.
     */
    private Long id;
    /**
     * Role.
     */
    private Role role;
    /**
     * User.
     */
    private User user;
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
    public UserRoles() {
    }

    /**
     * Parameterised constructor.
     *
     * @param role           role
     * @param user           user
     * @param createDate     created date
     * @param lastUpdateDate last update date
     */
    public UserRoles(Role role, User user, Date createDate, Date lastUpdateDate) {
        this.role = role;
        this.user = user;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get id.
     *
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Get role.
     *
     * @return role
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    public Role getRole() {
        return this.role;
    }

    /**
     * Set role.
     *
     * @param role role
     */
    public void setRole(Role role) {
        this.role = role;
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
     * Get create date.
     *
     * @return create date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set create date.
     *
     * @param createDate create date.
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
     * @param lastUpdateDate last update Date.
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
