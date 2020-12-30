package com.happiestmind.idm.web.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.happiestmind.idm.dataaccess.entities.RoleEntity;
import com.happiestmind.idm.dataaccess.entities.RolePermissionsEntity;
import com.happiestmind.idm.web.model.Permission;
import com.happiestmind.idm.web.model.RolePermission;
import com.happiestmind.idm.web.model.RolePermissionsWithFeature;

import org.springframework.stereotype.Component;

/**
 * Role permission transformer.
 */
@Component
public class RolePermissionTransformer {
    /**
     * Conversion of list of role entity into role permission.
     *
     * @param roleEntities role entities
     * @return list of role permission
     */
    public List<RolePermission> toListOfRolePermission(
        List<RoleEntity> roleEntities) {
        final List<RolePermission> rolePermissions = new ArrayList<>();
        for (RoleEntity roleEntity : roleEntities
        ) {
            rolePermissions.add(RolePermission.builder().name(roleEntity.getName())
                .description(roleEntity.getDescription())
                .id(roleEntity.getId())
                .status(roleEntity.getStatus())
                .permissions(toPermission(roleEntity.getRolePermissionEntities())).build());
        }
        return rolePermissions;
    }

    private List<Permission> toPermission(Set<RolePermissionsEntity> rolePermissionEntities) {
        final List<Permission> permissions = new ArrayList<>();
        for (RolePermissionsEntity rolePermissionsEntity : rolePermissionEntities
        ) {
            permissions.add(Permission.builder().id(rolePermissionsEntity.getPermission().getId())
                .description(rolePermissionsEntity.getPermission().getDescription())
                .name(rolePermissionsEntity.getPermission().getName())
                .status(rolePermissionsEntity.getPermission().getStatus())
                .build());
        }
        return permissions;
    }

    /**
     * Convert role entity into role permission.
     *
     * @param roleEntity role entity
     * @return role permission
     */
    public RolePermissionsWithFeature toRolePermission(RoleEntity roleEntity) {
        return RolePermissionsWithFeature.builder()
            .name(roleEntity.getName())
            .description(roleEntity.getDescription())
            .id(roleEntity.getId())
            .status(roleEntity.getStatus())
            .permissionsByFeature(toPermissions(roleEntity.getRolePermissionEntities())).build();
    }

    private Map<String, List<Permission>> toPermissions(
        Set<RolePermissionsEntity> rolePermissionEntities) {
        final Map<String, List<Permission>> permissions = new HashMap<>();
        final Set<String> features = new HashSet<>();
        for (RolePermissionsEntity rolePermissionsEntity : rolePermissionEntities) {
            features.add(rolePermissionsEntity.getPermission().getFeature());
        }
        for (String feature : features) {
            final List<Permission> p = new ArrayList<>();
            for (RolePermissionsEntity rolePermissionsEntity : rolePermissionEntities) {
                if (feature.equals(rolePermissionsEntity.getPermission().getFeature())) {
                    p.add(Permission.builder().id(rolePermissionsEntity.getPermission().getId())
                        .description(rolePermissionsEntity.getPermission().getDescription())
                        .name(rolePermissionsEntity.getPermission().getName())
                        .status(rolePermissionsEntity.getPermission().getStatus())
                        .build());
                }
            }
            permissions.put(feature, p);
        }
        return permissions;
    }
}
