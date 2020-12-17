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
 * Permission Entity.
 */
@Entity
@Table(name = "permission", catalog = "idm")
public class Permission implements java.io.Serializable {
    /**
     * Length of date.
     */
    public static final int NINETEEN = 19;
    /**
     * Length of  name and feature of permission.
     */
    public static final int FIFTY = 50;
    /**
     * Length of description.
     */
    public static final int TWO_FIFTY_SIX = 256;
    /**
     * Id.
     */
    private Long id;
    /**
     * Name of permission.
     */
    private String name;
    /**
     * Description.
     */
    private String description;
    /**
     * Feature.
     */
    private String feature;
    /**
     * Type.
     */
    private int type;
    /**
     * Status.
     */
    private Character status;
    /**
     * Created Date.
     */
    private Date createDate;
    /**
     * Updated date.
     */
    private Date lastUpdateDate;
    /**
     * Role permissions.
     */
    private Set<RolePermissions> rolePermissionEntities = new HashSet(0);

    /**
     * Parameter less constructor.
     */
    public Permission() {
    }

    /**
     * Parameterised constructor.
     *
     * @param name            name
     * @param description     description
     * @param feature         feature
     * @param type            type
     * @param status          status
     * @param createDate      createDate
     * @param lastUpdateDate  lastUpdateDate
     * @param rolePermissionEntities rolePermissions
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public Permission(String name, String description, String feature, int type, Character status,
                      Date createDate,
                      Date lastUpdateDate, Set<RolePermissions> rolePermissionEntities) {
        this.name = name;
        this.description = description;
        this.feature = feature;
        this.type = type;
        this.status = status;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.rolePermissionEntities = rolePermissionEntities;
    }

    /**
     * Get id.
     *
     * @return return id of permission
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    /**
     * Set id of permission.
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get name of permission.
     *
     * @return name of permission
     */
    @Column(name = "NAME", nullable = false, length = FIFTY)
    public String getName() {
        return this.name;
    }

    /**
     * Set name of permission.
     *
     * @param name name of permission
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description.
     *
     * @return description of the permission
     */
    @Column(name = "DESCRIPTION", nullable = false, length = TWO_FIFTY_SIX)
    public String getDescription() {
        return this.description;
    }

    /**
     * Set description to permission.
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get feature of the permission.
     *
     * @return feature of permission.
     */
    @Column(name = "FEATURE", nullable = false, length = FIFTY)
    public String getFeature() {
        return this.feature;
    }

    /**
     * Set feature to the permission.
     *
     * @param feature feature
     */
    public void setFeature(String feature) {
        this.feature = feature;
    }

    /**
     * Get type of permission.
     *
     * @return type of permission
     */
    @Column(name = "TYPE", nullable = false)
    public int getType() {
        return this.type;
    }

    /**
     * Set type to the permission.
     *
     * @param type type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Get status of the permission.
     *
     * @return status of the permission
     */
    @Column(name = "STATUS", length = 1)
    public Character getStatus() {
        return this.status;
    }

    /**
     * Set status to the permission.
     *
     * @param status status
     */
    public void setStatus(Character status) {
        this.status = status;
    }

    /**
     * Get created date of permission.
     *
     * @return created date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set created date to permission.
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
     * @param lastUpdateDate last upated date
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get role permissions.
     *
     * @return role permissions
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permission")
    public Set<RolePermissions> getRolePermissionEntities() {
        return this.rolePermissionEntities;
    }

    /**
     * Set role permissions.
     *
     * @param rolePermissionEntities rolePermissions
     */
    public void setRolePermissionEntities(Set<RolePermissions> rolePermissionEntities) {
        this.rolePermissionEntities = rolePermissionEntities;
    }

}
