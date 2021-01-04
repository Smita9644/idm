package com.happiestmind.idm.exception;

/**
 * ProposalNotFoundException - mapped to 404.
 * This exception is helpful in informing the proposal can not be found with requested id.
 */
public class EntityNotFoundException extends RuntimeException {
    /**
     * Parameterized constructor accepting a proposal id.
     *
     * @param message message
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
