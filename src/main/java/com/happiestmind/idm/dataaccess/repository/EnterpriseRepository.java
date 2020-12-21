package com.happiestmind.idm.dataaccess.repository;


import com.happiestmind.idm.dataaccess.entities.EnterpriseEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository of enterprise entity.
 */
public interface EnterpriseRepository
    extends JpaRepository<EnterpriseEntity, Long> {
    /**
     * FInd Enterprise by enterprise code.
     *
     * @param enterpriseCode enterprise code
     * @return Enterprise
     */
    EnterpriseEntity findByEnterpriseCode(String enterpriseCode);
}
