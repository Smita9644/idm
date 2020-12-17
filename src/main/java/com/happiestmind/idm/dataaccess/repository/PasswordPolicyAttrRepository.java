package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.PasswordPolicyAttr;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for password policy attr entity.
 */
public interface PasswordPolicyAttrRepository extends JpaRepository<PasswordPolicyAttr, Long> {
}
