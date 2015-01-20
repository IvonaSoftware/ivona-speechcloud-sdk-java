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

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * Class representing ListVoices request
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class ListVoicesRequest extends AmazonWebServiceRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private Voice voice;
    private MethodType methodType;

    public ListVoicesRequest() {
    }

    public ListVoicesRequest(Voice voice) {
        setVoice(voice);
    }

    /**
     * Get the voice that allows filtering of the returned voice.
     */
    public Voice getVoice() {
        return voice;
    }

    /**
     * Setting voice allows to filter the returned voices.
     * <p>
     * If looking only for "en-US" female voices than the following should be executed:
     * <p>
     * <pre>
     * {
     *     &#064;code
     *     ListVoicesRequest request = new ListVoicesRequest();
     *     Voice voice = new Voice();
     *     voice.setLanguage(&quot;en-US&quot;);
     *     voice.setGender(&quot;Female&quot;);
     *     request.setVoice(voice);
     * }
     * </pre>
     * Voice is optional.
     */
    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    /**
     * Setting voice allows to filter the returned voices.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * Voice is optional.
     */
    public ListVoicesRequest withVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    /**
     * Get what method type is used to connect to the service.
     * <p>
     * MethodType is required.
     */
    public MethodType getMethodType() {
        return methodType;
    }

    /**
     * Set what method type is used to connect to the service.
     */
    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }

    /**
     * Set what method type is used to connect to the service.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public ListVoicesRequest withMethodType(MethodType methodType) {
        this.methodType = methodType;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ListVoicesRequest [voice=");
        builder.append(voice);
        builder.append(", methodType=");
        builder.append(methodType.toString());
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((voice == null) ? 0 : voice.hashCode());
        result = prime * result + ((methodType == null) ? 0 : methodType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ListVoicesRequest other = (ListVoicesRequest) obj;
        if (voice == null) {
            if (other.voice != null)
                return false;
        } else if (!voice.equals(other.voice))
            return false;

        if (methodType == null) {
            if (other.methodType != null)
                return false;
        } else if (!methodType.equals(other.methodType))
            return false;

        return true;
    }
}
