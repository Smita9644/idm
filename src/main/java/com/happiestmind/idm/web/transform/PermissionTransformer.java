package com.happiestmind.idm.web.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.happiestmind.idm.dataaccess.entities.PermissionEntity;
import com.happiestmind.idm.web.model.Permission;

import org.springframework.stereotype.Component;

/**
 * Permission transformer.
 */
@Component
public class PermissionTransformer {
    /**
     * Convert list of permissions entity to permission model class.
     *
     * @param permissionEntities permissions entity
     * @return list permission
     */
    public List<Permission> toListOfPermissions(List<PermissionEntity> permissionEntities) {
        final List<Permission> permissions = new ArrayList<>();
        for (PermissionEntity permissionEntity : permissionEntities
        ) {
            permissions.add(Permission.builder().id(permissionEntity.getId())
                .name(permissionEntity.getName())
                .description(permissionEntity.getDescription())
                .status(permissionEntity.getStatus()).build());
        }
        return permissions;
    }

    /**
     * Conversion of permiision entity to permission.
     *
     * @param allPermissions map of all permissions
     * @return all permissions
     */
    public Map<String, List<Permission>> toAllPermissions(
        Map<String, List<PermissionEntity>> allPermissions) {
        final Map<String, List<Permission>> permissions = new HashMap<>();
        for (Map.Entry<String, List<PermissionEntity>> entry : allPermissions.entrySet()) {
            permissions.put(entry.getKey(), toListOfPermissions(entry.getValue()));
        }
        return permissions;
    }
}
