package com.happiestmind.idm.web.transform;

import com.happiestmind.idm.business.model.EnterpriseUser;
import com.happiestmind.idm.web.model.Enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Enterprise transformer.
 */
@Component
public class EnterpriseTransformer {
    /**
     * Address transformer.
     */
    private final UserTransformer userTransformer;
    /**
     * Address transformer.
     */
    private final AddressTransformer addressTransformer;

    /**
     * Constructor for Enterprise transformer.
     *
     * @param userTransformer    user transformer
     * @param addressTransformer address transformer
     */
    @Autowired
    public EnterpriseTransformer(
        UserTransformer userTransformer,
        AddressTransformer addressTransformer) {
        this.userTransformer = userTransformer;
        this.addressTransformer = addressTransformer;
    }

    /**
     * Conversion from Enterprise entity To enterprise (business model class).
     *
     * @param enterpriseUser enterprise user class
     * @return enterprise
     */
    public Enterprise toEnterprise(EnterpriseUser enterpriseUser) {
        return Enterprise.builder()
            .address(addressTransformer
                .toAddress(enterpriseUser.getEnterpriseEntity().getAddressEntities()))
            .admin(userTransformer.toUser(enterpriseUser.getUserEntity()))
            .enterpriseCode(enterpriseUser.getEnterpriseEntity().getEnterpriseCode())
            .enterpriseType(enterpriseUser.getEnterpriseEntity().getEnterpriseType())
            .name(enterpriseUser.getEnterpriseEntity().getName())
            .createDate(enterpriseUser.getEnterpriseEntity().getCreateDate())
            .lastUpdateDate(enterpriseUser.getEnterpriseEntity().getLastUpdateDate())
            .status(enterpriseUser.getEnterpriseEntity().getStatus())
            .build();
    }
}
