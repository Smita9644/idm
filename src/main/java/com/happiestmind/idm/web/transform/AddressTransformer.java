package com.happiestmind.idm.web.transform;

import java.util.HashSet;
import java.util.Set;

import com.happiestmind.idm.dataaccess.entities.AddressEntity;
import com.happiestmind.idm.web.model.Address;

import org.springframework.stereotype.Component;

/**
 * Address transformer.
 */
@Component
public class AddressTransformer {
    /**
     * Convert address entities to address (business model class).
     *
     * @param addressEntities address entities
     * @return list of addresses
     */
    public Set<Address> toAddress(Set<AddressEntity> addressEntities) {
        final Set<Address> addresses = new HashSet<>();
        if (addressEntities != null) {
            for (AddressEntity addressEntity : addressEntities
            ) {
                addresses.add(Address.builder().houseName(addressEntity.getHouseName())
                    .postCode(addressEntity.getPostCode())
                    .country(addressEntity.getCountry())
                    .county(addressEntity.getCounty())
                    .city(addressEntity.getCity())
                    .lastUpdateDate(addressEntity.getLastUpdateDate())
                    .createDate(addressEntity.getCreateDate())
                    .street(addressEntity.getStreet()).build());
            }
        }
        return addresses;
    }
}
