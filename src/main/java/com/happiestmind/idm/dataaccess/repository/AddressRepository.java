package com.happiestmind.idm.dataaccess.repository;

import com.happiestmind.idm.dataaccess.entities.AddressEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository of Address entity.
 */
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
