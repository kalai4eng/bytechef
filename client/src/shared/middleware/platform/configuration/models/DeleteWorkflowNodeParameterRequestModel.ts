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

import { mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface DeleteWorkflowNodeParameterRequestModel
 */
export interface DeleteWorkflowNodeParameterRequestModel {
    /**
     * The workflow node parameter path.
     * @type {string}
     * @memberof DeleteWorkflowNodeParameterRequestModel
     */
    path: string;
    /**
     * The workflow node name.
     * @type {string}
     * @memberof DeleteWorkflowNodeParameterRequestModel
     */
    workflowNodeName: string;
}

/**
 * Check if a given object implements the DeleteWorkflowNodeParameterRequestModel interface.
 */
export function instanceOfDeleteWorkflowNodeParameterRequestModel(value: object): boolean {
    if (!('path' in value)) return false;
    if (!('workflowNodeName' in value)) return false;
    return true;
}

export function DeleteWorkflowNodeParameterRequestModelFromJSON(json: any): DeleteWorkflowNodeParameterRequestModel {
    return DeleteWorkflowNodeParameterRequestModelFromJSONTyped(json, false);
}

export function DeleteWorkflowNodeParameterRequestModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): DeleteWorkflowNodeParameterRequestModel {
    if (json == null) {
        return json;
    }
    return {
        
        'path': json['path'],
        'workflowNodeName': json['workflowNodeName'],
    };
}

export function DeleteWorkflowNodeParameterRequestModelToJSON(value?: DeleteWorkflowNodeParameterRequestModel | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'path': value['path'],
        'workflowNodeName': value['workflowNodeName'],
    };
}
