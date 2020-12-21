package com.happiestmind.idm.dataaccess.repository;


import com.happiestmind.idm.dataaccess.entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for user entity.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Find user by enterprise code.
     *
     * @param enterpriseCode enterprise code
     * @return User
     */
    UserEntity findByEnterpriseCode(String enterpriseCode);
}
