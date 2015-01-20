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
package com.ivona.services.tts.model;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Class representing CreateSpeech result
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class CreateSpeechResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String requestId;
    private String contentType;
    private int ttsRequestCharacters;
    private int ttsRequestUnits;
    private String ttsRequestId;
    private InputStream body;

    /**
     * Get the ID of the request.
     * <p>
     * The ID of the request can be set by the user and is used for tracking purposes.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Set the ID of the request.
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Set the ID of the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechResult withRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Get the content type of the request.
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Set the content type of the request.
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Set the content type of the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechResult withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get the audio resulting from the CreateSpeech call.
     */
    public InputStream getBody() {
        return body;
    }

    /**
     * Set the audio stream resulting from the CreateSpeech call.
     */
    public void setBody(InputStream body) {
        this.body = body;
    }

    /**
     * Set the audio stream resulting from the CreateSpeech call.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechResult withBody(InputStream body) {
        this.body = body;
        return this;
    }

    /**
     * Get the number of characters from the request.
     */
    public int getTtsRequestCharacters() {
        return ttsRequestCharacters;
    }

    /**
     * Set the number of characters from the request.
     */
    public void setTtsRequestCharacters(int ttsRequestCharacters) {
        this.ttsRequestCharacters = ttsRequestCharacters;
    }

    /**
     * Set the number of characters from the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechResult withTtsRequestCharacters(int ttsRequestCharacters) {
        this.ttsRequestCharacters = ttsRequestCharacters;
        return this;
    }

    /**
     * Get the number of units from the request.
     */
    public int getTtsRequestUnits() {
        return ttsRequestUnits;
    }

    /**
     * Set the number of units from the request.
     */
    public void setTtsRequestUnits(int ttsRequestUnits) {
        this.ttsRequestUnits = ttsRequestUnits;
    }

    /**
     * Set the number of units from the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechResult withTtsRequestUnits(int ttsRequestUnits) {
        this.ttsRequestUnits = ttsRequestUnits;
        return this;
    }

    /**
     * Get the ID for the TTS request.
     * <p>
     * The TTS request uniquely identifies the request and is set by the service.
     */
    public String getTtsRequestId() {
        return ttsRequestId;
    }

    /**
     * Set the ID for the TTS request.
     */
    public void setTtsRequestId(String ttsRequestId) {
        this.ttsRequestId = ttsRequestId;
    }

    /**
     * Set the ID for the TTS request.
     * <p>
     * The TTS request uniquely identifies the request and is set by the service.
     */
    public CreateSpeechResult withTtsRequestId(String ttsRequestId) {
        this.ttsRequestId = ttsRequestId;
        return this;
    }
}
