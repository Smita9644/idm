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
import javax.persistence.UniqueConstraint;

/**
 * Role Entity.
 */
@Entity
@Table(name = "role", catalog = "idm", uniqueConstraints = @UniqueConstraint(columnNames = {"NAME",
    "ENTERPRISE_CODE"}))
public class Role implements java.io.Serializable {
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
     * Enterprise code.
     */
    public static final int FOURTEEN = 14;
    /**
     * Id.
     */
    private Long id;
    /**
     * Name of the role.
     */
    private String name;
    /**
     * Description.
     */
    private String description;
    /**
     * Status.
     */
    private Character status;
    /**
     * Enterprise code.
     */
    private String enterpriseCode;
    /**
     * Created date.
     */
    private Date createDate;
    /**
     * Last updated date.
     */
    private Date lastUpdateDate;
    /**
     * User roles.
     */
    private Set<UserRoles> userRoles = new HashSet(0);
    /**
     * Role permissions.
     */
    private Set<RolePermissions> rolePermissions = new HashSet(0);

    /**
     * Parameter less constructor for role entity.
     */
    public Role() {
    }

    /**
     * Parametrised constructor for role.
     *
     * @param name            name
     * @param description     description
     * @param status          status
     * @param enterpriseCode  enterpriseCode
     * @param createDate      createDate
     * @param lastUpdateDate  lastUpdateDate
     * @param userRoles       userRoleses
     * @param rolePermissions rolePermissions
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public Role(String name, String description, Character status, String enterpriseCode,
                Date createDate,
                Date lastUpdateDate, Set<UserRoles> userRoles,
                Set<RolePermissions> rolePermissions) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.enterpriseCode = enterpriseCode;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.userRoles = userRoles;
        this.rolePermissions = this.rolePermissions;
    }

    /**
     * Get id of role.
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
     * Set id to the role.
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get name of the role.
     *
     * @return name of role
     */
    @Column(name = "NAME", nullable = false, length = FIFTY)
    public String getName() {
        return this.name;
    }

    /**
     * Set name to role.
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description of the role.
     *
     * @return description
     */
    @Column(name = "DESCRIPTION", length = TWO_FIFTY_SIX)
    public String getDescription() {
        return this.description;
    }

    /**
     * Set description to the role.
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get status of the role.
     *
     * @return status of the role
     */
    @Column(name = "STATUS", length = 1)
    public Character getStatus() {
        return this.status;
    }

    /**
     * Set status of the role.
     *
     * @param status status
     */
    public void setStatus(Character status) {
        this.status = status;
    }

    /**
     * Get enterprice code.
     *
     * @return enterprise code
     */
    @Column(name = "ENTERPRISE_CODE", length = FOURTEEN)
    public String getEnterpriseCode() {
        return this.enterpriseCode;
    }

    /**
     * Set enterprise code.
     *
     * @param enterpriseCode enterprise code
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * Get created date of the role.
     *
     * @return created date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * Set created daate to the role.
     *
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get last updated date of the role.
     *
     * @return last updated date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    /**
     * Set last update date.
     *
     * @param lastUpdateDate last update date
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * Get user roles.
     *
     * @return user roles
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<UserRoles> getUserRoles() {
        return this.userRoles;
    }

    /**
     * Set user roles.
     *
     * @param userRoles user roles.
     */
    public void setUserRoles(Set<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * Get role permissions.
     *
     * @return role permissions
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public Set<RolePermissions> getRolePermissions() {
        return this.rolePermissions;
    }

    /**
     * Set role permissions.
     *
     * @param rolePermissions role permissions
     */
    public void setRolePermissions(Set<RolePermissions> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

}
