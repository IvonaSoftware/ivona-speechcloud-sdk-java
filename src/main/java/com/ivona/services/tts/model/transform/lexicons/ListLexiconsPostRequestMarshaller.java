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
package com.ivona.services.tts.model.transform.lexicons;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONWriter;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.ListLexiconsRequest;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * ListLexiconsRequest Marshaller - transforms ListLexiconsRequest class into Json POST request
 */
public class ListLexiconsPostRequestMarshaller implements Marshaller<Request<ListLexiconsRequest>, ListLexiconsRequest>,
        ListLexiconsRequestMarshaller {

    protected final static String RESOURCE_PATH = "ListLexicons";

    public Request<ListLexiconsRequest> marshall(ListLexiconsRequest listLexiconsRequest) {
        if (listLexiconsRequest == null) {
            throw new AmazonClientException("null listLexiconsRequest passed to marshall(...)");
        }

        Request<ListLexiconsRequest> request = new DefaultRequest<ListLexiconsRequest>(listLexiconsRequest,
                IvonaSpeechCloudClient.SERVICE_NAME);
        request.setHttpMethod(HttpMethodName.POST);
        setRequestPayload(request, listLexiconsRequest);
        request.setResourcePath(RESOURCE_PATH);

        return request;
    }

    private void setRequestPayload(Request<ListLexiconsRequest> request, ListLexiconsRequest listLexiconsRequest) {
        StringWriter stringWriter = new StringWriter();
        JSONWriter jsonWriter = new JSONWriter(stringWriter);

        try {
            jsonWriter.object();
            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF_8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
        } catch (JSONException e) {
            throw new AmazonClientException("Unable to marshall request to JSON", e);
        } catch (UnsupportedEncodingException e) {
            throw new AmazonClientException("Unable to marshall request to JSON", e);
        }
    }
}
