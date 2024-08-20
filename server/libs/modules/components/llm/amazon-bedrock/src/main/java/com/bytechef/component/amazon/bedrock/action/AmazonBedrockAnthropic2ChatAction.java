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

package com.bytechef.component.amazon.bedrock.action;

import com.bytechef.component.amazon.bedrock.constant.AmazonBedrockConstants;
import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import com.bytechef.component.definition.Context.TypeReference;
import com.bytechef.component.definition.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.bedrock.anthropic.AnthropicChatOptions;
import org.springframework.ai.bedrock.anthropic.BedrockAnthropicChatModel;
import org.springframework.ai.bedrock.anthropic.api.AnthropicChatBedrockApi;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.ChatOptions;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import util.LLMUtils;
import util.interfaces.Chat;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.string;
import static constants.LLMConstants.MAX_TOKENS;
import static constants.LLMConstants.MAX_TOKENS_PROPERTY;
import static constants.LLMConstants.MESSAGE_PROPERTY;
import static constants.LLMConstants.MODEL;
import static constants.LLMConstants.N;
import static constants.LLMConstants.N_PROPERTY;
import static constants.LLMConstants.STOP;
import static constants.LLMConstants.STOP_PROPERTY;
import static constants.LLMConstants.TEMPERATURE;
import static constants.LLMConstants.TEMPERATURE_PROPERTY;
import static constants.LLMConstants.TOP_P;
import static constants.LLMConstants.TOP_P_PROPERTY;

public class AmazonBedrockAnthropic2ChatAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(AmazonBedrockConstants.ASK_ANTHROPIC2)
        .title("Ask Anthropic2")
        .description("Ask anything you want.")
        .properties(
            string(MODEL)
                .label("Model")
                .description("ID of the model to use.")
                .required(true)
                .options(LLMUtils.getEnumOptions(
                    Arrays.stream(AnthropicChatBedrockApi.AnthropicChatModel.values())
                        .collect(Collectors.toMap(
                            AnthropicChatBedrockApi.AnthropicChatModel::getName, AnthropicChatBedrockApi.AnthropicChatModel::getName, (f,s)->f)))),
            MESSAGE_PROPERTY,
            N_PROPERTY,
            MAX_TOKENS_PROPERTY,
            TEMPERATURE_PROPERTY,
            STOP_PROPERTY,
            TOP_P_PROPERTY)
        .outputSchema(string())
        .perform(AmazonBedrockAnthropic2ChatAction::perform);

    private AmazonBedrockAnthropic2ChatAction() {
    }

    public static String perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext context) {
        return Chat.getResponse(CHAT, inputParameters, connectionParameters);
    }

    public static final Chat CHAT = new Chat() {
        @Override
        public ChatOptions createChatOptions(Parameters inputParameters) {
            return AnthropicChatOptions.builder()
                .withTemperature(inputParameters.getFloat(TEMPERATURE))
                .withMaxTokensToSample(inputParameters.getInteger(MAX_TOKENS))
                .withTopP(inputParameters.getFloat(TOP_P))
                .withStopSequences(inputParameters.getList(STOP, new TypeReference<>() {}))
                .withTopK(inputParameters.getInteger(N))
                .build();
        }

        @Override
        public ChatModel createChatModel(Parameters inputParameters, Parameters connectionParameters) {
            return new BedrockAnthropicChatModel(new AnthropicChatBedrockApi(inputParameters.getRequiredString(MODEL),
                EnvironmentVariableCredentialsProvider.create(), connectionParameters.getRequiredString(AmazonBedrockConstants.REGION), new ObjectMapper()),
                (AnthropicChatOptions) createChatOptions(inputParameters));
        }
    };
}