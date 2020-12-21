package com.happiestmind.idm.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.happiestmind.idm.business.service.UserService;
import com.happiestmind.idm.web.model.EnterpriseBasicInfo;
import com.happiestmind.idm.web.model.ResponsePayload;
import com.happiestmind.idm.web.model.User;
import com.happiestmind.idm.web.model.UserRoleInfo;
import com.happiestmind.idm.web.transform.ResponsePayloadTransformer;
import com.happiestmind.idm.web.transform.UserTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * Created.
     */
    private static final int CREATED = 201;
    /**
     * User service.
     */
    private final UserService userService;
    /**
     * Response payload transform.
     */
    private final ResponsePayloadTransformer responsePayloadTransformer;
    /**
     * User transform.
     */
    private final UserTransformer userTransformer;

    /**
     * Constructor of user controller.
     *
     * @param userService                user service
     * @param responsePayloadTransformer response payload transform
     * @param userTransformer            user transform
     */
    @Autowired
    public UserController(UserService userService,
                          ResponsePayloadTransformer responsePayloadTransformer,
                          UserTransformer userTransformer) {
        this.userService = userService;
        this.responsePayloadTransformer = responsePayloadTransformer;
        this.userTransformer = userTransformer;
    }

    /**
     * Create user.
     *
     * @param userRoleInfo user role info.
     * @return ResponseEntity.
     */
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create user")
    @ApiResponses(value = {@ApiResponse(code = CREATED, message = " Created")})
    public ResponsePayload createEnterprise(@RequestBody
                                                UserRoleInfo userRoleInfo) {
        userService.createUser(userRoleInfo);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.CREATED, "User created successfully");
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
    @DeleteMapping("users/{id}")
    @ApiOperation(value = "Delete user")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload deleteUser(
        @Positive @NotNull @PathVariable("id") Long userId) {

        userService.deleteUser(userId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "User deleted  successfully");
    }

    /**
     * Get List of users..
     *
     * @return details of enterprise
     */
    @GetMapping("/users/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get all users")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public List<User> getDetailsOfEnterprise() {
        return userTransformer.toUsers(userService.findAllUsers());
    }
}
