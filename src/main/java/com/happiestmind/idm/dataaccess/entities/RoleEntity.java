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
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Role Entity.
 */
@Entity
@Table(name = "role", catalog = "idm", uniqueConstraints = @UniqueConstraint(columnNames = {"NAME",
    "ENTERPRISE_CODE"}))
@EqualsAndHashCode
@Getter
@Setter
public class RoleEntity implements java.io.Serializable {
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * Name of the role.
     */
    @Column(name = "NAME", nullable = false, length = FIFTY)
    private String name;
    /**
     * Description.
     */
    @Column(name = "DESCRIPTION", length = TWO_FIFTY_SIX)
    private String description;
    /**
     * Status.
     */
    @Column(name = "STATUS", length = 1)
    private Character status;
    /**
     * Enterprise code.
     */
    @Column(name = "ENTERPRISE_CODE", length = FOURTEEN)
    private String enterpriseCode;
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
    /**
     * User roles.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
        targetEntity = UserRolesEntity.class, orphanRemoval = true, mappedBy = "role")
    private Set<UserRolesEntity> userRoleEntities = new HashSet<>(0);
    /**
     * Role permissions.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
        targetEntity = RolePermissionsEntity.class, orphanRemoval = true, mappedBy = "role")
    private Set<RolePermissionsEntity> rolePermissionEntities = new HashSet<>(0);

}
