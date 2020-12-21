package com.happiestmind.idm.web.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.happiestmind.idm.business.service.EnterpriseService;
import com.happiestmind.idm.web.model.Enterprise;
import com.happiestmind.idm.web.model.EnterpriseBasicInfo;
import com.happiestmind.idm.web.model.ResponsePayload;
import com.happiestmind.idm.web.transform.EnterpriseTransformer;
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
 * Enterprise Controller.
 */
@RestController
@RequestMapping("idm/api/")
public class EnterpriseController {
    /**
     * Success code.
     */
    private static final int SUCCESS = 200;
    /**
     * Entity not found code.
     */
    private static final int NOTFOUND = 404;
    /**
     * Code for created.
     */
    private static final int CREATED = 201;
    /**
     * Enterprise service.
     */
    private final EnterpriseService enterpriseService;
    /**
     * Enterprise transformer.
     */
    private final EnterpriseTransformer EnterpriseTransformer;
    /**
     * Response payload transformer.
     */
    private final ResponsePayloadTransformer responsePayloadTransformer;

    /**
     * Enterprise controller constructor.
     *
     * @param enterpriseService          enterprise service.
     * @param enterpriseTransformer      enterprise transformation
     * @param responsePayloadTransformer response payload transformer
     */
    @Autowired
    public EnterpriseController(
        EnterpriseService enterpriseService,
        com.happiestmind.idm.web.transform.EnterpriseTransformer enterpriseTransformer,
        ResponsePayloadTransformer responsePayloadTransformer) {
        this.enterpriseService = enterpriseService;
        EnterpriseTransformer = enterpriseTransformer;
        this.responsePayloadTransformer = responsePayloadTransformer;
    }

    /**
     * Create enterprise.
     *
     * @param enterpriseBasicInfo enterprise basic info.
     * @return ResponseEntity.
     */
    @PostMapping("/enterprise")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create enterprise")
    @ApiResponses(value = {@ApiResponse(code = CREATED, message = " Created")})
    public ResponsePayload createEnterprise(@RequestBody
                                                EnterpriseBasicInfo enterpriseBasicInfo) {
        enterpriseService.createEnterprise(enterpriseBasicInfo);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.CREATED, "Enterprise created successfully");
    }

    /**
     * Get Enterprise details.
     *
     * @param enterpriseCode enterprise Code
     * @return details of enterprise
     */
    @GetMapping("enterprise/{enterpriseCode}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get enterprise details")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok"),
        @ApiResponse(code = NOTFOUND, message = "not found")})
    public Enterprise getDetailsOfEnterprise(
        @PathVariable("enterpriseCode") String enterpriseCode) {
        return this.EnterpriseTransformer
            .toEnterprise(enterpriseService.getDetailsOfEnterprise(enterpriseCode));
    }

    /**
     * Activate enterprise.
     *
     * @param enterpriseId enterprise id
     * @return Response payload dto
     */
    @PutMapping("enterprise/{enterpriseId}/activate")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update the status of the enterprise")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload updateStatusOfEnterprise(
        @PathVariable("enterpriseId") Long enterpriseId) {
        enterpriseService.activateEnterprise(enterpriseId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "Enterprise Activated successfully");
    }

    /**
     * Suspend enterprise.
     *
     * @param enterpriseId enterprise id
     * @return Response payload dto
     */
    @PutMapping("enterprise/{enterpriseId}/suspend")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update the status of the enterprise")
    @ApiResponses(value = {
        @ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload suspendEnterprise(
        @PathVariable("enterpriseId") Long enterpriseId) {
        enterpriseService.suspendEnterprise(enterpriseId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "Enterprise suspended  successfully");
    }

    /**
     * Delete Member of DealTeam.
     *
     * @param enterpriseId Proposal id.
     * @return response payload
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("enterprise/{id}")
    @ApiOperation(value = "Delete deal team member")
    @ApiResponses(value = {@ApiResponse(code = SUCCESS, message = "Success|Ok")})
    public ResponsePayload deleteEnterprise(
        @Positive @NotNull @PathVariable("id") Long enterpriseId) {

        enterpriseService.deleteEnterprise(enterpriseId);
        return responsePayloadTransformer
            .toResponsePayload(HttpStatus.OK, "Enterprise deleted  successfully");
    }
}
