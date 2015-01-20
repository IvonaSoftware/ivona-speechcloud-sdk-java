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

import java.util.List;

/**
 * Class representing ListVoicesResult
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class ListVoicesResult {

    private List<Voice> voices;

    /**
     * Get the list of voices from result.
     */
    public List<Voice> getVoices() {
        return voices;
    }

    /**
     * Set the list of voices for this result.
     */
    public void setVoices(List<Voice> voices) {
        this.voices = voices;
    }

    /**
     * Set the list of voices for this result.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public ListVoicesResult withVoices(List<Voice> voices) {
        this.voices = voices;
        return this;
    }

    @Override
    public String toString() {
        return "ListVoicesResult [voices=" + voices + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((voices == null) ? 0 : voices.hashCode());
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

        ListVoicesResult other = (ListVoicesResult) obj;
        if (voices == null) {
            if (other.voices != null)
                return false;
        } else if (!voices.equals(other.voices))
            return false;

        return true;
    }
}
