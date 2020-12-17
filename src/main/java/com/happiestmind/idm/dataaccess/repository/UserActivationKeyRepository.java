package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.UserActivationKey;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for User Activation key entity.
 */
public interface UserActivationKeyRepository extends JpaRepository<UserActivationKey, Long> {
}
