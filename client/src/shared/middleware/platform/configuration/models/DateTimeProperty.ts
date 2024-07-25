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
import type { OptionsDataSource } from './OptionsDataSource';
import {
    OptionsDataSourceFromJSON,
    OptionsDataSourceFromJSONTyped,
    OptionsDataSourceToJSON,
} from './OptionsDataSource';
import type { ControlType } from './ControlType';
import {
    ControlTypeFromJSON,
    ControlTypeFromJSONTyped,
    ControlTypeToJSON,
} from './ControlType';
import type { Option } from './Option';
import {
    OptionFromJSON,
    OptionFromJSONTyped,
    OptionToJSON,
} from './Option';
import type { PropertyType } from './PropertyType';
import {
    PropertyTypeFromJSON,
    PropertyTypeFromJSONTyped,
    PropertyTypeToJSON,
} from './PropertyType';
import type { ValueProperty } from './ValueProperty';
import {
    ValuePropertyFromJSON,
    ValuePropertyFromJSONTyped,
    ValuePropertyToJSON,
} from './ValueProperty';

/**
 * A date-time property type.
 * @export
 * @interface DateTimeProperty
 */
export interface DateTimeProperty extends ValueProperty {
    /**
     * The property default value.
     * @type {Date}
     * @memberof DateTimeProperty
     */
    defaultValue?: Date;
    /**
     * The property sample value.
     * @type {Date}
     * @memberof DateTimeProperty
     */
    exampleValue?: Date;
    /**
     * The list of valid property options.
     * @type {Array<Option>}
     * @memberof DateTimeProperty
     */
    options?: Array<Option>;
    /**
     * 
     * @type {OptionsDataSource}
     * @memberof DateTimeProperty
     */
    optionsDataSource?: OptionsDataSource;
}



/**
 * Check if a given object implements the DateTimeProperty interface.
 */
export function instanceOfDateTimeProperty(value: object): value is DateTimeProperty {
    return true;
}

export function DateTimePropertyFromJSON(json: any): DateTimeProperty {
    return DateTimePropertyFromJSONTyped(json, false);
}

export function DateTimePropertyFromJSONTyped(json: any, ignoreDiscriminator: boolean): DateTimeProperty {
    if (json == null) {
        return json;
    }
    return {
        ...ValuePropertyFromJSONTyped(json, ignoreDiscriminator),
        'defaultValue': json['defaultValue'] == null ? undefined : (new Date(json['defaultValue'])),
        'exampleValue': json['exampleValue'] == null ? undefined : (new Date(json['exampleValue'])),
        'options': json['options'] == null ? undefined : ((json['options'] as Array<any>).map(OptionFromJSON)),
        'optionsDataSource': json['optionsDataSource'] == null ? undefined : OptionsDataSourceFromJSON(json['optionsDataSource']),
    };
}

export function DateTimePropertyToJSON(value?: DateTimeProperty | null): any {
    if (value == null) {
        return value;
    }
    return {
        ...ValuePropertyToJSON(value),
        'defaultValue': value['defaultValue'] == null ? undefined : ((value['defaultValue']).toISOString()),
        'exampleValue': value['exampleValue'] == null ? undefined : ((value['exampleValue']).toISOString()),
        'options': value['options'] == null ? undefined : ((value['options'] as Array<any>).map(OptionToJSON)),
        'optionsDataSource': OptionsDataSourceToJSON(value['optionsDataSource']),
    };
}
