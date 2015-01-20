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
package com.ivona.services.tts;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.ivona.services.tts.http.StreamResponseHandler;
import com.ivona.services.tts.http.auth.AWS4HttpGetAwareSigner;
import com.ivona.services.tts.model.CreateSpeechRequest;
import com.ivona.services.tts.model.CreateSpeechResult;
import com.ivona.services.tts.model.ListVoicesRequest;
import com.ivona.services.tts.model.ListVoicesResult;
import com.ivona.services.tts.model.MethodType;
import com.ivona.services.tts.model.transform.createspeech.CreateSpeechRequestMarshallerFactory;
import com.ivona.services.tts.model.transform.createspeech.CreateSpeechResultUnmarshaller;
import com.ivona.services.tts.model.transform.listvoices.ListVoicesRequestMarshallerFactory;
import com.ivona.services.tts.model.transform.listvoices.ListVoicesResultJsonUnmarshaller;

/**
 * Ivona Speech Cloud Client Implementation
 */
public class IvonaSpeechCloudClient extends AmazonWebServiceClient implements IvonaSpeechCloud {

    public final static String SERVICE_NAME = "tts";

    private final static String SERVICE_PROTOCOL = "https://";
    private final static String SERVICE_DOMAIN = "ivonacloud.com";

    private final static Pattern REGION_PATTERN = Pattern.compile(SERVICE_PROTOCOL + SERVICE_NAME +
            "\\.([^.]*)\\." + SERVICE_DOMAIN.replace(".", "\\."));

    private AWSCredentialsProvider awsCredentialsProvider;
    protected AWS4Signer signer;
    protected List<JsonErrorUnmarshaller> exceptionUnmarshallers;

    /**
     * Default Constructor.
     */
    public IvonaSpeechCloudClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructor which allows custom ClientConfiguration to be passed.
     *
     * @param clientConfiguration
     */
    public IvonaSpeechCloudClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructor which allows custom AWSCredentials to be passed.
     *
     * @param awsCredentials
     */
    public IvonaSpeechCloudClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructor which allows custom ClientConfiguration and AWSCredentials to be passed.
     *
     * @param awsCredentials
     * @param clientConfiguration
     */
    public IvonaSpeechCloudClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructor which allows custom AWSCredentialsProvider to be passed.
     *
     * @param awsCredentialsProvider
     */
    public IvonaSpeechCloudClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructor which allows custom AWSCredentialsProvider and ClientConfiguration to be passed.
     *
     * @param awsCredentialsProvider
     * @param clientConfiguration
     */
    public IvonaSpeechCloudClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    @Override
    public CreateSpeechResult createSpeech(CreateSpeechRequest createSpeechRequest) throws AmazonServiceException,
            AmazonClientException {

        ExecutionContext executionContext = createExecutionContext(createSpeechRequest);
        Request<CreateSpeechRequest> request = CreateSpeechRequestMarshallerFactory.getMarshaller(
                createSpeechRequest.getMethodType()).marshall(createSpeechRequest);
        CreateSpeechResultUnmarshaller unmarshaller = new CreateSpeechResultUnmarshaller();
        StreamResponseHandler<CreateSpeechResult> responseHandler = new StreamResponseHandler<CreateSpeechResult>(unmarshaller);

        Response<CreateSpeechResult> response = invoke(request, responseHandler, executionContext);
        return response.getAwsResponse();
    }

    @Override
    public URL getCreateSpeechUrl(CreateSpeechRequest createSpeechRequest) throws UnsupportedEncodingException {
        createSpeechRequest.setMethodType(MethodType.GET);
        Request<CreateSpeechRequest> request = CreateSpeechRequestMarshallerFactory.getMarshaller(
                createSpeechRequest.getMethodType()).marshall(createSpeechRequest);
        return translateRequestToURL(prepareRequestForGetUrl(request));
    }

    @Override
    public ListVoicesResult listVoices(ListVoicesRequest listVoicesRequest) throws AmazonServiceException,
            AmazonClientException {

        ExecutionContext executionContext = createExecutionContext(listVoicesRequest);
        Request<ListVoicesRequest> request = ListVoicesRequestMarshallerFactory.getMarshaller(
                listVoicesRequest.getMethodType()).marshall(listVoicesRequest);
        Unmarshaller<ListVoicesResult, JsonUnmarshallerContext> unmarshaller = new ListVoicesResultJsonUnmarshaller();
        JsonResponseHandler<ListVoicesResult> responseHandler = new JsonResponseHandler<ListVoicesResult>(unmarshaller);

        Response<ListVoicesResult> response = invoke(request, responseHandler, executionContext);
        return response.getAwsResponse();
    }

    @Override
    public URL getListVoicesUrl(ListVoicesRequest listVoicesRequest) throws UnsupportedEncodingException {
        listVoicesRequest.setMethodType(MethodType.GET);
        Request<ListVoicesRequest> request = ListVoicesRequestMarshallerFactory.getMarshaller(
                listVoicesRequest.getMethodType()).marshall(listVoicesRequest);
        return translateRequestToURL(prepareRequestForGetUrl(request));
    }

    @Override
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    @Override
    public Signer getSignerByURI(URI uri) {
        return this.signer;
    }

    @Deprecated
    @Override
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {

        try {
            this.endpoint = new URI(endpoint);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }

        signer.setServiceName(serviceName);
        signer.setRegionName(regionId);
    }

    @Override
    public void setEndpoint(String endpoint) throws IllegalArgumentException {

        if (!endpoint.contains("://")) {
            endpoint = SERVICE_PROTOCOL + endpoint;
        }

        if (endpoint.endsWith("/")) {
            endpoint = endpoint.substring(0, endpoint.length() - 1);
        }

        Matcher regionMatcher = REGION_PATTERN.matcher(endpoint);

        if (regionMatcher.matches()) {
            signer.setRegionName(regionMatcher.group(1));
        } else {
            throw new IllegalArgumentException("Unsupported endpoint.");
        }

        try {
            this.endpoint = new URI(endpoint);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void setRegion(Region region) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    private void init() {
        exceptionUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();
        exceptionUnmarshallers.add(new JsonErrorUnmarshaller());

        signer = new AWS4HttpGetAwareSigner();
        signer.setServiceName(SERVICE_NAME);

        setServiceNameIntern(SERVICE_NAME);

        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com.ivona.services/tts/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain("/com.ivona.services/tts/request.handler2s"));
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(
            Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {

        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(exceptionUnmarshallers);

        Response<X> result = client.execute(
                prepareRequest(request, executionContext),
                responseHandler,
                errorResponseHandler,
                executionContext);

        return result;
    }

    private <Y> Request<Y> prepareRequestForGetUrl(Request<Y> request) {
        return prepareRequest(request, null, true);
    }

    private <Y> Request<Y> prepareRequest(Request<Y> request, ExecutionContext executionContext) {
        return prepareRequest(request, executionContext, false);
    }

    private <Y> Request<Y> prepareRequest(Request<Y> request, ExecutionContext executionContext, boolean signRequest) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();

        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }
        if (signRequest) {
            signer.sign(request, credentials);
        } else {
            executionContext.setSigner(signer);
            executionContext.setCredentials(credentials);
        }
        return request;
    }

    private String translateMapToQueryString(Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder buffer = new StringBuilder();

        boolean addAmp = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (addAmp) {
                buffer.append("&");
            }

            if (entry.getKey() != null && entry.getValue() != null) {
                buffer.append(urlEncode(entry.getKey())).append("=").append(urlEncode(entry.getValue()));
                addAmp = true;
            }
        }

        return buffer.toString();
    }

    private URL translateRequestToURL(final Request<?> request) throws UnsupportedEncodingException {
        StringBuilder buffer = new StringBuilder();
        buffer.append(request.getEndpoint().toString()).append("/").append(request.getResourcePath()).append("?");
        buffer.append(translateMapToQueryString(request.getParameters()));

        URL url = null;
        try {
            url = new URL(buffer.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error while translating request to URL", e);
        }
        return url;
    }

    private String urlEncode(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8");
    }
}
