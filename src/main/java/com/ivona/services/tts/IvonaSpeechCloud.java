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
import java.net.URL;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.ivona.services.tts.model.CreateSpeechRequest;
import com.ivona.services.tts.model.CreateSpeechResult;
import com.ivona.services.tts.model.DeleteLexiconRequest;
import com.ivona.services.tts.model.GetLexiconRequest;
import com.ivona.services.tts.model.GetLexiconResult;
import com.ivona.services.tts.model.ListLexiconsResult;
import com.ivona.services.tts.model.ListVoicesRequest;
import com.ivona.services.tts.model.ListVoicesResult;
import com.ivona.services.tts.model.PutLexiconRequest;

/**
 * Ivona Speech Cloud Client interface.
 * <p>
 * This interface provides methods to set up the client and call the Ivona Speech Cloud Service.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public interface IvonaSpeechCloud {

    /**
     * Method that calls Ivona Speech Cloud and synthesizes speech specified in the createSpeechRequest.
     *
     * @param createSpeechRequest
     *          request of the CreateSpeech operation
     * @return CreateSpeechResult
     *          result of the CreateSpeech call
     */
    public CreateSpeechResult createSpeech(CreateSpeechRequest createSpeechRequest)
            throws AmazonServiceException, AmazonClientException;

    /**
     * Method that generates URL out of CreateSpeechRequest.
     * <p>
     * The url can be used to simply obtain the speech result. It sets methodType on
     * the request to GET as this is the only supported value in this method.
     *
     * @param createSpeechRequest
     *          request of the CreateSpeech operation
     * @return
     * @throws UnsupportedEncodingException
     */
    public URL getCreateSpeechUrl(CreateSpeechRequest createSpeechRequest)
            throws UnsupportedEncodingException;

    /**
     * Method that calls Ivona Speech Cloud and returns list of voices.
     * <p>
     * Simple voice filtering is available on server side: {@link ListVoicesRequest#setVoice}
     *
     * @param listVoicesRequest
     *          request of the ListVoices operation
     * @return ListVoicesResult
     *          result of the ListVoices call
     */
    public ListVoicesResult listVoices(ListVoicesRequest listVoicesRequest)
            throws AmazonServiceException, AmazonClientException;

    /**
     * Method that generates URL out of ListVoicesRequest.
     * <p>
     * The URL can be used to simply obtain the list of voices.  It sets methodType on the
     * request to GET as this is the only supported value in this method.
     *
     * @param listVoicesRequest
     *          request of the ListVoices operation
     * @return
     * @throws UnsupportedEncodingException
     */
    public URL getListVoicesUrl(ListVoicesRequest listVoicesRequest)
            throws UnsupportedEncodingException;

    /**
     * Method that gets the response metadata included with a response from AWS associated with the request.
     *
     * @param request
     *          AWS request
     * @return ResponseMetadata
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request);

    /**
     * Set the endpoint of the service for the client.
     * <p>
     * This method is not threadsafe. Endpoints should be configured when the client is created and before any service
     * requests are made. Changing it afterwards creates inevitable race conditions for any service requests in transit.
     *
     * @param endpoint
     * @param serviceName
     * @param regionId
     * @throws IllegalArgumentException
     */
    @Deprecated
    public void setEndpoint(String endpoint, String serviceName, String regionId)
            throws IllegalArgumentException;

    /**
     * Set service endpoint for the client.
     * <p>
     * This method is not threadsafe. Endpoints should be configured when the client is created and before any service
     * requests are made. Changing it afterwards creates inevitable race conditions for any service requests in transit.
     *
     * @param endpoint
     * @throws IllegalArgumentException
     */
    public void setEndpoint(String endpoint) throws IllegalArgumentException;

    /**
     * Set the region of the client.
     * <p>
     * This method is not threadsafe. A region should be configured when the client is created and before any service
     * requests are made. Changing it afterwards creates inevitable race conditions for any service requests in transit.
     *
     * @param region
     * @throws IllegalArgumentException
     */
    public void setRegion(Region region) throws IllegalArgumentException;

    public void shutdown();

    /**
     * Method that calls Ivona Speech Cloud and deletes lexicon specified in the lexiconNameRequest.
     *
     * @param deleteLexiconRequest
     *          request of the DeleteLexicon operation
     * @throws AmazonServiceException
     * @throws AmazonClientException
     */
    public void deleteLexicon(DeleteLexiconRequest deleteLexiconRequest)
            throws AmazonServiceException, AmazonClientException;

    /**
     * Method that calls Ivona Speech Cloud and returns a lexicon.
     *
     * @param getLexiconRequest
     *          request of the GetLexicon operation
     * @return GetLexiconResult
     *          result of the GetLexicon call
     * @throws AmazonServiceException
     * @throws AmazonClientException
     */
    public GetLexiconResult getLexicon(GetLexiconRequest getLexiconRequest)
            throws AmazonServiceException, AmazonClientException;

    /**
     * Method that calls Ivona Speech Cloud and returns list of lexicons.
     *
     * @return ListLexiconsOutput
     *          result of the ListLexicons call
     */
    public ListLexiconsResult listLexicons();

    /**
     * Method that calls Ivona Speech Cloud and creates or updates a lexicon.
     *
     * @param putLexiconRequest
     *          request of the PutLexicon operation
     * @throws AmazonServiceException
     * @throws AmazonClientException
     */
    public void putLexicon(PutLexiconRequest putLexiconRequest)
            throws AmazonServiceException, AmazonClientException;
}
