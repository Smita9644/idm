package com.happiestmind.idm.business.service;

import java.util.Objects;

import com.fasterxml.uuid.Generators;
import com.happiestmind.idm.dataaccess.entities.EnterpriseEntity;
import com.happiestmind.idm.dataaccess.entities.UserEntity;
import com.happiestmind.idm.dataaccess.repository.EnterpriseRepository;
import com.happiestmind.idm.dataaccess.repository.UserRepository;
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
     * Enterprise repository.
     */
    private final EnterpriseRepository enterpriseRepository;
    /**
     * User repository.
     */
    private final UserRepository userRepository;

    /**
     * Constructor for enterprise service.
     *
     * @param enterpriseRepository enterpriseRepository
     * @param userRepository       user repository.
     */
    @Autowired
    public EnterpriseService(
        EnterpriseRepository enterpriseRepository,
        UserRepository userRepository) {
        this.enterpriseRepository = enterpriseRepository;
        this.userRepository = userRepository;
    }

    /**
     * Get details of enterprise.
     *
     * @param enterpriseCode enterprise code.
     * @return enterprise
     */
    public EnterpriseEntity getDetailsOfEnterprise(
        String enterpriseCode) {
        final EnterpriseEntity enterpriseEntity =
            enterpriseRepository.findByEnterpriseCode(enterpriseCode);
        if (Objects.isNull(enterpriseEntity)) {
            throw new EntityNotFoundException(
                EnterpriseEntity.class, enterpriseCode);
        }
        return enterpriseEntity;
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
    public void createEnterprise(EnterpriseBasicInfo enterpriseBasicInfo) {
        final EnterpriseEntity enterpriseEntity = new EnterpriseEntity();
        // to create enterprise code.
        enterpriseEntity.setEnterpriseCode(Generators.timeBasedGenerator().generate().toString());
        final UserEntity userEntity = new UserEntity();

        userEntity.setEmailId(enterpriseBasicInfo.getAdmin().getEmailId());
        userEntity.setName(enterpriseBasicInfo.getAdmin().getName());
        userEntity.setUsername(enterpriseBasicInfo.getAdmin().getUserName());
        userEntity.setEnterpriseCode(enterpriseEntity.getEnterpriseCode());

        enterpriseEntity.setName(enterpriseBasicInfo.getName());
        enterpriseEntity.setEnterpriseType(2);
        enterpriseEntity.setUser(userEntity);
        enterpriseRepository.save(enterpriseEntity);

    }
}
