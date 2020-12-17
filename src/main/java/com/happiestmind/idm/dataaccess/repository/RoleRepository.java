package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for Role entity.
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
