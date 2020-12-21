package com.happiestmind.idm.web.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.happiestmind.idm.business.service.UserService;
import com.happiestmind.idm.web.model.ResponsePayload;
import com.happiestmind.idm.web.transform.ResponsePayloadTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * User controller.
 */
@RestController
@RequestMapping("idm/api")
public class UserController {
    /**
     * Success.
     */
    private static final int SUCCESS = 200;
    /**
     * Not found.
     */
    private static final int NOTFOUND = 404;
    /**
     * User service.
     */
    private final UserService userService;
    /**
     * Response payload transform.
     */
    private final ResponsePayloadTransformer responsePayloadTransformer;

    /**
     * Constructor of user controller.
     *
     * @param userService                user service
     * @param responsePayloadTransformer response payload transform
     */
    @Autowired
    public UserController(UserService userService,
                          ResponsePayloadTransformer responsePayloadTransformer) {
        this.userService = userService;
        this.responsePayloadTransformer = responsePayloadTransformer;
    }

    /**
     * Activate user.
     *
     * @param userId user id
     * @return Response payload dto
     */
    @PutMapping("user/{userId}/activate")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update the status of the user")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload activateUser(
        @PathVariable("userId") Long userId) {
        userService.activateUser(userId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "user Activated successfully");
    }

    /**
     * Suspend user.
     *
     * @param userId user id
     * @return Response payload dto
     */
    @PutMapping("user/{userId}/suspend")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update the status of user")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload suspendUser(
        @PathVariable("userId") Long userId) {
        userService.suspendUser(userId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "User suspended  successfully");
    }

    /**
     * Delete user.
     *
     * @param userId user id.
     * @return response payload
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete deal team member")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload deleteUser(
        @Positive @NotNull @PathVariable("id") Long userId) {

        userService.deleteUser(userId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "User deleted  successfully");
    }
}
