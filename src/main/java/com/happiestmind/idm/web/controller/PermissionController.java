package com.happiestmind.idm.web.controller;

import java.util.List;
import java.util.Map;

import com.happiestmind.idm.business.service.PermissionService;
import com.happiestmind.idm.web.model.Permission;
import com.happiestmind.idm.web.transform.PermissionTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Permission controller.
 */
@RestController
@RequestMapping("idm/api")
public class PermissionController {
    /**
     * Success.
     */
    private static final int SUCCESS = 200;
    /**
     * Not found.
     */
    private static final int NOTFOUND = 404;
    /**
     * Permissions service.
     */
    private final PermissionService permissionService;
    /**
     * Permission transformer.
     */
    private final PermissionTransformer permissionTransform;

    /**
     * Constructor for permissions controller.
     *
     * @param permissionService   permissions service
     * @param permissionTransform permission transformer
     */
    @Autowired
    public PermissionController(
        PermissionService permissionService,
        PermissionTransformer permissionTransform) {
        this.permissionService = permissionService;
        this.permissionTransform = permissionTransform;
    }

    /**
     * Get All permission.
     *
     * @return all permissions
     */
    @GetMapping("/permissions")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get all permissions")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok"),
        @ApiResponse(code = NOTFOUND, message = "not found")})
    public Map<String, List<Permission>> getAllPermissions() {
        return this.permissionTransform.toAllPermissions(permissionService.getAllPermissions());
    }

    /**
     * Get permissions for given feature.
     *
     * @param feature feature
     * @return List of permissions
     */
    @GetMapping("permissions/feature/")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get permissions for given feature")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok"),
        @ApiResponse(code = NOTFOUND, message = "not found")})
    public Map<String, List<Permission>> getDetailsOfEnterprise(
        @RequestParam("feature") String feature) {
        return this.permissionTransform.toAllPermissions(permissionService.getPermissionsForGivenFeature(feature));
    }
}
