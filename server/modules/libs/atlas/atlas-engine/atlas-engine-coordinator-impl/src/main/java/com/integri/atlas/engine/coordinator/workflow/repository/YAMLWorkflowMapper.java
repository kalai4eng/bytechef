/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Modifications copyright (C) 2021 <your company/name>
 */

package com.integri.atlas.engine.coordinator.workflow.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.base.Throwables;
import com.integri.atlas.engine.coordinator.workflow.SimpleWorkflow;
import com.integri.atlas.engine.coordinator.workflow.Workflow;
import com.integri.atlas.engine.core.DSL;
import com.integri.atlas.engine.core.error.ErrorObject;
import com.integri.atlas.engine.core.task.SimpleWorkflowTask;
import com.integri.atlas.engine.core.task.Task;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Arik Cohen
 * @author Ivica Cardic
 */
public class YAMLWorkflowMapper implements WorkflowMapper, WorkflowMapperResolver {

    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public Workflow readValue(WorkflowResource aResource) {
        try {
            Map<String, Object> yamlMap = parse(aResource);
            yamlMap.put(DSL.ID, aResource.getId());
            return new SimpleWorkflow(yamlMap);
        } catch (Exception e) {
            SimpleWorkflow workflow = new SimpleWorkflow(Collections.singletonMap(DSL.ID, aResource.getId()));
            workflow.setError(new ErrorObject(e.getMessage(), ExceptionUtils.getStackFrames(e)));
            return workflow;
        }
    }

    @Override
    public WorkflowMapper resolve(WorkflowResource workflowResource) {
        return workflowResource.getFormatType() == WorkflowFormatType.YAML ? this : null;
    }

    private Map<String, Object> parse(Resource aResource) {
        try (InputStream in = aResource.getInputStream()) {
            String yaml = IOUtils.toString(in);
            Map<String, Object> yamlMap = mapper.readValue(yaml, Map.class);
            validate(yamlMap);
            List<Map<String, Object>> rawTasks = (List<Map<String, Object>>) yamlMap.get(DSL.TASKS);
            Assert.notNull(rawTasks, "no tasks found");
            Assert.notEmpty(rawTasks, "no tasks found");
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < rawTasks.size(); i++) {
                Map<String, Object> rt = rawTasks.get(i);
                SimpleWorkflowTask mutableTask = new SimpleWorkflowTask(rt);
                mutableTask.setTaskNumber(i + 1);
                tasks.add(mutableTask);
            }
            yamlMap.put(DSL.TASKS, tasks);
            return yamlMap;
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    private void validate(Map<String, Object> aMap) {
        validateReservedWords(aMap);
        validateOutputs(aMap);
    }

    private void validateOutputs(Map<String, Object> aWorkflow) {
        List<Map<String, Object>> outputs = (List<Map<String, Object>>) aWorkflow.get(DSL.OUTPUTS);
        for (int i = 0; outputs != null && i < outputs.size(); i++) {
            Map<String, Object> output = outputs.get(i);
            Assert.notNull(output.get(DSL.NAME), "output definition must specify a 'name'");
            Assert.notNull(output.get(DSL.VALUE), "output definition must specify a 'value'");
        }
    }

    private void validateReservedWords(Map<String, Object> aWorkflow) {
        List<String> reservedWords = Arrays.asList(DSL.RESERVED_WORDS);
        for (Map.Entry<String, Object> entry : aWorkflow.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            Assert.isTrue(!reservedWords.contains(k), "reserved word: " + k);
            if (v instanceof Map) {
                validate((Map<String, Object>) v);
            }
            if (v instanceof List) {
                List<Object> items = (List<Object>) v;
                for (Object item : items) {
                    if (item instanceof Map) {
                        validate((Map<String, Object>) item);
                    }
                }
            }
        }
    }
}
