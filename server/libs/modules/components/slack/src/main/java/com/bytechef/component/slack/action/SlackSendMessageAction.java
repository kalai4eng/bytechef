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

package com.bytechef.component.slack.action;

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.option;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.slack.constant.SlackConstants.AS_USER_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.CHANNEL_ID;
import static com.bytechef.component.slack.constant.SlackConstants.CHAT_POST_MESSAGE_RESPONSE_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.CONTENT_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.CONTENT_TYPE_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.ICON_EMOJI_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.ICON_URL_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.LINK_NAMES_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.METADATA_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.MRKDWN_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.PARSE_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.REPLY_BROADCAST_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.SEND_MESSAGE;
import static com.bytechef.component.slack.constant.SlackConstants.THREAD_TS_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.UNFURL_LINKS_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.UNFURL_MEDIA_PROPERTY;
import static com.bytechef.component.slack.constant.SlackConstants.USERNAME_PROPERTY;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.Option;
import com.bytechef.component.definition.OptionsDataSource.ActionOptionsFunction;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.slack.util.SlackUtils;
import com.slack.api.bolt.App;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.conversations.ConversationsListRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.methods.response.conversations.ConversationsListResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Mario Cvjetojevic
 */
public final class SlackSendMessageAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(SEND_MESSAGE)
        .title("Send message")
        .description(
            "Posts a message to a public channel, private channel, or existing direct message conversation.")
        .properties(
            string(CHANNEL_ID)
                .label("Channel")
                .description(
                    "The id of a channel where the message will be sent.")
                .options((ActionOptionsFunction<String>) SlackSendMessageAction::getChannelOptions)
                .required(true),
            CONTENT_TYPE_PROPERTY,
            CONTENT_PROPERTY,
            AS_USER_PROPERTY,
            ICON_EMOJI_PROPERTY,
            ICON_URL_PROPERTY,
            LINK_NAMES_PROPERTY,
            METADATA_PROPERTY,
            MRKDWN_PROPERTY,
            PARSE_PROPERTY,
            REPLY_BROADCAST_PROPERTY,
            THREAD_TS_PROPERTY,
            UNFURL_LINKS_PROPERTY,
            UNFURL_MEDIA_PROPERTY,
            USERNAME_PROPERTY)
        .outputSchema(CHAT_POST_MESSAGE_RESPONSE_PROPERTY)
        .perform(SlackSendMessageAction::perform);

    private SlackSendMessageAction() {
    }

    public static ChatPostMessageResponse perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext)
        throws IOException, SlackApiException {

        return SlackUtils.chatPostMessage(inputParameters, connectionParameters, CHANNEL_ID);
    }

    public static List<Option<String>> getChannelOptions(
        Parameters inputParameters, Parameters connectionParameters, Map<String, String> dependencyPaths,
        String searchText, ActionContext context)
        throws IOException, SlackApiException {

        ConversationsListResponse response = new App()
            .client()
            .conversationsList(
                ConversationsListRequest
                    .builder()
                    .token(connectionParameters.getRequiredString(ACCESS_TOKEN))
                    .build());

        return response.getChannels()
            .stream()
            .filter(channel -> StringUtils.isNotEmpty(searchText) &&
                StringUtils.startsWith(channel.getName(), searchText))
            .map(channel -> (Option<String>) option(channel.getName(), channel.getId()))
            .toList();
    }
}
