package com.happiestmind.idm.dataaccess.repository;

import java.util.List;

import com.happiestmind.idm.dataaccess.entities.RoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for Role entity.
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    /**
     * Find role entity by role name.
     *
     * @param roleName role name
     * @return role entity
     */
    RoleEntity findByName(String roleName);

    /**
     * Find role entity by name and code.
     *
     * @param admin          name of role
     * @param enterpriseCode enterprise code
     * @return
     */
    RoleEntity findByNameAndEnterpriseCode(String admin, String enterpriseCode);

    /**
     * Find role by enterprise code.
     *
     * @param enterpriseCode enterprise code
     * @return list of role entity
     */
    List<RoleEntity> findByEnterpriseCode(String enterpriseCode);
}
