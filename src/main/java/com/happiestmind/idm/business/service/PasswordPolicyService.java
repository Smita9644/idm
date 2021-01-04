package com.happiestmind.idm.business.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.happiestmind.idm.dataaccess.entities.PasswordPolicyAttrEntity;
import com.happiestmind.idm.dataaccess.entities.PasswordPolicyEntity;
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
     * Policy name.
     */
    public static final String POLICY_NAME = "policyName";
    /**
     * Description.
     */
    public static final String DESCRIPTION = "description";
    /**
     * Password policy repository.
     */
    private final PasswordPolicyRepository passwordPolicyRepository;

    /**
     * Constructor for password policy.
     *
     * @param passwordPolicyRepository password policy repository
     */
    @Autowired
    public PasswordPolicyService(
        PasswordPolicyRepository passwordPolicyRepository) {
        this.passwordPolicyRepository = passwordPolicyRepository;
    }

    /**
     * Password policy.
     *
     * @param enterpriseCode enterprise code
     * @return password policy entity
     */
    public List<PasswordPolicyEntity> getPasswordPolicies(String enterpriseCode) {
        final List<PasswordPolicyEntity> passwordPolicyEntities =
            passwordPolicyRepository.findByEnterpriseCode(enterpriseCode);
        if (passwordPolicyEntities.isEmpty()) {
            throw new EntityNotFoundException("Password policies not found for given enterprise");
        }
        return passwordPolicyEntities;
    }

    /**
     * Activate password policy.
     *
     * @param passwordPolicyId password policy id
     */
    public void activatePasswordPolicy(Long passwordPolicyId) {
        final PasswordPolicyEntity passwordPolicyEntity =
            this.findPasswordPolicyById(passwordPolicyId);
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
            this.findPasswordPolicyById(passwordPolicyId);
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
            this.findPasswordPolicyById(passwordPolicyId);
        passwordPolicyRepository.delete(passwordPolicyEntity);
    }

    /**
     * Create password policy.
     *
     * @param enterpriseCode   enterprise code
     * @param passwordPolicies password policies
     */
    public void createPasswordPolicy(String enterpriseCode, Map<String, Object> passwordPolicies) {
        final PasswordPolicyEntity passwordPolicyEntity = new PasswordPolicyEntity();
        passwordPolicyEntity.setPolicyName((String) passwordPolicies.get(POLICY_NAME));
        passwordPolicyEntity.setDescription((String) passwordPolicies.get(DESCRIPTION));
        passwordPolicyEntity.setEnterpriseCode(enterpriseCode);
        final Set<PasswordPolicyAttrEntity> passwordPolicyAttrEntitySet = new HashSet<>();
        for (Map.Entry<String, Object> policy : passwordPolicies.entrySet()) {
            if (policy.getKey().equals(POLICY_NAME) || policy.getKey().equals(DESCRIPTION)) {
                continue;
            }
            final PasswordPolicyAttrEntity passwordPolicyAttr = new PasswordPolicyAttrEntity();
            passwordPolicyAttr.setAttrName(policy.getKey());
            passwordPolicyAttr.setAttrValue(policy.getValue().toString());
            passwordPolicyAttr.setPasswordPolicy(passwordPolicyEntity);
            passwordPolicyAttrEntitySet.add(passwordPolicyAttr);
        }
        passwordPolicyEntity.setPasswordPolicyAttrEntities(passwordPolicyAttrEntitySet);
        passwordPolicyRepository.save(passwordPolicyEntity);
    }

    private PasswordPolicyEntity findPasswordPolicyById(Long passwordPolicyId) {
        return passwordPolicyRepository.findById(passwordPolicyId).orElseThrow(() -> {
            throw new EntityNotFoundException(
                PASSWORD_POLICY_NOT_FOUND_FOR_GIVEN_ID + passwordPolicyId);
        });
    }
}
