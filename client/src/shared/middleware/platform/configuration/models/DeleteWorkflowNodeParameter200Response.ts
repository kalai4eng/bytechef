/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration Internal API
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
 * @interface DeleteWorkflowNodeParameter200Response
 */
export interface DeleteWorkflowNodeParameter200Response {
    /**
     * 
     * @type {{ [key: string]: any; }}
     * @memberof DeleteWorkflowNodeParameter200Response
     */
    parameters?: { [key: string]: any; };
}

/**
 * Check if a given object implements the DeleteWorkflowNodeParameter200Response interface.
 */
export function instanceOfDeleteWorkflowNodeParameter200Response(value: object): value is DeleteWorkflowNodeParameter200Response {
    return true;
}

export function DeleteWorkflowNodeParameter200ResponseFromJSON(json: any): DeleteWorkflowNodeParameter200Response {
    return DeleteWorkflowNodeParameter200ResponseFromJSONTyped(json, false);
}

export function DeleteWorkflowNodeParameter200ResponseFromJSONTyped(json: any, ignoreDiscriminator: boolean): DeleteWorkflowNodeParameter200Response {
    if (json == null) {
        return json;
    }
    return {
        
        'parameters': json['parameters'] == null ? undefined : json['parameters'],
    };
}

export function DeleteWorkflowNodeParameter200ResponseToJSON(value?: DeleteWorkflowNodeParameter200Response | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'parameters': value['parameters'],
    };
}
