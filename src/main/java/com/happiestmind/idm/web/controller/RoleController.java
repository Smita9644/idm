package com.happiestmind.idm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.happiestmind.idm.business.service.RoleService;
import com.happiestmind.idm.web.model.ResponsePayload;
import com.happiestmind.idm.web.model.Role;
import com.happiestmind.idm.web.model.RolePermission;
import com.happiestmind.idm.web.model.RolePermissionsWithFeature;
import com.happiestmind.idm.web.transform.ResponsePayloadTransformer;
import com.happiestmind.idm.web.transform.RolePermissionTransformer;

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
 * Role controller.
 */
@RestController
@RequestMapping("idm/api")
public class RoleController {
    /**
     * Created.
     */
    private static final int CREATED = 201;
    /**
     * Success.
     */
    private static final int SUCCESS = 200;
    /**
     * Role service.
     */
    private final RoleService roleService;
    /**
     * Response payload transformer.
     */
    private final ResponsePayloadTransformer responsePayloadTransformer;
    /**
     * Role permission transformer.
     */
    private final RolePermissionTransformer rolePermissionTransformer;

    /**
     * Constructor for role controller.
     *
     * @param roleService                role service.
     * @param responsePayloadTransformer response payload transform
     * @param rolePermissionTransformer  role permission transformer.
     */
    @Autowired
    public RoleController(RoleService roleService,
                          ResponsePayloadTransformer responsePayloadTransformer,
                          RolePermissionTransformer rolePermissionTransformer) {
        this.roleService = roleService;
        this.responsePayloadTransformer = responsePayloadTransformer;
        this.rolePermissionTransformer = rolePermissionTransformer;
    }

    /**
     * Create role.
     *
     * @param role           role
     * @param enterpriseCode enterprise code.
     * @return Response payload.
     */
    @PostMapping("/roles/{enterpriseCode}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create role")
    @ApiResponses(value = {@ApiResponse(code = CREATED, message = " Created")})
    public ResponsePayload createRole(@PathVariable("enterpriseCode") String enterpriseCode,
                                      @NotNull @RequestBody Role role) {
        roleService.createRole(role, enterpriseCode);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.CREATED, "Role created successfully");
    }

    /**
     * Update role.
     *
     * @param role   role
     * @param roleId role id
     * @return Response payload.
     */
    @PutMapping("/roles/{roleID}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Update role")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = " updated")})
    public ResponsePayload updateRole(@Positive @PathVariable(value = "roleID") Long roleId,
                                      @NotNull @RequestBody Role role) {
        roleService.updateRole(role, roleId);
        return responsePayloadTransformer.toResponsePayload(HttpStatus.OK, "Role updated successfully");
    }

    /**
     * Get roles for enterprise.
     *
     * @param enterpriseCode enterprise Code
     * @return list of role
     */
    @GetMapping("roles/{enterpriseCode}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get roles for given enterprise")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public Map<String, List<RolePermission>> getRolesForGivenEnterprise(
        @PathVariable("enterpriseCode") String enterpriseCode) {
        final Map<String, List<RolePermission>> roles = new HashMap<>();
        roles.put("roles", rolePermissionTransformer.toListOfRolePermission(
            roleService.getAllPermissionsForGivenEnterprise(enterpriseCode)));
        return roles;
    }

    /**
     * Get role.
     *
     * @param roleId role id
     * @return role
     */
    @GetMapping("role/{roleId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get role for given role id")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public RolePermissionsWithFeature getRole(@Positive @PathVariable("roleId") Long roleId) {
        return rolePermissionTransformer.toRolePermission(roleService.getRoleForGivenId(roleId));
    }

    /**
     * Delete role.
     *
     * @param roleId role id.
     * @return response payload
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("roles/{roleId}")
    @ApiOperation(value = "Delete role")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload deleteRole(@Positive @NotNull @PathVariable("roleId") Long roleId) {
        roleService.deleteRole(roleId);
        return responsePayloadTransformer.toResponsePayload(HttpStatus.OK, "Role deleted  successfully");
    }
}
