package com.happiestmind.idm.dataaccess.repository;

import java.util.List;

import com.happiestmind.idm.dataaccess.entities.PermissionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository of permission entity.
 */
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    /**
     * Find permissions by features.
     *
     * @param user user
     * @return list of permissions for given feature.
     */
    List<PermissionEntity> findByFeature(String user);
}
