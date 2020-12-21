package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.RolePermissionsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for role permission entity.
 */
public interface RolePermissionRepository extends JpaRepository<RolePermissionsEntity, Long> {
}
