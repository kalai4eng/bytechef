/* tslint:disable */
/* eslint-disable */
/**
 * The Embedded Configuration Internal API
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
import type { IntegrationStatus } from './IntegrationStatus';
import {
    IntegrationStatusFromJSON,
    IntegrationStatusFromJSONTyped,
    IntegrationStatusToJSON,
} from './IntegrationStatus';

/**
 * A group of workflows that make one logical integration.
 * @export
 * @interface IntegrationBasic
 */
export interface IntegrationBasic {
    /**
     * If multiple instances of an integration are allowed or not.
     * @type {boolean}
     * @memberof IntegrationBasic
     */
    allowMultipleInstances: boolean;
    /**
     * The name of the integration's component.
     * @type {string}
     * @memberof IntegrationBasic
     */
    componentName: string;
    /**
     * The version of the integration's component.
     * @type {number}
     * @memberof IntegrationBasic
     */
    componentVersion: number;
    /**
     * The created by.
     * @type {string}
     * @memberof IntegrationBasic
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof IntegrationBasic
     */
    readonly createdDate?: Date;
    /**
     * The description of an integration.
     * @type {string}
     * @memberof IntegrationBasic
     */
    description?: string;
    /**
     * The id of an integration.
     * @type {number}
     * @memberof IntegrationBasic
     */
    readonly id?: number;
    /**
     * The last modified by.
     * @type {string}
     * @memberof IntegrationBasic
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof IntegrationBasic
     */
    readonly lastModifiedDate?: Date;
    /**
     * The last published date.
     * @type {Date}
     * @memberof IntegrationBasic
     */
    readonly lastPublishedDate?: Date;
    /**
     * 
     * @type {IntegrationStatus}
     * @memberof IntegrationBasic
     */
    lastStatus?: IntegrationStatus;
    /**
     * The last version of an integration.
     * @type {number}
     * @memberof IntegrationBasic
     */
    readonly lastIntegrationVersion?: number;
    /**
     * The name of an integration.
     * @type {string}
     * @memberof IntegrationBasic
     */
    name?: string;
}



/**
 * Check if a given object implements the IntegrationBasic interface.
 */
export function instanceOfIntegrationBasic(value: object): value is IntegrationBasic {
    if (!('allowMultipleInstances' in value) || value['allowMultipleInstances'] === undefined) return false;
    if (!('componentName' in value) || value['componentName'] === undefined) return false;
    if (!('componentVersion' in value) || value['componentVersion'] === undefined) return false;
    return true;
}

export function IntegrationBasicFromJSON(json: any): IntegrationBasic {
    return IntegrationBasicFromJSONTyped(json, false);
}

export function IntegrationBasicFromJSONTyped(json: any, ignoreDiscriminator: boolean): IntegrationBasic {
    if (json == null) {
        return json;
    }
    return {
        
        'allowMultipleInstances': json['allowMultipleInstances'],
        'componentName': json['componentName'],
        'componentVersion': json['componentVersion'],
        'createdBy': json['createdBy'] == null ? undefined : json['createdBy'],
        'createdDate': json['createdDate'] == null ? undefined : (new Date(json['createdDate'])),
        'description': json['description'] == null ? undefined : json['description'],
        'id': json['id'] == null ? undefined : json['id'],
        'lastModifiedBy': json['lastModifiedBy'] == null ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': json['lastModifiedDate'] == null ? undefined : (new Date(json['lastModifiedDate'])),
        'lastPublishedDate': json['lastPublishedDate'] == null ? undefined : (new Date(json['lastPublishedDate'])),
        'lastStatus': json['lastStatus'] == null ? undefined : IntegrationStatusFromJSON(json['lastStatus']),
        'lastIntegrationVersion': json['lastIntegrationVersion'] == null ? undefined : json['lastIntegrationVersion'],
        'name': json['name'] == null ? undefined : json['name'],
    };
}

export function IntegrationBasicToJSON(value?: Omit<IntegrationBasic, 'createdBy'|'createdDate'|'id'|'lastModifiedBy'|'lastModifiedDate'|'lastPublishedDate'|'lastIntegrationVersion'> | null): any {
    if (value == null) {
        return value;
    }
    return {
        
        'allowMultipleInstances': value['allowMultipleInstances'],
        'componentName': value['componentName'],
        'componentVersion': value['componentVersion'],
        'description': value['description'],
        'lastStatus': IntegrationStatusToJSON(value['lastStatus']),
        'name': value['name'],
    };
}
