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
 * Class representing CreateSpeech request
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class CreateSpeechRequest extends AmazonWebServiceRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Input input;
    private OutputFormat outputFormat;
    private Parameters parameters;
    private Voice voice;
    private MethodType methodType;

    /**
     * Get the input text for the request.
     * <p>
     * Input is required.
     */
    public Input getInput() {
        return input;
    }

    /**
     * Set the input text for the request.
     */
    public void setInput(Input input) {
        this.input = input;
    }


    /**
     * Set the input text for the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechRequest withInput(Input input) {
        this.input = input;
        return this;
    }

    /**
     * Get the output format for the request.
     * <p>
     * OutputFormat is optional.
     */
    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    /**
     * Set the output format for the request.
     */
    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    /**
     * Set the output format for the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechRequest withOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
        return this;
    }

    /**
     * Get the parameters for the request.
     * <p>
     * Parameters are optional.
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Set the parameters for the request.
     */
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    /**
     * Set the parameters for the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechRequest withParameters(Parameters parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get which Voice is requested to speak.
     * <p>
     * Voice is optional.
     */
    public Voice getVoice() {
        return voice;
    }

    /**
     * Set Voice.
     */
    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    /**
     * Set Voice.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechRequest withVoice(Voice voice) {
        this.voice = voice;
        return this;
    }

    /**
     * Get what method type to use to connect to the service.
     * <p>
     * MethodType is required.
     */
    public MethodType getMethodType() {
        return methodType;
    }

    /**
     * Set the method type to use to connect to the service.
     */
    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }

    /**
     * Set the method type to use to connect to the service.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public CreateSpeechRequest withMethodType(MethodType methodType) {
        this.methodType = methodType;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CreateSpeechRequest [input=");
        builder.append(input);
        builder.append(", outputFormat=");
        builder.append(outputFormat);
        builder.append(", parameters=");
        builder.append(parameters);
        builder.append(", voice=");
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
        result = prime * result + ((input == null) ? 0 : input.hashCode());
        result = prime * result + ((outputFormat == null) ? 0 : outputFormat.hashCode());
        result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
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

        CreateSpeechRequest other = (CreateSpeechRequest) obj;
        if (input == null) {
            if (other.input != null)
                return false;
        } else if (!input.equals(other.input))
            return false;

        if (outputFormat == null) {
            if (other.outputFormat != null)
                return false;
        } else if (!outputFormat.equals(other.outputFormat))
            return false;

        if (parameters == null) {
            if (other.parameters != null)
                return false;
        } else if (!parameters.equals(other.parameters))
            return false;

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
