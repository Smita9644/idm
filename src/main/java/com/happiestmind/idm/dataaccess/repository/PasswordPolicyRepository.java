package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.PasswordPolicyEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for password policy entity.
 */
public interface PasswordPolicyRepository extends JpaRepository<PasswordPolicyEntity, Long> {
}
