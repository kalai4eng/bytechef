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

package com.integri.atlas.task.handler.xlsx.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONParser;

/**
 * @author Ivica Cardic
 */
public class XlsxFileTaskDefinitionTest {

    private final ObjectMapper objectMapper = new ObjectMapper() {
        {
            setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
    };

    @Test
    public void testXlsxFileTaskDefinition() throws JsonProcessingException {
        JSONAssert.assertEquals(
            """
            {
              "description": "Reads and writes data from a XLS/XLSX file.",
              "displayName": "XLSX File",
              "name": "xlsxFile",
              "operations": [
                {
                  "description": "Reads data from a XLS/XLSX file.",
                  "name": "read",
                  "inputs": [
                    {
                      "description": "The object property which contains a reference to the XLS/XLSX file to read from.",
                      "displayName": "File",
                      "name": "fileEntry",
                      "required": true,
                      "type": "OBJECT",
                      "properties": [
                        {
                          "name": "extension",
                          "required": true,
                          "type": "STRING"
                        },
                        {
                          "name": "mimeType",
                          "required": true,
                          "type": "STRING"
                        },
                        {
                          "name": "name",
                          "required": true,
                          "type": "STRING"
                        },
                        {
                          "name": "url",
                          "required": true,
                          "type": "STRING"
                        }
                      ]
                    },
                    {
                      "displayName": "Options",
                      "placeholder": "Add Option",
                      "options": [
                        {
                          "description": "The first row of the file contains the header names.",
                          "displayName": "Header Row",
                          "name": "headerRow",
                          "defaultValue": true,
                          "type": "BOOLEAN"
                        },
                        {
                          "description": "When reading from file the empty cells will be filled with an empty string.",
                          "displayName": "Include Empty Cells",
                          "name": "includeEmptyCells",
                          "defaultValue": false,
                          "type": "BOOLEAN"
                        },
                        {
                          "description": "The amount of child elements to return in a page.",
                          "displayName": "Page Size",
                          "name": "pageSize",
                          "type": "INTEGER"
                        },
                        {
                          "description": "The page number to get.",
                          "displayName": "Page Number",
                          "name": "pageNumber",
                          "type": "INTEGER"
                        },
                        {
                          "description": "In some cases and file formats, it is necessary to read data specifically as string, otherwise some special characters are interpreted the wrong way.",
                          "displayName": "Read As String",
                          "name": "readAsString",
                          "defaultValue": false,
                          "type": "BOOLEAN"
                        },
                        {
                          "description": "The name of the sheet to read from in the spreadsheet. If not set, the first one gets chosen.",
                          "displayName": "Sheet Name",
                          "name": "sheetName",
                          "defaultValue": "Sheet",
                          "type": "STRING"
                        }
                      ]
                    }
                  ],
                  "outputs": [
                    {
                      "type": "ARRAY"
                    }
                  ],
                  "displayName": "Read from file"
                },
                {
                  "description": "Writes the data to a XLS/XLSX file.",
                  "name": "write",
                  "inputs": [
                    {
                      "description": "The array of objects to write to the file.",
                      "displayName": "Rows",
                      "name": "rows",
                      "required": true,
                      "type": "ARRAY",
                      "items": [
                        {
                          "type": "OBJECT",
                          "additionalProperties": true,
                          "properties": [
                            {
                              "type": "BOOLEAN"
                            },
                            {
                              "type": "DATE_TIME"
                            },
                            {
                              "type": "NUMBER"
                            },
                            {
                              "type": "STRING"
                            }
                          ]
                        }
                      ]
                    },
                    {
                      "displayName": "Options",
                      "placeholder": "Add Option",
                      "options": [
                        {
                          "description": "File name to set for binary data. By default, \\"file.xlsx\\" will be used.",
                          "displayName": "File Name",
                          "name": "fileName",
                          "defaultValue": "",
                          "type": "STRING"
                        },
                        {
                          "description": "The name of the sheet to create in the spreadsheet.",
                          "displayName": "Sheet Name",
                          "name": "sheetName",
                          "defaultValue": "Sheet",
                          "type": "STRING"
                        }
                      ]
                    }
                  ],
                  "outputs": [
                    {
                      "type": "OBJECT",
                      "properties": [
                        {
                          "name": "extension",
                          "required": true,
                          "type": "STRING"
                        },
                        {
                          "name": "mimeType",
                          "required": true,
                          "type": "STRING"
                        },
                        {
                          "name": "name",
                          "required": true,
                          "type": "STRING"
                        },
                        {
                          "name": "url",
                          "required": true,
                          "type": "STRING"
                        }
                      ]
                    }
                  ],
                  "displayName": "Write to file"
                }
              ],
              "version": 1
            }
            """,
            (JSONObject) JSONParser.parseJSON(
                objectMapper.writeValueAsString(new XlsxFileTaskDefinitionHandler().getTaskDefinition())
            ),
            true
        );
    }
}
