package com.happiestmind.idm.business.service;

import java.util.Objects;

import javax.transaction.Transactional;

import com.fasterxml.uuid.Generators;
import com.happiestmind.idm.business.model.EnterpriseUser;
import com.happiestmind.idm.dataaccess.entities.EnterpriseEntity;
import com.happiestmind.idm.dataaccess.entities.RoleEntity;
import com.happiestmind.idm.dataaccess.entities.UserEntity;
import com.happiestmind.idm.dataaccess.entities.UserRolesEntity;
import com.happiestmind.idm.dataaccess.repository.EnterpriseRepository;
import com.happiestmind.idm.dataaccess.repository.RoleRepository;
import com.happiestmind.idm.dataaccess.repository.UserRepository;
import com.happiestmind.idm.dataaccess.repository.UserRolesRepository;
import com.happiestmind.idm.exception.EntityNotFoundException;
import com.happiestmind.idm.web.model.EnterpriseBasicInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Enterprise service.
 */
@Service
public class EnterpriseService {
    /**
     * Admin.
     */
    public static final String ADMIN = "ADMIN";
    /**
     * Enterprise repository.
     */
    private final EnterpriseRepository enterpriseRepository;
    /**
     * User repository.
     */
    private final UserRepository userRepository;
    /**
     * Role repository.
     */
    private final RoleRepository roleRepository;

    /**
     * User role repository.
     */
    private final UserRolesRepository userRolesRepository;

    /**
     * Constructor for enterprise service.
     *
     * @param enterpriseRepository enterpriseRepository
     * @param userRepository       user repository.
     * @param roleRepository       role repository
     * @param userRolesRepository  user role repository
     */
    @Autowired
    public EnterpriseService(
        EnterpriseRepository enterpriseRepository,
        UserRepository userRepository,
        RoleRepository roleRepository,
        UserRolesRepository userRolesRepository) {
        this.enterpriseRepository = enterpriseRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRolesRepository = userRolesRepository;
    }

    /**
     * Get details of enterprise.
     *
     * @param enterpriseCode enterprise code.
     * @return enterprise
     */
    public EnterpriseUser getDetailsOfEnterprise(
        String enterpriseCode) {
        final EnterpriseEntity enterpriseEntity =
            enterpriseRepository.findByEnterpriseCode(enterpriseCode);
        if (Objects.isNull(enterpriseEntity)) {
            throw new EntityNotFoundException(
                EnterpriseEntity.class, enterpriseCode);
        }
        final RoleEntity roleEntity = this.roleRepository
            .findByNameAndEnterpriseCode(ADMIN, enterpriseEntity.getEnterpriseCode());

        final UserRolesEntity userRolesEntity = this.userRolesRepository.findByRole(roleEntity);
        return EnterpriseUser.builder().userEntity(userRolesEntity.getUser())
            .enterpriseEntity(enterpriseEntity).build();
    }

    /**
     * Activate enterprise.
     *
     * @param enterpriseId enterprise id
     */
    public void activateEnterprise(Long enterpriseId) {
        final EnterpriseEntity enterpriseEntity =
            enterpriseRepository.findById(enterpriseId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    EnterpriseEntity.class, enterpriseId);
            });
        enterpriseEntity.setStatus('A');
        enterpriseRepository.save(enterpriseEntity);
    }

    /**
     * Suspend enterprise.
     *
     * @param enterpriseId enterprise id
     */
    public void suspendEnterprise(Long enterpriseId) {
        final EnterpriseEntity enterpriseEntity =
            enterpriseRepository.findById(enterpriseId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    EnterpriseEntity.class, enterpriseId);
            });
        enterpriseEntity.setStatus('S');
        enterpriseRepository.save(enterpriseEntity);
    }

    /**
     * Delete enterprise.
     *
     * @param enterpriseId enterprise id
     */
    public void deleteEnterprise(Long enterpriseId) {
        final EnterpriseEntity enterpriseEntity =
            enterpriseRepository.findById(enterpriseId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    EnterpriseEntity.class, enterpriseId);
            });
        enterpriseRepository.deleteById(enterpriseId);
    }

    /**
     * Create enterprise.
     *
     * @param enterpriseBasicInfo enterprise basic info
     */
    @Transactional
    public void createEnterprise(EnterpriseBasicInfo enterpriseBasicInfo) {
        final EnterpriseEntity enterpriseEntity = new EnterpriseEntity();
        // to create enterprise code.
        enterpriseEntity.setEnterpriseCode(Generators.timeBasedGenerator().generate().toString());
        final UserEntity userEntity = new UserEntity();
        enterpriseEntity.setName(enterpriseBasicInfo.getName());
        enterpriseEntity.setEnterpriseType(2);
        final EnterpriseEntity savedEnterpriseEntity = enterpriseRepository.save(enterpriseEntity);

        final RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(ADMIN);
        roleEntity.setEnterpriseCode(savedEnterpriseEntity.getEnterpriseCode());
        final RoleEntity savedRoleEntity = roleRepository.save(roleEntity);

        userEntity.setEmailId(enterpriseBasicInfo.getAdmin().getEmailId());
        userEntity.setName(enterpriseBasicInfo.getAdmin().getName());
        userEntity.setUsername(enterpriseBasicInfo.getAdmin().getUserName());
        userEntity.setEnterpriseCode(enterpriseEntity.getEnterpriseCode());
        final UserEntity savedUserEntity = userRepository.save(userEntity);

        final UserRolesEntity userRolesEntity = new UserRolesEntity();
        userRolesEntity.setUser(userEntity);
        userRolesEntity.setRole(savedRoleEntity);
        userRolesRepository.save(userRolesEntity);
    }
}
