package com.happiestmind.idm.business.service;

import java.util.List;

import com.happiestmind.idm.dataaccess.entities.PasswordPolicyEntity;
import com.happiestmind.idm.dataaccess.repository.PasswordPolicyAttrRepository;
import com.happiestmind.idm.dataaccess.repository.PasswordPolicyRepository;
import com.happiestmind.idm.exception.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Password policy service.
 */
@Service
public class PasswordPolicyService {
    /**
     * Password policy not found exception msg.
     */
    public static final String PASSWORD_POLICY_NOT_FOUND_FOR_GIVEN_ID =
        "Password policy not found for given id";
    /**
     * Password policy repository.
     */
    private final PasswordPolicyRepository passwordPolicyRepository;
    /**
     * Password policy attribute repository.
     */
    private final PasswordPolicyAttrRepository passwordPolicyAttrRepository;

    /**
     * Constructor for password policy.
     *
     * @param passwordPolicyRepository     password policy repository
     * @param passwordPolicyAttrRepository password attribute repository
     */
    @Autowired
    public PasswordPolicyService(
        PasswordPolicyRepository passwordPolicyRepository,
        PasswordPolicyAttrRepository passwordPolicyAttrRepository) {
        this.passwordPolicyRepository = passwordPolicyRepository;
        this.passwordPolicyAttrRepository = passwordPolicyAttrRepository;
    }

    /**
     * Password policy.
     *
     * @param enterpriseCode enterprise code
     * @return password policy entity
     */
    public List<PasswordPolicyEntity> getPasswordPolicies(String enterpriseCode) {
        return passwordPolicyRepository.findByEnterpriseCode(enterpriseCode);
    }

    /**
     * Activate password policy.
     *
     * @param passwordPolicyId password policy id
     */
    public void activatePasswordPolicy(Long passwordPolicyId) {
        final PasswordPolicyEntity passwordPolicyEntity =
            passwordPolicyRepository.findById(passwordPolicyId).orElseThrow(() -> {
                throw new EntityNotFoundException(
                    PASSWORD_POLICY_NOT_FOUND_FOR_GIVEN_ID + passwordPolicyId);
            });
        passwordPolicyEntity.setStatus('A');
        passwordPolicyRepository.save(passwordPolicyEntity);
    }

    /**
     * Deactivate password policy.
     *
     * @param passwordPolicyId password policy id
     */
    public void deactivatePasswordPolicy(Long passwordPolicyId) {
        final PasswordPolicyEntity passwordPolicyEntity =
            passwordPolicyRepository.findById(passwordPolicyId).orElseThrow(() -> {
                throw new EntityNotFoundException(
                    PASSWORD_POLICY_NOT_FOUND_FOR_GIVEN_ID + passwordPolicyId);
            });
        passwordPolicyEntity.setStatus('D');
        passwordPolicyRepository.save(passwordPolicyEntity);
    }

    /**
     * Delete password policy.
     *
     * @param passwordPolicyId password policy id
     */
    public void deletePasswordPolicy(Long passwordPolicyId) {
        final PasswordPolicyEntity passwordPolicyEntity =
            passwordPolicyRepository.findById(passwordPolicyId).orElseThrow(() -> {
                throw new EntityNotFoundException(
                    PASSWORD_POLICY_NOT_FOUND_FOR_GIVEN_ID + passwordPolicyId);
            });
        passwordPolicyRepository.delete(passwordPolicyEntity);
    }
}
