package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.Permission;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository of permission entity.
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
