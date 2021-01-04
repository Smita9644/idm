package com.happiestmind.idm.dataaccess.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Permission Entity.
 */
@Entity
@Table(name = "permission", catalog = "idm")
@Getter
@Setter
public class PermissionEntity implements java.io.Serializable {
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * Name of permission.
     */
    @Column(name = "NAME", nullable = false, length = FIFTY)
    private String name;
    /**
     * Description.
     */
    @Column(name = "DESCRIPTION", nullable = false, length = TWO_FIFTY_SIX)
    private String description;
    /**
     * Feature.
     */
    @Column(name = "FEATURE", nullable = false, length = FIFTY)
    private String feature;
    /**
     * Type.
     */
    @Column(name = "TYPE", nullable = false)
    private int type;
    /**
     * Status.
     */
    @Column(name = "STATUS", length = 1)
    private Character status;
    /**
     * Created Date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    private Date createDate;
    /**
     * Updated date.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    private Date lastUpdateDate;
    /**
     * Role permissions.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permission")
    @JsonIgnore
    private Set<RolePermissionsEntity> rolePermissionEntities = new HashSet<>(0);
}
