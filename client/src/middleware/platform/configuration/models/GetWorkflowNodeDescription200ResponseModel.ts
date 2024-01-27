/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface GetWorkflowNodeDescription200ResponseModel
 */
export interface GetWorkflowNodeDescription200ResponseModel {
    /**
     * 
     * @type {string}
     * @memberof GetWorkflowNodeDescription200ResponseModel
     */
    description?: string;
}

/**
 * Check if a given object implements the GetWorkflowNodeDescription200ResponseModel interface.
 */
export function instanceOfGetWorkflowNodeDescription200ResponseModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function GetWorkflowNodeDescription200ResponseModelFromJSON(json: any): GetWorkflowNodeDescription200ResponseModel {
    return GetWorkflowNodeDescription200ResponseModelFromJSONTyped(json, false);
}

export function GetWorkflowNodeDescription200ResponseModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): GetWorkflowNodeDescription200ResponseModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'description': !exists(json, 'description') ? undefined : json['description'],
    };
}

export function GetWorkflowNodeDescription200ResponseModelToJSON(value?: GetWorkflowNodeDescription200ResponseModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'description': value.description,
    };
}

