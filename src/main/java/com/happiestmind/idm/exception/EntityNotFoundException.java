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
     * @param id          id
     */
    public EntityNotFoundException(Class entityClass, Object id) {
        super(entityClass.getName() + " can not be found with given id:" + id);
    }

    /**
     * Parameterized constructor accepting a proposal id.
     *
     * @param entityClass Entity Class
     * @param role        roleo
     */
    public EntityNotFoundException(Class entityClass, String role) {
        super(entityClass.getName() + " can not be found with " + role);
    }

    /**
     * Parameterized constructor accepting a proposal id.
     *
     * @param message message
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
