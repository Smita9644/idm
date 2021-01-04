package com.happiestmind.idm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.happiestmind.idm.business.service.PasswordPolicyService;
import com.happiestmind.idm.web.model.ResponsePayload;
import com.happiestmind.idm.web.transform.PasswordPolicyTransformer;
import com.happiestmind.idm.web.transform.ResponsePayloadTransformer;

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
 * Password policy controller.
 */
@RestController
@RequestMapping("idm/api")
public class PasswordPolicyController {
    /**
     * Success.
     */
    private static final int SUCCESS = 200;
    /**
     * Created.
     */
    private static final int CREATED = 201;
    /**
     * Password policy service.
     */
    private final PasswordPolicyService passwordPolicyService;
    /**
     * Password policy transformer.
     */
    private final PasswordPolicyTransformer passwordPolicyTransformer;
    /**
     * Response payload  transformer.
     */
    private final ResponsePayloadTransformer responsePayloadTransformer;

    /**
     * Constructor of password controller.
     *
     * @param passwordPolicyService      password policy service
     * @param passwordPolicyTransformer  password policy transformer
     * @param responsePayloadTransformer response payload transformer
     */
    @Autowired
    public PasswordPolicyController(
        PasswordPolicyService passwordPolicyService,
        PasswordPolicyTransformer passwordPolicyTransformer,
        ResponsePayloadTransformer responsePayloadTransformer) {
        this.passwordPolicyService = passwordPolicyService;
        this.passwordPolicyTransformer = passwordPolicyTransformer;
        this.responsePayloadTransformer = responsePayloadTransformer;
    }

    /**
     * Create password policy.
     *
     * @param passwordPolicies password policies
     * @param enterpriseCode   enterprise code.
     * @return Response payload.
     */
    @PostMapping("/passwordpolicies/{enterpriseCode}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create password policy")
    @ApiResponses(value = {@ApiResponse(code = CREATED, message = " Created")})
    public ResponsePayload createPasswordPolicy(
        @PathVariable("enterpriseCode") String enterpriseCode,
        @NotNull @RequestBody Map<String, Object> passwordPolicies) {
        passwordPolicyService.createPasswordPolicy(enterpriseCode, passwordPolicies);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.CREATED, "Password policy created successfully");
    }

    /**
     * Get password policies.
     *
     * @param enterpriseCode enterprise code
     * @return role
     */
    @GetMapping("passwordpolicies/{enterpriseCode}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get password policies for given enterprise")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public Map<String, List<Map<String, Object>>> getPasswordPolicies(
        @PathVariable("enterpriseCode") String enterpriseCode) {
        final Map<String, List<Map<String, Object>>> policies = new HashMap<>();
        policies.put("passwordPolicies", passwordPolicyTransformer
            .toPasswordPolicy(passwordPolicyService.getPasswordPolicies(enterpriseCode)));
        return policies;
    }

    /**
     * Activate password policy.
     *
     * @param passwordPolicyId password policy id
     * @return Response payload dto
     */
    @PutMapping("passwordpolicies/{passwordPolicyId}/activate")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Activate password policy")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload activatePasswordPolicy(
        @Positive @PathVariable("passwordPolicyId") Long passwordPolicyId) {
        passwordPolicyService.activatePasswordPolicy(passwordPolicyId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "Password policy Activated successfully");
    }

    /**
     * Deactivate password policy.
     *
     * @param passwordPolicyId password policy id
     * @return Response payload dto
     */
    @PutMapping("passwordpolicies/{passwordPolicyId}/deactivate")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Deactivate password policy")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload deactivatePasswordPolicy(
        @Positive @PathVariable("passwordPolicyId") Long passwordPolicyId) {
        passwordPolicyService.deactivatePasswordPolicy(passwordPolicyId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "Password policy deactivate successfully");
    }

    /**
     * Delete password policy.
     *
     * @param passwordPolicyId password policy id.
     * @return response payload
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("passwordpolicies/{passwordPolicyId}")
    @ApiOperation(value = "Delete password Policy")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload deletePasswordPolicy(
        @Positive @NotNull @PathVariable("passwordPolicyId") Long passwordPolicyId) {
        passwordPolicyService.deletePasswordPolicy(passwordPolicyId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "Password policy deleted  successfully");
    }
}
