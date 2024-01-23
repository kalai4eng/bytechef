/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Workflow Test API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  UpdateWorkflowTestConfigurationConnectionRequestModel,
  UpdateWorkflowTestConfigurationInputsRequestModel,
  WorkflowTestConfigurationConnectionModel,
  WorkflowTestConfigurationModel,
} from '../models/index';
import {
    UpdateWorkflowTestConfigurationConnectionRequestModelFromJSON,
    UpdateWorkflowTestConfigurationConnectionRequestModelToJSON,
    UpdateWorkflowTestConfigurationInputsRequestModelFromJSON,
    UpdateWorkflowTestConfigurationInputsRequestModelToJSON,
    WorkflowTestConfigurationConnectionModelFromJSON,
    WorkflowTestConfigurationConnectionModelToJSON,
    WorkflowTestConfigurationModelFromJSON,
    WorkflowTestConfigurationModelToJSON,
} from '../models/index';

export interface CreateWorkflowTestConfigurationRequest {
    workflowId: string;
    workflowTestConfigurationModel: WorkflowTestConfigurationModel;
}

export interface GetWorkflowTestConfigurationRequest {
    workflowId: string;
}

export interface GetWorkflowTestConfigurationConnectionsRequest {
    workflowId: string;
    workflowNodeName: string;
}

export interface UpdateWorkflowTestConfigurationRequest {
    workflowId: string;
    workflowTestConfigurationModel: WorkflowTestConfigurationModel;
}

export interface UpdateWorkflowTestConfigurationConnectionRequest {
    workflowId: string;
    workflowNodeName: string;
    workflowConnectionKey: string;
    updateWorkflowTestConfigurationConnectionRequestModel: UpdateWorkflowTestConfigurationConnectionRequestModel;
}

export interface UpdateWorkflowTestConfigurationInputsRequest {
    workflowId: string;
    updateWorkflowTestConfigurationInputsRequestModel: UpdateWorkflowTestConfigurationInputsRequestModel;
}

/**
 * 
 */
export class WorkflowTestConfigurationApi extends runtime.BaseAPI {

    /**
     * Create a new workflow test configuration.
     * Create a new workflow test configuration.
     */
    async createWorkflowTestConfigurationRaw(requestParameters: CreateWorkflowTestConfigurationRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<WorkflowTestConfigurationModel>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling createWorkflowTestConfiguration.');
        }

        if (requestParameters.workflowTestConfigurationModel === null || requestParameters.workflowTestConfigurationModel === undefined) {
            throw new runtime.RequiredError('workflowTestConfigurationModel','Required parameter requestParameters.workflowTestConfigurationModel was null or undefined when calling createWorkflowTestConfiguration.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/workflow-test-configurations/{workflowId}`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: WorkflowTestConfigurationModelToJSON(requestParameters.workflowTestConfigurationModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => WorkflowTestConfigurationModelFromJSON(jsonValue));
    }

    /**
     * Create a new workflow test configuration.
     * Create a new workflow test configuration.
     */
    async createWorkflowTestConfiguration(requestParameters: CreateWorkflowTestConfigurationRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<WorkflowTestConfigurationModel> {
        const response = await this.createWorkflowTestConfigurationRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a workflow test configuration.
     * Get a workflow test configuration
     */
    async getWorkflowTestConfigurationRaw(requestParameters: GetWorkflowTestConfigurationRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<WorkflowTestConfigurationModel>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling getWorkflowTestConfiguration.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/workflow-test-configurations/{workflowId}`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => WorkflowTestConfigurationModelFromJSON(jsonValue));
    }

    /**
     * Get a workflow test configuration.
     * Get a workflow test configuration
     */
    async getWorkflowTestConfiguration(requestParameters: GetWorkflowTestConfigurationRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<WorkflowTestConfigurationModel> {
        const response = await this.getWorkflowTestConfigurationRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a workflow test configuration connections.
     * Get a workflow test configuration connections
     */
    async getWorkflowTestConfigurationConnectionsRaw(requestParameters: GetWorkflowTestConfigurationConnectionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<WorkflowTestConfigurationConnectionModel>>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling getWorkflowTestConfigurationConnections.');
        }

        if (requestParameters.workflowNodeName === null || requestParameters.workflowNodeName === undefined) {
            throw new runtime.RequiredError('workflowNodeName','Required parameter requestParameters.workflowNodeName was null or undefined when calling getWorkflowTestConfigurationConnections.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/workflow-test-configurations/{workflowId}/connections/{workflowNodeName}`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))).replace(`{${"workflowNodeName"}}`, encodeURIComponent(String(requestParameters.workflowNodeName))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(WorkflowTestConfigurationConnectionModelFromJSON));
    }

    /**
     * Get a workflow test configuration connections.
     * Get a workflow test configuration connections
     */
    async getWorkflowTestConfigurationConnections(requestParameters: GetWorkflowTestConfigurationConnectionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<WorkflowTestConfigurationConnectionModel>> {
        const response = await this.getWorkflowTestConfigurationConnectionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Update an existing workflow test configuration.
     * Update an existing workflow test configuration
     */
    async updateWorkflowTestConfigurationRaw(requestParameters: UpdateWorkflowTestConfigurationRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<WorkflowTestConfigurationModel>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling updateWorkflowTestConfiguration.');
        }

        if (requestParameters.workflowTestConfigurationModel === null || requestParameters.workflowTestConfigurationModel === undefined) {
            throw new runtime.RequiredError('workflowTestConfigurationModel','Required parameter requestParameters.workflowTestConfigurationModel was null or undefined when calling updateWorkflowTestConfiguration.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/workflow-test-configurations/{workflowId}`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: WorkflowTestConfigurationModelToJSON(requestParameters.workflowTestConfigurationModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => WorkflowTestConfigurationModelFromJSON(jsonValue));
    }

    /**
     * Update an existing workflow test configuration.
     * Update an existing workflow test configuration
     */
    async updateWorkflowTestConfiguration(requestParameters: UpdateWorkflowTestConfigurationRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<WorkflowTestConfigurationModel> {
        const response = await this.updateWorkflowTestConfigurationRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Update a workflow test configuration connection.
     * Update a workflow test configuration connection
     */
    async updateWorkflowTestConfigurationConnectionRaw(requestParameters: UpdateWorkflowTestConfigurationConnectionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling updateWorkflowTestConfigurationConnection.');
        }

        if (requestParameters.workflowNodeName === null || requestParameters.workflowNodeName === undefined) {
            throw new runtime.RequiredError('workflowNodeName','Required parameter requestParameters.workflowNodeName was null or undefined when calling updateWorkflowTestConfigurationConnection.');
        }

        if (requestParameters.workflowConnectionKey === null || requestParameters.workflowConnectionKey === undefined) {
            throw new runtime.RequiredError('workflowConnectionKey','Required parameter requestParameters.workflowConnectionKey was null or undefined when calling updateWorkflowTestConfigurationConnection.');
        }

        if (requestParameters.updateWorkflowTestConfigurationConnectionRequestModel === null || requestParameters.updateWorkflowTestConfigurationConnectionRequestModel === undefined) {
            throw new runtime.RequiredError('updateWorkflowTestConfigurationConnectionRequestModel','Required parameter requestParameters.updateWorkflowTestConfigurationConnectionRequestModel was null or undefined when calling updateWorkflowTestConfigurationConnection.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/workflow-test-configurations/{workflowId}/connections/{workflowNodeName}/{workflowConnectionKey}`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))).replace(`{${"workflowNodeName"}}`, encodeURIComponent(String(requestParameters.workflowNodeName))).replace(`{${"workflowConnectionKey"}}`, encodeURIComponent(String(requestParameters.workflowConnectionKey))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: UpdateWorkflowTestConfigurationConnectionRequestModelToJSON(requestParameters.updateWorkflowTestConfigurationConnectionRequestModel),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Update a workflow test configuration connection.
     * Update a workflow test configuration connection
     */
    async updateWorkflowTestConfigurationConnection(requestParameters: UpdateWorkflowTestConfigurationConnectionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.updateWorkflowTestConfigurationConnectionRaw(requestParameters, initOverrides);
    }

    /**
     * Update a workflow test configuration inputs.
     * Update a workflow test configuration inputs
     */
    async updateWorkflowTestConfigurationInputsRaw(requestParameters: UpdateWorkflowTestConfigurationInputsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.workflowId === null || requestParameters.workflowId === undefined) {
            throw new runtime.RequiredError('workflowId','Required parameter requestParameters.workflowId was null or undefined when calling updateWorkflowTestConfigurationInputs.');
        }

        if (requestParameters.updateWorkflowTestConfigurationInputsRequestModel === null || requestParameters.updateWorkflowTestConfigurationInputsRequestModel === undefined) {
            throw new runtime.RequiredError('updateWorkflowTestConfigurationInputsRequestModel','Required parameter requestParameters.updateWorkflowTestConfigurationInputsRequestModel was null or undefined when calling updateWorkflowTestConfigurationInputs.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/workflow-test-configurations/{workflowId}/inputs`.replace(`{${"workflowId"}}`, encodeURIComponent(String(requestParameters.workflowId))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: UpdateWorkflowTestConfigurationInputsRequestModelToJSON(requestParameters.updateWorkflowTestConfigurationInputsRequestModel),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Update a workflow test configuration inputs.
     * Update a workflow test configuration inputs
     */
    async updateWorkflowTestConfigurationInputs(requestParameters: UpdateWorkflowTestConfigurationInputsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.updateWorkflowTestConfigurationInputsRaw(requestParameters, initOverrides);
    }

}
