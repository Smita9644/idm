package com.happiestmind.idm.dataaccess.repository;

import java.util.Set;

import com.happiestmind.idm.dataaccess.entities.PermissionEntity;
import com.happiestmind.idm.dataaccess.entities.RoleEntity;
import com.happiestmind.idm.dataaccess.entities.RolePermissionsEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Jpa repository for role permission entity.
 */
public interface RolePermissionRepository extends JpaRepository<RolePermissionsEntity, Long> {
    /**
     * Find by role and permission.
     *
     * @param roleEntity       role entity
     * @param permissionEntity permission entity
     * @return role permission entity
     */
    RolePermissionsEntity findByRoleAndPermission(RoleEntity roleEntity,
                                                  PermissionEntity permissionEntity);

    /**
     * To delete the unrelated role permissions.
     *
     * @param roleId        role id
     * @param permissionIds permission Ids
     * @return Set Of Ids
     */
    @Query(value = "delete from role_permissions where "
        + "ROLE_ID =:roleId and PERMISSION_ID not IN (:permissionIds)", nativeQuery = true)
    Set<Long> deleteUnRelatedRolePermission(Long roleId, Set<Long> permissionIds);
}
