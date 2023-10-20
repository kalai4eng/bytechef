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

package com.bytechef.component.odsfile.action;

import static com.bytechef.component.odsfile.constant.OdsFileConstants.FILENAME;
import static com.bytechef.component.odsfile.constant.OdsFileConstants.ROWS;
import static com.bytechef.component.odsfile.constant.OdsFileConstants.SHEET_NAME;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import com.bytechef.component.odsfile.OdsFileComponentHandlerTest;
import com.bytechef.hermes.component.definition.ActionDefinition.ActionContext;
import com.bytechef.hermes.component.definition.Context;
import com.bytechef.hermes.component.definition.ParameterMap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Files;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/**
 * @author Ivica Cardic
 */
@Disabled
public class OdsFileWriteActionTest {

    @Test
    public void testPerformWriteODS() throws JSONException, IOException {
        ActionContext context = Mockito.mock(ActionContext.class);
        ParameterMap parameterMap = Mockito.mock(ParameterMap.class);

        String jsonContent = Files.contentOf(getFile("sample.json"), StandardCharsets.UTF_8);

        ParameterMap inputParameters = getWriteParameters(new JSONArray(jsonContent).toList(), parameterMap);

        OdsFileWriteAction.perform(inputParameters, parameterMap, context);

        ArgumentCaptor<ByteArrayInputStream> inputStreamArgumentCaptor = ArgumentCaptor.forClass(
            ByteArrayInputStream.class);
        ArgumentCaptor<String> filenameArgumentCaptor = ArgumentCaptor.forClass(String.class);

        Mockito.verify(context)
            .file(
                file1 -> file1.storeContent(filenameArgumentCaptor.capture(), inputStreamArgumentCaptor.capture()));

        assertEquals(
            new JSONArray(jsonContent), new JSONArray(read(inputStreamArgumentCaptor.getValue())), true);
        Assertions.assertThat(filenameArgumentCaptor.getValue())
            .isEqualTo("file.ods");
    }

    private File getFile(String filename) {
        return new File(OdsFileComponentHandlerTest.class
            .getClassLoader()
            .getResource("dependencies/" + filename)
            .getFile());
    }

    private ParameterMap getWriteParameters(List<?> items, ParameterMap inputParameters) {
        Mockito.when(inputParameters.getString(Mockito.eq(FILENAME), Mockito.eq("file.ods")))
            .thenReturn("file.ods");
        Mockito.when(inputParameters.getList(
            Mockito.eq(ROWS), Mockito.any(Context.TypeReference.class), Mockito.eq(List.of())))
            .thenReturn(items);
        Mockito.when(inputParameters.getString(Mockito.eq(SHEET_NAME), Mockito.eq("Sheet")))
            .thenReturn("Sheet");

        return inputParameters;
    }

    private static List<Map<String, ?>> read(InputStream inputStream) throws IOException {
        return OdsFileReadAction.read(
            inputStream,
            new OdsFileReadAction.ReadConfiguration(true, true, 0, Integer.MAX_VALUE, false, "Sheet"));
    }
}
