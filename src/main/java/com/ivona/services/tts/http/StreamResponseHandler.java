/*
 * Copyright 2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 *    http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.ivona.services.tts.http;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.transform.Unmarshaller;

/**
 * Response Handler that assumes needsConnectionLeftOpen is always true and
 * that unmarshaller will work directly on HttpResponse object
 */
public class StreamResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {

    private Unmarshaller<T, HttpResponse> responseUnmarshaller;

    public StreamResponseHandler(Unmarshaller<T, HttpResponse> responseUnmarshaller) {
        this.responseUnmarshaller = responseUnmarshaller;
    }

    @Override
    public AmazonWebServiceResponse<T> handle(HttpResponse response) throws Exception {
        AmazonWebServiceResponse<T> awsResponse = new AmazonWebServiceResponse<T>();
        T result = responseUnmarshaller.unmarshall(response);
        awsResponse.setResult(result);
        return awsResponse;
    }

    @Override
    public boolean needsConnectionLeftOpen() {
        return true;
    }
}
