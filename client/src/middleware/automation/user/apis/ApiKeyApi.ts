/* tslint:disable */
/* eslint-disable */
/**
 * The Automation User API
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
  ApiKeyModel,
} from '../models/index';
import {
    ApiKeyModelFromJSON,
    ApiKeyModelToJSON,
} from '../models/index';

export interface CreateApiKeyRequest {
    apiKeyModel: ApiKeyModel;
}

export interface DeleteApiKeyRequest {
    id: number;
}

export interface GetApiKeyRequest {
    id: number;
}

export interface UpdateApiKeyRequest {
    id: number;
    apiKeyModel: ApiKeyModel;
}

/**
 * 
 */
export class ApiKeyApi extends runtime.BaseAPI {

    /**
     * Create a new API key.
     * Create a new API key
     */
    async createApiKeyRaw(requestParameters: CreateApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<ApiKeyModel>> {
        if (requestParameters['apiKeyModel'] == null) {
            throw new runtime.RequiredError(
                'apiKeyModel',
                'Required parameter "apiKeyModel" was null or undefined when calling createApiKey().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/api-keys`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ApiKeyModelToJSON(requestParameters['apiKeyModel']),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ApiKeyModelFromJSON(jsonValue));
    }

    /**
     * Create a new API key.
     * Create a new API key
     */
    async createApiKey(requestParameters: CreateApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<ApiKeyModel> {
        const response = await this.createApiKeyRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Delete an API key.
     * Delete an API key
     */
    async deleteApiKeyRaw(requestParameters: DeleteApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters['id'] == null) {
            throw new runtime.RequiredError(
                'id',
                'Required parameter "id" was null or undefined when calling deleteApiKey().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/api-keys/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters['id']))),
            method: 'DELETE',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Delete an API key.
     * Delete an API key
     */
    async deleteApiKey(requestParameters: DeleteApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.deleteApiKeyRaw(requestParameters, initOverrides);
    }

    /**
     * Get an API key by id.
     * Get an API key by id
     */
    async getApiKeyRaw(requestParameters: GetApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<ApiKeyModel>> {
        if (requestParameters['id'] == null) {
            throw new runtime.RequiredError(
                'id',
                'Required parameter "id" was null or undefined when calling getApiKey().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/api-keys/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters['id']))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ApiKeyModelFromJSON(jsonValue));
    }

    /**
     * Get an API key by id.
     * Get an API key by id
     */
    async getApiKey(requestParameters: GetApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<ApiKeyModel> {
        const response = await this.getApiKeyRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get API keys.
     * Get API keys
     */
    async getApiKeysRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<ApiKeyModel>>> {
        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/api-keys`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(ApiKeyModelFromJSON));
    }

    /**
     * Get API keys.
     * Get API keys
     */
    async getApiKeys(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<ApiKeyModel>> {
        const response = await this.getApiKeysRaw(initOverrides);
        return await response.value();
    }

    /**
     * Update an existing API key.
     * Update an existing API key
     */
    async updateApiKeyRaw(requestParameters: UpdateApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<ApiKeyModel>> {
        if (requestParameters['id'] == null) {
            throw new runtime.RequiredError(
                'id',
                'Required parameter "id" was null or undefined when calling updateApiKey().'
            );
        }

        if (requestParameters['apiKeyModel'] == null) {
            throw new runtime.RequiredError(
                'apiKeyModel',
                'Required parameter "apiKeyModel" was null or undefined when calling updateApiKey().'
            );
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/api-keys/{id}`.replace(`{${"id"}}`, encodeURIComponent(String(requestParameters['id']))),
            method: 'PUT',
            headers: headerParameters,
            query: queryParameters,
            body: ApiKeyModelToJSON(requestParameters['apiKeyModel']),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ApiKeyModelFromJSON(jsonValue));
    }

    /**
     * Update an existing API key.
     * Update an existing API key
     */
    async updateApiKey(requestParameters: UpdateApiKeyRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<ApiKeyModel> {
        const response = await this.updateApiKeyRaw(requestParameters, initOverrides);
        return await response.value();
    }

}