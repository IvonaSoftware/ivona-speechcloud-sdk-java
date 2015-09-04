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
import com.ivona.services.tts.model.GetLexiconRequest;
import com.ivona.services.tts.model.transform.MarshallerHelper;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * GetLexiconRequest Marshaller - transforms GetLexiconRequest class into Json POST request
 */
public class GetLexiconPostRequestMarshaller implements Marshaller<Request<GetLexiconRequest>, GetLexiconRequest>,
        GetLexiconRequestMarshaller {

    protected final static String RESOURCE_PATH = "GetLexicon";

    public Request<GetLexiconRequest> marshall(GetLexiconRequest getLexiconRequest) {
        if (getLexiconRequest == null) {
            throw new AmazonClientException("null getLexiconRequest passed to marshall(...)");
        }

        Request<GetLexiconRequest> request = new DefaultRequest<GetLexiconRequest>(getLexiconRequest,
                IvonaSpeechCloudClient.SERVICE_NAME);
        request.setHttpMethod(HttpMethodName.POST);
        setRequestPayload(request, getLexiconRequest);
        request.setResourcePath(RESOURCE_PATH);

        return request;
    }

    private void setRequestPayload(Request<GetLexiconRequest> request, GetLexiconRequest getLexiconRequest) {
        StringWriter stringWriter = new StringWriter();
        JSONWriter jsonWriter = new JSONWriter(stringWriter);

        try {
            jsonWriter.object();

            if (MarshallerHelper.stringIsNotBlank(getLexiconRequest.getLexiconName())) {
                jsonWriter.key("Name").value(getLexiconRequest.getLexiconName());
            } else {
                throw new AmazonClientException("null or empty lexicon name passed to marshall(...)");
            }

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
