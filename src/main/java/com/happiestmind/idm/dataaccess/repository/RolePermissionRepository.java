package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.RolePermissions;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for role permission entity.
 */
public interface RolePermissionRepository extends JpaRepository<RolePermissions, Long> {
}
