package com.happiestmind.idm.exception;

/**
 * ProposalNotFoundException - mapped to 404.
 * This exception is helpful in informing the proposal can not be found with requested id.
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Parameterized constructor accepting a proposal id.
     *
     * @param entityClass Entity Class
     * @param id          proposal id
     */
    public EntityNotFoundException(Class entityClass, Object id) {
        super(entityClass.getName() + " can not be found with given id:" + id);
    }
}
