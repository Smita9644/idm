package com.happiestmind.idm.dataaccess.repository;

import java.util.List;

import com.happiestmind.idm.dataaccess.entities.PasswordPolicyEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for password policy entity.
 */
public interface PasswordPolicyRepository extends JpaRepository<PasswordPolicyEntity, Long> {
    /**
     * Find password policy by enterprise code.
     *
     * @param enterpriseCode enterprise code
     * @return list of password policy entity
     */
    List<PasswordPolicyEntity> findByEnterpriseCode(String enterpriseCode);
}
