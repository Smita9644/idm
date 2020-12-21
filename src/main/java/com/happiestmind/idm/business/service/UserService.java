package com.happiestmind.idm.business.service;

import com.happiestmind.idm.dataaccess.entities.UserEntity;
import com.happiestmind.idm.dataaccess.repository.UserRepository;
import com.happiestmind.idm.exception.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service.
 */
@Service
public class UserService {
    /**
     * User repository.
     */
    private final UserRepository userRepository;

    /**
     * Constructor of user service.
     *
     * @param userRepository user repository
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Activate user.
     *
     * @param userId user id
     */
    public void activateUser(Long userId) {
        final UserEntity userEntity =
            userRepository.findById(userId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    UserEntity.class, userId);
            });
        userEntity.setStatus('A');
        userRepository.save(userEntity);
    }

    /**
     * Suspend user.
     *
     * @param userId user id
     */
    public void suspendUser(Long userId) {
        final UserEntity userEntity =
            userRepository.findById(userId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    UserEntity.class, userId);
            });
        userEntity.setStatus('S');
        userRepository.save(userEntity);
    }

    /**
     * Delete user.
     *
     * @param userId user id
     */
    public void deleteUser(Long userId) {
        final UserEntity userEntity =
            userRepository.findById(userId).orElseThrow(() -> {
                return new EntityNotFoundException(
                    UserEntity.class, userId);
            });
        userRepository.deleteById(userId);
    }
}
