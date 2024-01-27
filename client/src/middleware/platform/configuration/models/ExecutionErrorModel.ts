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
 * Contains information about an error that happened during execution.
 * @export
 * @interface ExecutionErrorModel
 */
export interface ExecutionErrorModel {
    /**
     * The error message.
     * @type {string}
     * @memberof ExecutionErrorModel
     */
    message?: string;
    /**
     * The error stacktrace.
     * @type {Array<string>}
     * @memberof ExecutionErrorModel
     */
    stackTrace?: Array<string>;
}

/**
 * Check if a given object implements the ExecutionErrorModel interface.
 */
export function instanceOfExecutionErrorModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function ExecutionErrorModelFromJSON(json: any): ExecutionErrorModel {
    return ExecutionErrorModelFromJSONTyped(json, false);
}

export function ExecutionErrorModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): ExecutionErrorModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'message': !exists(json, 'message') ? undefined : json['message'],
        'stackTrace': !exists(json, 'stackTrace') ? undefined : json['stackTrace'],
    };
}

export function ExecutionErrorModelToJSON(value?: ExecutionErrorModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'message': value.message,
        'stackTrace': value.stackTrace,
    };
}

