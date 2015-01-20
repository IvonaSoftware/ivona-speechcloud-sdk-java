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

/**
 * Class representing input text and type.
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class Input {

    private String data;
    private String type;

    /**
     * Get the data for the input.
     * <p>
     * Data represents the text to be sent and parsed by the service which will be spoken by a voice.
     * The text can be plain text or valid SSML (in which case the type should be set accordingly).
     */
    public String getData() {
        return data;
    }

    /**
     * Set the data for the input.
     * <p>
     * Data represents the data to be sent and parsed by the service which will be read by a voice.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Set the data for the input.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     * Data represents the data to be sent and parsed by the service which will be read by a voice.
     */
    public Input withData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Get what type the data is.
     */
    public String getType() {
        return type;
    }

    /**
     * Set what type the data is.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set what type the data is.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Input withType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Input [data=");
        builder.append(data);
        builder.append(", type=");
        builder.append(type);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Input other = (Input) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
}
