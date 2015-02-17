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

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.transform.Marshaller;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.CreateSpeechRequest;
import com.ivona.services.tts.model.transform.MarshallerHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * CreateSpeechRequest Marshaller - transforms CreateSpeechRequest class into GET request
 */
public class CreateSpeechGetRequestMarshaller implements Marshaller<Request<CreateSpeechRequest>, CreateSpeechRequest>,
        CreateSpeechRequestMarshaller {

    protected final static String RESOURCE_PATH = "CreateSpeech";

    protected final static String GET_PARAM_INPUT_DATA = "Input.Data";
    protected final static String GET_PARAM_INPUT_TYPE = "Input.Type";
    protected final static String GET_PARAM_OUTPUT_FORMAT_CODEC = "OutputFormat.Codec";
    protected final static String GET_PARAM_OUTPUT_FORMAT_SAMPLE_RATE = "OutputFormat.SampleRate";
    protected final static String GET_PARAM_PARAMETERS_RATE = "Parameters.Rate";
    protected final static String GET_PARAM_PARAMETERS_VOLUME = "Parameters.Volume";
    protected final static String GET_PARAM_PARAMETERS_PARAGRAPH_BREAK = "Parameters.ParagraphBreak";
    protected final static String GET_PARAM_PARAMETERS_SENTENCE_BREAK = "Parameters.SentenceBreak";
    protected final static String GET_PARAM_VOICE_NAME = "Voice.Name";
    protected final static String GET_PARAM_VOICE_LANGUAGE = "Voice.Language";
    protected final static String GET_PARAM_VOICE_GENDER = "Voice.Gender";

    public Request<CreateSpeechRequest> marshall(CreateSpeechRequest createSpeechRequest) {
        if (createSpeechRequest == null) {
            throw new AmazonClientException("null createSpeechRequest passed to marshall(...)");
        }

        Request<CreateSpeechRequest> request = new DefaultRequest<CreateSpeechRequest>(createSpeechRequest,
                IvonaSpeechCloudClient.SERVICE_NAME);
        setRequestParameters(request, createSpeechRequest);
        request.setHttpMethod(HttpMethodName.GET);
        request.setResourcePath(RESOURCE_PATH);

        return request;
    }

    private void setRequestParameters(Request<CreateSpeechRequest> request, CreateSpeechRequest createSpeechRequest) {
        Map<String, String> parameters = new HashMap<String, String>();

        MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_INPUT_DATA, createSpeechRequest.getInput().getData());
        MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_INPUT_TYPE, createSpeechRequest.getInput().getType());

        if (createSpeechRequest.getOutputFormat() != null) {
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_OUTPUT_FORMAT_CODEC, createSpeechRequest.getOutputFormat().getCodec());
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_OUTPUT_FORMAT_SAMPLE_RATE, createSpeechRequest.getOutputFormat().getSampleRate());
        }

        if (createSpeechRequest.getParameters() != null) {
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_PARAMETERS_RATE, createSpeechRequest.getParameters().getRate());
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_PARAMETERS_VOLUME, createSpeechRequest.getParameters().getVolume());
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_PARAMETERS_PARAGRAPH_BREAK, createSpeechRequest.getParameters().getParagraphBreak());
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_PARAMETERS_SENTENCE_BREAK, createSpeechRequest.getParameters().getSentenceBreak());
        }

        if (createSpeechRequest.getVoice() != null) {
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_VOICE_NAME, createSpeechRequest.getVoice().getName());
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_VOICE_LANGUAGE, createSpeechRequest.getVoice().getLanguage());
            MarshallerHelper.putToMapIfNotNull(parameters, GET_PARAM_VOICE_GENDER, createSpeechRequest.getVoice().getGender());
        }

        request.setParameters(parameters);
    }
}
