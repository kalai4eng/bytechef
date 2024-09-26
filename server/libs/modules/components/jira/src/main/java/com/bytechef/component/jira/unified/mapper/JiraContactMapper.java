/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.jira.unified.mapper;

import com.bytechef.component.definition.unified.crm.mapper.ProviderContactMapper;
import com.bytechef.component.definition.unified.crm.model.ContactUnifiedInputModel;
import com.bytechef.component.definition.unified.crm.model.ContactUnifiedOutputModel;
import com.bytechef.component.jira.unified.model.JiraContactInputModel;
import com.bytechef.component.jira.unified.model.JiraContactOutputModel;
import java.util.List;

/**
 * @author Ivica Cardic
 */
public class JiraContactMapper
    implements ProviderContactMapper<JiraContactInputModel, JiraContactOutputModel> {

    @Override
    public JiraContactInputModel desunify(
        ContactUnifiedInputModel inputModel, List<CustomFieldMapping> customFieldMappings) {

        return null;
    }

    @Override
    public ContactUnifiedOutputModel unify(
        JiraContactOutputModel outputModel, List<CustomFieldMapping> customFieldMappings) {

        return null;
    }
}