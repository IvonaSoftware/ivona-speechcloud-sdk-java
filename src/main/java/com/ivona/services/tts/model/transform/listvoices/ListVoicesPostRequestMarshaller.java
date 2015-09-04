/*
 * Copyright 2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 *    http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.ivona.services.tts.model.transform.listvoices;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONWriter;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.ListVoicesRequest;
import com.ivona.services.tts.model.Voice;

import java.io.StringWriter;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * ListVoicesRequest Marshaller - transforms ListVoicesRequest into Json request
 */
public class ListVoicesPostRequestMarshaller implements Marshaller<Request<ListVoicesRequest>, ListVoicesRequest>,
        ListVoicesRequestMarshaller {

    private final static String RESOURCE_PATH = "ListVoices";

    protected final static String JSON_KEY_VOICE = "Voice";
    protected final static String JSON_KEY_GENDER = "Gender";
    protected final static String JSON_KEY_LANGUAGE = "Language";
    protected final static String JSON_KEY_NAME = "Name";

    public Request<ListVoicesRequest> marshall(ListVoicesRequest listVoicesRequest) {

        if (listVoicesRequest == null) {
            throw new AmazonClientException("null listVoicesRequest passed to marshall(...)");
        }

        Request<ListVoicesRequest> request = new DefaultRequest<ListVoicesRequest>(listVoicesRequest,
                IvonaSpeechCloudClient.SERVICE_NAME);
        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath(RESOURCE_PATH);
        setRequestPayload(request, listVoicesRequest);
        return request;
    }

    private void setRequestPayload(Request<ListVoicesRequest> request, ListVoicesRequest listVoicesRequest) {
        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();
            if (listVoicesRequest.getVoice() != null) {
                Voice voice = listVoicesRequest.getVoice();

                jsonWriter.key(JSON_KEY_VOICE);
                jsonWriter.object();

                if (voice.getGender() != null) {
                    jsonWriter.key(JSON_KEY_GENDER).value(voice.getGender());
                }
                if (voice.getLanguage() != null) {
                    jsonWriter.key(JSON_KEY_LANGUAGE).value(voice.getLanguage());
                }
                if (voice.getName() != null) {
                    jsonWriter.key(JSON_KEY_NAME).value(voice.getName());
                }

                jsonWriter.endObject();
            }
            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF_8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
        } catch (Throwable t) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }
    }
}
