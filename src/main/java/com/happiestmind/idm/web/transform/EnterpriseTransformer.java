package com.happiestmind.idm.web.transform;

import com.happiestmind.idm.dataaccess.entities.EnterpriseEntity;
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
     * @param enterpriseEntity enterprise entity
     * @return enterprise
     */
    public Enterprise toEnterprise(EnterpriseEntity enterpriseEntity) {
        return Enterprise.builder()
            .address(addressTransformer.toAddress(enterpriseEntity.getAddressEntities()))
            .admin(userTransformer.toUser(enterpriseEntity.getUser()))
            .enterpriseCode(enterpriseEntity.getEnterpriseCode())
            .enterpriseType(enterpriseEntity.getEnterpriseType())
            .name(enterpriseEntity.getName())
            .createDate(enterpriseEntity.getCreateDate())
            .lastUpdateDate(enterpriseEntity.getLastUpdateDate())
            .status(enterpriseEntity.getStatus())
            .id(enterpriseEntity.getId())
            .build();
    }
}
