package com.happiestmind.idm.business.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.happiestmind.idm.dataaccess.entities.PermissionEntity;
import com.happiestmind.idm.dataaccess.repository.PermissionRepository;
import com.happiestmind.idm.exception.EntityNotFoundException;

import org.springframework.stereotype.Service;

/**
 * Permissions service.
 */
@Service
public class PermissionService {
    /**
     * Permissions repository.
     */
    private final PermissionRepository permissionRepository;

    /**
     * Permissions constructor.
     *
     * @param permissionRepository permission repository.
     */
    public PermissionService(
        PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    /**
     * Get all permissions.
     *
     * @return all permissions
     */
    public Map<String, List<PermissionEntity>> getAllPermissions() {
        return permissionRepository.findAll().stream()
            .collect(Collectors.groupingBy(PermissionEntity::getFeature));
    }

    /**
     * Get list of permissions for given feature.
     *
     * @param feature feature
     * @return list of permissions
     */
    public Map<String, List<PermissionEntity>> getPermissionsForGivenFeature(String feature) {
        final List<String> convertedFeatureList = Arrays.asList(feature.split(",", -1));
        final Map<String, List<PermissionEntity>> allPermissions =
            new HashMap<>();
        for (String aFeature : convertedFeatureList) {
            final List<PermissionEntity> permissionEntities =
                permissionRepository.findByFeature(aFeature);
            if (permissionEntities.isEmpty()) {
                throw new EntityNotFoundException(
                    "Permission entity does not exits for feature " + aFeature);
            }
            allPermissions.put(aFeature, permissionRepository.findByFeature(aFeature));
        }
        return allPermissions;
    }
}
