package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.UserRoles;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for user roles entity.
 */
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
}
