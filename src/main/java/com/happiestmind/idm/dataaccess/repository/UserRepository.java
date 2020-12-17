package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for user entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
