package com.happiestmind.idm.business.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import com.happiestmind.idm.dataaccess.entities.RoleEntity;
import com.happiestmind.idm.dataaccess.entities.UserEntity;
import com.happiestmind.idm.dataaccess.entities.UserRolesEntity;
import com.happiestmind.idm.dataaccess.repository.RoleRepository;
import com.happiestmind.idm.dataaccess.repository.UserRepository;
import com.happiestmind.idm.dataaccess.repository.UserRolesRepository;
import com.happiestmind.idm.exception.EntityNotFoundException;
import com.happiestmind.idm.web.model.UserRoleInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service.
 */
@Service
public class UserService {
    /**
     * User repository.
     */
    private final UserRepository userRepository;
    /**
     * Role repository.
     */
    private final RoleRepository roleRepository;

    /**
     * User roles repository.
     */
    private final UserRolesRepository userRolesRepository;

    /**
     * Constructor of user service.
     *
     * @param userRepository      user repository
     * @param roleRepository      role repository
     * @param userRolesRepository user role repository
     */
    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRolesRepository = userRolesRepository;
    }

    /**
     * Activate user.
     *
     * @param userId user id
     */
    public void activateUser(Long userId) {
        final UserEntity userEntity =
            userRepository.findById(userId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    UserEntity.class, userId);
            });
        userEntity.setStatus('A');
        userRepository.save(userEntity);
    }

    /**
     * Suspend user.
     *
     * @param userId user id
     */
    public void suspendUser(Long userId) {
        final UserEntity userEntity =
            userRepository.findById(userId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    UserEntity.class, userId);
            });
        userEntity.setStatus('S');
        userRepository.save(userEntity);
    }

    /**
     * Delete user.
     *
     * @param userId user id
     */
    public void deleteUser(Long userId) {
        final UserEntity userEntity =
            userRepository.findById(userId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    UserEntity.class, userId);
            });
        // userRepository.deleteById(userId);
    }

    /**
     * Find all users.
     *
     * @return list of user entity.
     */
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Create user.
     *
     * @param userRoleInfo user role info
     */
    @Transactional
    public void createUser(UserRoleInfo userRoleInfo) {
        final UserEntity userEntity = new UserEntity();

        userEntity.setEmailId(userRoleInfo.getEmailId());
        userEntity.setName(userRoleInfo.getName());
        userEntity.setUsername(userRoleInfo.getUserName());
        userEntity.setEnterpriseCode("c425a51e-4378-11eb-87d3-03f5bef302a6");
        userRepository.save(userEntity);
        for (String roleName : userRoleInfo.getRoles()
        ) {
            final RoleEntity roleEntity = roleRepository.findByName(roleName);
            if (Objects.isNull(roleEntity)) {
                throw new EntityNotFoundException(
                    "Role entity with given " + roleName + "not found");
            }
            final UserRolesEntity userRolesEntity = new UserRolesEntity();
            userRolesEntity.setUser(userEntity);
            userRolesEntity.setRole(roleEntity);
            userRolesRepository.save(userRolesEntity);
        }

    }
}
