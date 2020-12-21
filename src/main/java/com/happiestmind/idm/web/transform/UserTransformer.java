package com.happiestmind.idm.web.transform;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.happiestmind.idm.dataaccess.entities.RolePermissionsEntity;
import com.happiestmind.idm.dataaccess.entities.UserEntity;
import com.happiestmind.idm.dataaccess.entities.UserRolesEntity;
import com.happiestmind.idm.web.model.User;

import org.springframework.stereotype.Component;

/**
 * User transformer.
 */
@Component
public class UserTransformer {
    /**
     * Conversion from UserEntity to user.
     *
     * @param userEntity user entity
     * @return user
     */
    public User toUser(UserEntity userEntity) {
        if (Objects.isNull(userEntity)) {
            return null;
        }
        return User.builder().name(userEntity.getName())
            .username(userEntity.getUsername())
            .userType(userEntity.getUserType())
            .status(userEntity.getStatus())
            .salt(userEntity.getSalt())
            .password(userEntity.getPassword())
            .passwordExpiry(userEntity.getPasswordExpiry())
            .passwdCreated(userEntity.getPasswdCreated())
            .loginFailCount(userEntity.getLoginFailCount())
            .changePasswd(userEntity.getChangePasswd())
            .emailId(userEntity.getEmailId())
            .emailVerified(userEntity.getEmailVerified())
            .enterpriseCode(userEntity.getEnterpriseCode())
            .lastLoginDate(userEntity.getLastLoginDate())
            .createDate(userEntity.getCreateDate())
            .lastUpdateDate(userEntity.getLastUpdateDate())
            .roles(toRoles(userEntity.getUserRoleEntities()))
            .permissions(toPermissions(userEntity.getUserRoleEntities()))
            .build();
    }

    private List<String> toPermissions(Set<UserRolesEntity> userRoleEntities) {
        final List<String> permissions = new ArrayList<>();
        if (userRoleEntities != null) {
            for (UserRolesEntity userRolesEntity : userRoleEntities
            ) {
                for (RolePermissionsEntity permissionEntity : userRolesEntity.getRole()
                    .getRolePermissionEntities()
                ) {
                    permissions.add(permissionEntity.getPermission().getName());
                }
            }
        }
        return permissions;
    }

    private List<String> toRoles(Set<UserRolesEntity> userRoleEntities) {
        final List<String> userRole = new ArrayList<>();
        if (userRoleEntities != null) {
            for (UserRolesEntity userRolesEntity : userRoleEntities
            ) {
                userRole.add(userRolesEntity.getRole().getName());
            }
        }
        return userRole;
    }

    /**
     * Convert list of user entity into user.
     *
     * @param userEntities list of user entity
     * @return users
     */
    public List<User> toUsers(List<UserEntity> userEntities) {
        final List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities
        ) {
            users.add(toUser(userEntity));
        }
        return users;
    }
}
