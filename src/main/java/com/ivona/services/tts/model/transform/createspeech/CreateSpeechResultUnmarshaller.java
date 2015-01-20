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
    @Override
    public CreateSpeechResult unmarshall(HttpResponse response) {
        String requestId = response.getHeaders().get("x-amzn-RequestId");
        String ttsRequestId = response.getHeaders().get("x-amzn-IvonaTtsRequestId");
        String contentType = response.getHeaders().get("Content-Type");
        int requestCharacters = Integer.parseInt(response.getHeaders().get("x-amzn-IvonaTtsRequestCharacters"));
        int requestUnits = Integer.parseInt(response.getHeaders().get("x-amzn-IvonaTtsRequestUnits"));

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
