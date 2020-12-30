package com.happiestmind.idm.business.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import com.happiestmind.idm.dataaccess.entities.PermissionEntity;
import com.happiestmind.idm.dataaccess.entities.RoleEntity;
import com.happiestmind.idm.dataaccess.entities.RolePermissionsEntity;
import com.happiestmind.idm.dataaccess.repository.PermissionRepository;
import com.happiestmind.idm.dataaccess.repository.RolePermissionRepository;
import com.happiestmind.idm.dataaccess.repository.RoleRepository;
import com.happiestmind.idm.exception.EntityNotFoundException;
import com.happiestmind.idm.web.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Role service.
 */
@Service
public class RoleService {
    /**
     * Error message role entity not found.
     */
    public static final String ROLE_ENTITY_NOT_FOUND_FOR_GIVEN_ID =
        "Role entity not found for given id ";
    /**
     * Role repository.
     */
    private final RoleRepository roleRepository;

    /**
     * Permissions repository.
     */
    private final PermissionRepository permissionRepository;
    /**
     * Role permission repository.
     */
    private final RolePermissionRepository rolePermissionRepository;

    /**
     * Constructor for role service.
     *
     * @param roleRepository           role repository
     * @param permissionRepository     permissions repository
     * @param rolePermissionRepository role permission repository
     */
    @Autowired
    public RoleService(RoleRepository roleRepository,
                       PermissionRepository permissionRepository,
                       RolePermissionRepository rolePermissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionRepository = rolePermissionRepository;
    }

    /**
     * Create role.
     *
     * @param enterpriseCode enterprise code
     * @param role           role
     */
    @Transactional
    public void createRole(Role role, String enterpriseCode) {

        final RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(role.getName());
        roleEntity.setDescription(role.getDescription());
        roleEntity.setEnterpriseCode(enterpriseCode);
        roleRepository.save(roleEntity);

        for (Long id : role.getPermissionIds()) {
            final RolePermissionsEntity rolePermissionsEntity = new RolePermissionsEntity();
            rolePermissionsEntity.setRole(roleEntity);
            rolePermissionsEntity.setPermission(permissionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Permission not found for given id : " + id)
            ));
            rolePermissionRepository.save(rolePermissionsEntity);
        }
    }

    /**
     * Update role.
     *
     * @param roleId role id
     * @param role   role
     */
    public void updateRole(Role role, Long roleId) {
        final RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow(() -> {
            throw new EntityNotFoundException(ROLE_ENTITY_NOT_FOUND_FOR_GIVEN_ID + roleId);
        });
        roleEntity.setName(role.getName());
        roleEntity.setDescription(role.getDescription());

        final List<RolePermissionsEntity> rolePermissionsEntities = new ArrayList<>();
        for (Long id : role.getPermissionIds()) {
            final PermissionEntity permissionEntity = permissionRepository.findById(id).orElseThrow(
                () -> {
                    throw new EntityNotFoundException(PermissionEntity.class, id);
                });
            if (
                Objects.nonNull(rolePermissionRepository
                    .findByRoleAndPermission(roleEntity, permissionEntity))) {
                continue;
            }
            final RolePermissionsEntity rolePermissionsEntity = new RolePermissionsEntity();
            rolePermissionsEntity.setRole(roleEntity);
            rolePermissionsEntity.setPermission(permissionEntity);
            rolePermissionsEntities.add(rolePermissionsEntity);
        }
        roleEntity.setRolePermissionEntities(new HashSet<>(rolePermissionsEntities));
        roleRepository.save(roleEntity);
    }

    /**
     * Get list of roles for given enterprise.
     *
     * @param enterpriseCode enterprise code
     * @return list of role entity
     */
    public List<RoleEntity> getAllPermissionsForGivenEnterprise(String enterpriseCode) {
        return roleRepository.findByEnterpriseCode(enterpriseCode);
    }

    /**
     * Get role for given id.
     *
     * @param roleId role id
     * @return role entity
     */
    public RoleEntity getRoleForGivenId(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> {
            throw new EntityNotFoundException(ROLE_ENTITY_NOT_FOUND_FOR_GIVEN_ID + roleId);
        });
    }

    /**
     * Delete role by roleId.
     *
     * @param roleId role id.
     */
    public void deleteRole(Long roleId) {
        roleRepository.findById(roleId).orElseThrow(() -> {
            throw new EntityNotFoundException(ROLE_ENTITY_NOT_FOUND_FOR_GIVEN_ID + roleId);
        });
        roleRepository.deleteById(roleId);
    }
}
