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
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.ListVoicesRequest;
import com.ivona.services.tts.model.transform.MarshallerHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ListVoicesRequest Marshaller - transforms ListVoicesRequest into GET request.
 */
public class ListVoicesGetRequestMarshaller implements Marshaller<Request<ListVoicesRequest>, ListVoicesRequest>,
        ListVoicesRequestMarshaller {

    protected final static String PARAM_VOICE_NAME = "Voice.Name";
    protected final static String PARAM_VOICE_LANGUAGE = "Voice.Language";
    protected final static String PARAM_VOICE_GENDER = "Voice.Gender";

    protected final static String RESOURCE_PATH = "ListVoices";

    public Request<ListVoicesRequest> marshall(ListVoicesRequest listVoicesRequest) {

        if (listVoicesRequest == null) {
            throw new AmazonClientException("null listVoicesRequest passed to marshall(...)");
        }

        Request<ListVoicesRequest> request = new DefaultRequest<ListVoicesRequest>(listVoicesRequest,
                IvonaSpeechCloudClient.SERVICE_NAME);
        request.setHttpMethod(HttpMethodName.GET);
        request.setResourcePath(RESOURCE_PATH);

        setRequestParameters(request, listVoicesRequest);

        return request;
    }

    protected void setRequestParameters(Request<ListVoicesRequest> request, ListVoicesRequest listVoicesRequest) {
        Map<String, List<String>> parameters = new HashMap<String, List<String>>();

        if (listVoicesRequest.getVoice() != null) {
            MarshallerHelper.putToMapIfNotNull(parameters, PARAM_VOICE_NAME,
                    listVoicesRequest.getVoice().getName());
            MarshallerHelper.putToMapIfNotNull(parameters, PARAM_VOICE_LANGUAGE,
                    listVoicesRequest.getVoice().getLanguage());
            MarshallerHelper.putToMapIfNotNull(parameters, PARAM_VOICE_GENDER,
                    listVoicesRequest.getVoice().getGender());
        }

        request.setParameters(parameters);
    }
}
