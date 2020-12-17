package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.WeakPassword;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for Weak Password entity.
 */
public interface WeakPasswordRepository extends JpaRepository<WeakPassword, Long> {
}
