package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.UserPasswdHistEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for User password Hist Entity.
 */
public interface UserPasswdHistRepository extends JpaRepository<UserPasswdHistEntity, Long> {
}
