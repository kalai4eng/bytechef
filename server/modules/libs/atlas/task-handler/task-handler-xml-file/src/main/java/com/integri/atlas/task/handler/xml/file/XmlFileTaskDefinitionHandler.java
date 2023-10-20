/*
 * Copyright 2021 <your company/name>.
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

package com.integri.atlas.task.handler.xml.file;

import static com.integri.atlas.task.definition.dsl.DSL.ANY_PROPERTY;
import static com.integri.atlas.task.definition.dsl.DSL.ARRAY_PROPERTY;
import static com.integri.atlas.task.definition.dsl.DSL.BOOLEAN_PROPERTY;
import static com.integri.atlas.task.definition.dsl.DSL.FILE_ENTRY_PROPERTY;
import static com.integri.atlas.task.definition.dsl.DSL.INTEGER_PROPERTY;
import static com.integri.atlas.task.definition.dsl.DSL.OBJECT_PROPERTY;
import static com.integri.atlas.task.definition.dsl.DSL.OPERATION;
import static com.integri.atlas.task.definition.dsl.DSL.OPTIONS;
import static com.integri.atlas.task.definition.dsl.DSL.STRING_PROPERTY;
import static com.integri.atlas.task.definition.dsl.DSL.showWhen;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.PROPERTY_FILE_ENTRY;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.PROPERTY_FILE_NAME;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.PROPERTY_IS_ARRAY;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.PROPERTY_PAGE_NUMBER;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.PROPERTY_PAGE_SIZE;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.PROPERTY_PATH;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.PROPERTY_SOURCE;
import static com.integri.atlas.task.handler.xml.file.XmlFileTaskConstants.TASK_XML_FILE;

import com.integri.atlas.task.definition.TaskDefinitionHandler;
import com.integri.atlas.task.definition.dsl.DSL;
import com.integri.atlas.task.definition.dsl.TaskDefinition;
import org.springframework.stereotype.Component;

/**
 * @author Ivica Cardic
 */
@Component
public class XmlFileTaskDefinitionHandler implements TaskDefinitionHandler {

    private static final TaskDefinition TASK_DEFINITION = DSL
        .create(TASK_XML_FILE)
        .displayName("XML File")
        .description("Reads and writes data from a XML file.")
        .operations(
            OPERATION("read")
                .displayName("Read from file")
                .description("Reads data from a XML file.")
                .inputs(
                    FILE_ENTRY_PROPERTY(PROPERTY_FILE_ENTRY)
                        .displayName("File")
                        .description("The object property which contains a reference to the XML file to read from.")
                        .required(true),
                    BOOLEAN_PROPERTY(PROPERTY_IS_ARRAY)
                        .displayName("Is Array")
                        .description("The object input is array?")
                        .defaultValue(true),
                    OPTIONS()
                        .displayName("Options")
                        .placeholder("Add Option")
                        .options(
                            STRING_PROPERTY(PROPERTY_PATH)
                                .displayName("Path")
                                .description(
                                    "The path where the array is e.g 'data'. Leave blank to use the top level object."
                                )
                                .displayOption(showWhen(PROPERTY_IS_ARRAY).in(true)),
                            INTEGER_PROPERTY(PROPERTY_PAGE_SIZE)
                                .displayName("Page Size")
                                .description("The amount of child elements to return in a page.")
                                .displayOption(showWhen(PROPERTY_IS_ARRAY).in(true)),
                            INTEGER_PROPERTY(PROPERTY_PAGE_NUMBER)
                                .displayName("Page Number")
                                .description("The page number to get.")
                                .displayOption(showWhen(PROPERTY_IS_ARRAY).in(true))
                        )
                )
                .outputs(ARRAY_PROPERTY(), OBJECT_PROPERTY()),
            OPERATION("write")
                .displayName("Write to file")
                .description("Writes the data to a XML file.")
                .inputs(
                    ANY_PROPERTY(PROPERTY_SOURCE)
                        .displayName("Source")
                        .description("The data to write to the file.")
                        .required(true)
                        .types(ARRAY_PROPERTY(), OBJECT_PROPERTY()),
                    STRING_PROPERTY(PROPERTY_FILE_NAME)
                        .displayName("File Name")
                        .description("File name to set for binary data. By default, \"file.xml\" will be used.")
                        .defaultValue("file.xml")
                )
                .outputs(FILE_ENTRY_PROPERTY())
        );

    @Override
    public TaskDefinition getTaskDefinition() {
        return TASK_DEFINITION;
    }
}
