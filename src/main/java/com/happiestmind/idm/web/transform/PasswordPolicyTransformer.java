package com.happiestmind.idm.web.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.happiestmind.idm.dataaccess.entities.PasswordPolicyAttrEntity;
import com.happiestmind.idm.dataaccess.entities.PasswordPolicyEntity;

import org.springframework.stereotype.Component;

/**
 * Password policy transformer.
 */
@Component
public class PasswordPolicyTransformer {
    /**
     * Conversion of password policy entity.
     *
     * @param passwordPoliciesPolicyEntities password policies
     * @return password policy
     */
    public List<Map<String, Object>> toPasswordPolicy(
        List<PasswordPolicyEntity> passwordPoliciesPolicyEntities) {
        final List<Map<String, Object>> passwordPolicies = new ArrayList<>();
        for (PasswordPolicyEntity passwordPolicyEntity : passwordPoliciesPolicyEntities
        ) {
            passwordPolicies.add(toPolicies(passwordPolicyEntity));
        }

        return passwordPolicies;
    }

    private Map<String, Object> toPolicies(
        PasswordPolicyEntity passwordPolicyEntity) {
        final Map<String, Object> map = new HashMap<>();
        map.put("policyId", passwordPolicyEntity.getId());
        map.put("policyName", passwordPolicyEntity.getPolicyName());
        map.put("description", passwordPolicyEntity.getDescription());
        for (PasswordPolicyAttrEntity passwordPolicyAttrEntity : passwordPolicyEntity
            .getPasswordPolicyAttrEntities()) {
            map.put(passwordPolicyAttrEntity.getAttrName(),
                passwordPolicyAttrEntity.getAttrValue());
        }
        return map;
    }
}
