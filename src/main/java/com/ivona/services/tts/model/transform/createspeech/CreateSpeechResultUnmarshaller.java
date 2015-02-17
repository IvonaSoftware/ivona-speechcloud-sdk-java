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

import com.amazonaws.http.HttpResponse;
import com.amazonaws.transform.Unmarshaller;
import com.ivona.services.tts.model.CreateSpeechResult;

/**
 * CreateSpeechResult unmarshaller
 */
public class CreateSpeechResultUnmarshaller implements Unmarshaller<CreateSpeechResult, HttpResponse> {

    protected final static String HEADER_AMZN_REQUEST_ID = "x-amzn-RequestId";
    protected final static String HEADER_IVONA_TTS_REQUEST_ID = "x-amzn-IvonaTtsRequestId";
    protected final static String HEADER_CONTENT_TYPE = "Content-Type";
    protected final static String HEADER_TTS_REQUEST_CHARACTERS = "x-amzn-IvonaTtsRequestCharacters";
    protected final static String HEADER_TTS_REQUEST_UNITS = "x-amzn-IvonaTtsRequestUnits";

    @Override
    public CreateSpeechResult unmarshall(HttpResponse response) {
        String requestId = response.getHeaders().get(HEADER_AMZN_REQUEST_ID);
        String ttsRequestId = response.getHeaders().get(HEADER_IVONA_TTS_REQUEST_ID);
        String contentType = response.getHeaders().get(HEADER_CONTENT_TYPE);
        int requestCharacters = Integer.parseInt(response.getHeaders().get(HEADER_TTS_REQUEST_CHARACTERS));
        int requestUnits = Integer.parseInt(response.getHeaders().get(HEADER_TTS_REQUEST_UNITS));

        CreateSpeechResult createSpeechResult = new CreateSpeechResult();
        createSpeechResult.setRequestId(requestId);
        createSpeechResult.setTtsRequestId(ttsRequestId);
        createSpeechResult.setContentType(contentType);
        createSpeechResult.setTtsRequestCharacters(requestCharacters);
        createSpeechResult.setTtsRequestUnits(requestUnits);
        createSpeechResult.setBody(response.getContent());
        return createSpeechResult;
    }
}
