package com.happiestmind.idm.dataaccess.repository;

import java.util.List;

import com.happiestmind.idm.dataaccess.entities.PermissionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * Get distinct features.
     *
     * @return list of string
     */
    @Query(value = "select distinct feature from permission", nativeQuery = true)
    List<String> getDistinctFeature();

}
