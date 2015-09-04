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
 * Class representing Output format of the synthesis.
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class OutputFormat {

    private String codec;
    private Short sampleRate;
    private SpeechMarks speechMarks;

    /**
     * Get the codec used for this synthesis.
     */
    public String getCodec() {
        return codec;
    }

    /**
     * Set the codec used for this format.
     */
    public void setCodec(String codec) {
        this.codec = codec;
    }

    /**
     * Set the codec used for this format.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public OutputFormat withCodec(String codec) {
        this.codec = codec;
        return this;
    }

    /**
     * Get the sample rate of this synthesis.
     */
    public Short getSampleRate() {
        return sampleRate;
    }

    /**
     * Set the sample rate used for this format.
     */
    public void setSampleRate(Short sampleRate) {
        this.sampleRate = sampleRate;
    }

    /**
     * Set the sample rate used for this format.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public OutputFormat withSampleRate(Short sampleRate) {
        this.sampleRate = sampleRate;
        return this;
    }

    /**
     * Get the speech marks for this synthesis.
     */
    public SpeechMarks getSpeechMarks() {
        return speechMarks;
    }

    /**
     * Set the speech marks for this format.
     */
    public void setSpeechMarks(SpeechMarks speechMarks) {
        this.speechMarks = speechMarks;
    }

    /**
     * Set the speech marks for this format.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public OutputFormat withSpeechMarks(SpeechMarks speechMarks) {
        this.speechMarks = speechMarks;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("OutputFormat [codec=");
        builder.append(codec);
        builder.append(", sampleRate=");
        builder.append(sampleRate);
        builder.append(", speechMarks=");
        builder.append(speechMarks);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codec == null) ? 0 : codec.hashCode());
        result = prime * result + ((sampleRate == null) ? 0 : sampleRate.hashCode());
        result = prime * result + ((speechMarks == null) ? 0 : speechMarks.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OutputFormat other = (OutputFormat) obj;
        if (codec == null) {
            if (other.codec != null) {
                return false;
            }
        } else if (!codec.equals(other.codec)) {
            return false;
        }
        if (sampleRate == null) {
            if (other.sampleRate != null) {
                return false;
            }
        } else if (!sampleRate.equals(other.sampleRate)) {
            return false;
        }
        if (speechMarks == null) {
            if (other.speechMarks != null) {
                return false;
            }
        } else if (!speechMarks.equals(other.speechMarks)) {
            return false;
        }
        return true;
    }
}
