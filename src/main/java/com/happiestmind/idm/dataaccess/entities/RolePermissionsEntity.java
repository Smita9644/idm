package com.happiestmind.idm.dataaccess.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RolePermissions Entity.
 */
@Entity
@Table(name = "role_permissions", catalog = "idm")
public class RolePermissionsEntity implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Id.
     */
    private Long id;
    /**
     * Permission.
     */
    private PermissionEntity permission;
    /**
     * Role.
     */
    private RoleEntity role;
    /**
     * Create date.
     */
    private Date createDate;
    /**
     * Last updated date.
     */
    private Date lastUpdateDate;

    /**
     * Parameter less constructor.
     */
    public RolePermissionsEntity() {
    }

    /**
     * Parameterised constructor.
     *
     * @param permissionEntity     permission
     * @param roleEntity           role
     * @param createDate     created date
     * @param lastUpdateDate last update date
     */
    public RolePermissionsEntity(PermissionEntity permissionEntity, RoleEntity roleEntity, Date createDate, Date lastUpdateDate) {
        this.permission = permissionEntity;
        this.role = roleEntity;
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
     * Set id.
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get permissions.
     *
     * @return permissions
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERMISSION_ID", nullable = false)
    public PermissionEntity getPermission() {
        return this.permission;
    }

    /**
     * Set permissions.
     *
     * @param permissionEntity permissions
     */
    public void setPermission(PermissionEntity permissionEntity) {
        this.permission = permissionEntity;
    }

    /**
     * Get role.
     *
     * @return role
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    public RoleEntity getRole() {
        return this.role;
    }

    /**
     * Set role.
     *
     * @param roleEntity role
     */
    public void setRole(RoleEntity roleEntity) {
        this.role = roleEntity;
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
     * Get last update date.
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
     * @param lastUpdateDate last updated date.
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
