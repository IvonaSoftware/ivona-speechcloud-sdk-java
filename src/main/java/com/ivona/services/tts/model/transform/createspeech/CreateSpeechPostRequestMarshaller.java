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
package com.ivona.services.tts.model.transform.createspeech;

import java.io.StringWriter;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONWriter;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.CreateSpeechRequest;
import com.ivona.services.tts.model.Input;
import com.ivona.services.tts.model.OutputFormat;
import com.ivona.services.tts.model.Parameters;
import com.ivona.services.tts.model.Voice;

/**
 * CreateSpeechRequest Marshaller - transforms CreateSpeechRequest class into Json POST request
 */
public class CreateSpeechPostRequestMarshaller implements Marshaller<Request<CreateSpeechRequest>, CreateSpeechRequest>,
        CreateSpeechRequestMarshaller {

    private final static String RESOURCE_PATH = "/CreateSpeech";
    private final static String CHARSET = "UTF-8";

    public Request<CreateSpeechRequest> marshall(CreateSpeechRequest createSpeechRequest) {

        if (createSpeechRequest == null) {
            throw new AmazonClientException("null createSpeechRequest passed to marshall(...)");
        }

        Request<CreateSpeechRequest> request = new DefaultRequest<CreateSpeechRequest>(createSpeechRequest,
                IvonaSpeechCloudClient.SERVICE_NAME);
        request.setHttpMethod(HttpMethodName.POST);
        setRequestPayload(request, createSpeechRequest);
        request.setResourcePath(RESOURCE_PATH);

        return request;
    }

    private void setRequestPayload(Request<CreateSpeechRequest> request, CreateSpeechRequest createSpeechRequest) {
        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (createSpeechRequest.getInput() != null) {
                Input input = createSpeechRequest.getInput();

                jsonWriter.key("Input");
                jsonWriter.object();
                if (input.getData() != null) {
                    jsonWriter.key("Data").value(input.getData());
                }
                if (input.getType() != null) {
                    jsonWriter.key("Type").value(input.getType());
                }
                jsonWriter.endObject();
            }

            if (createSpeechRequest.getOutputFormat() != null) {
                OutputFormat outputFormat = createSpeechRequest.getOutputFormat();

                jsonWriter.key("OutputFormat");
                jsonWriter.object();
                if (outputFormat.getCodec() != null) {
                    jsonWriter.key("Codec").value(outputFormat.getCodec());
                }
                if (outputFormat.getSampleRate() != null && outputFormat.getSampleRate() > 0) {
                    jsonWriter.key("SampleRate").value((long) outputFormat.getSampleRate());
                }
                jsonWriter.endObject();
            }

            if (createSpeechRequest.getParameters() != null) {
                Parameters parameters = createSpeechRequest.getParameters();

                jsonWriter.key("Parameters");
                jsonWriter.object();
                if (parameters.getRate() != null) {
                    jsonWriter.key("Rate").value(parameters.getRate());
                }
                if (parameters.getVolume() != null) {
                    jsonWriter.key("Volume").value(parameters.getVolume());
                }
                if (parameters.getSentenceBreak() != null) {
                    jsonWriter.key("SentenceBreak").value((long) parameters.getSentenceBreak());
                }
                if (parameters.getParagraphBreak() != null) {
                    jsonWriter.key("ParagraphBreak").value((long) parameters.getParagraphBreak());
                }
                jsonWriter.endObject();
            }

            if (createSpeechRequest.getVoice() != null) {
                Voice voice = createSpeechRequest.getVoice();

                jsonWriter.key("Voice");
                jsonWriter.object();
                if (voice.getGender() != null) {
                    jsonWriter.key("Gender").value(voice.getGender());
                }
                if (voice.getLanguage() != null) {
                    jsonWriter.key("Language").value(voice.getLanguage());
                }
                if (voice.getName() != null) {
                    jsonWriter.key("Name").value(voice.getName());
                }
                jsonWriter.endObject();
            }
            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(CHARSET);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
        } catch (Exception e) {
            throw new AmazonClientException("Unable to marshall request to JSON", e);
        }
    }
}
