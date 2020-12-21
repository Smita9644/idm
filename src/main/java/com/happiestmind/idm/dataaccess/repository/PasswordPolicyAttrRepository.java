package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.PasswordPolicyAttrEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for password policy attr entity.
 */
public interface PasswordPolicyAttrRepository extends JpaRepository<PasswordPolicyAttrEntity, Long> {
}
