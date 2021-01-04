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
 * Enterprise Entity.
 */
@Entity
@Table(name = "enterprise", catalog = "idm")
@Getter
@Setter
public class EnterpriseEntity implements java.io.Serializable {
    /**
     * Size for string field.
     */
    private static final int HUNDRED = 100;
    /**
     * Length for date field.
     */
    private static final int NINETEEN = 19;
    /**
     * Length for enterprise code.
     */
    private static final int FOURTEEN = 14;
    /**
     * Enterprise id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    /**
     * Enterprise name.
     */
    @Column(name = "NAME", length = HUNDRED)
    private String name;
    /**
     * Enterprise status.
     */
    @Column(name = "STATUS", length = 1)
    private Character status;
    /**
     * Code for enterprise.
     */
    @Column(name = "ENTERPRISE_CODE", length = FOURTEEN)
    private String enterpriseCode;
    /**
     * Enterprise type.
     */
    @Column(name = "ENTERPRISE_TYPE", nullable = false)
    private int enterpriseType;
    /**
     * Created date of enterprise.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, length = NINETEEN)
    private Date createDate;
    /**
     * Last updated date of enterprise.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE", nullable = false, length = NINETEEN)
    private Date lastUpdateDate;
    /**
     * Addresses for the enterprise.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
    @JsonIgnore
    private Set<AddressEntity> addressEntities = new HashSet<>(0);
}
