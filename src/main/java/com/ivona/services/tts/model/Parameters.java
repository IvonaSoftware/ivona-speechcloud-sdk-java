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
 * Class representing additional synthesis parameters.
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class Parameters {

    private String rate;
    private String volume;
    private Short sentenceBreak;
    private Short paragraphBreak;

    /**
     * Get the sample rate parameter.
     */
    public String getRate() {
        return rate;
    }

    /**
     * Set the sample rate parameter.
     */
    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Set the sample rate parameter.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Parameters withRate(String rate) {
        this.rate = rate;
        return this;
    }

    /**
     * Get the volume parameter.
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Set the volume parameter.
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * Set the volume parameter.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Parameters withVolume(String volume) {
        this.volume = volume;
        return this;
    }

    /**
     * Get the sentence break parameter.
     */
    public Short getSentenceBreak() {
        return sentenceBreak;
    }

    /**
     * Set the sentence break parameter.
     */
    public void setSentenceBreak(Short sentenceBreak) {
        this.sentenceBreak = sentenceBreak;
    }

    /**
     * Set the sentence break parameter.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Parameters withSentenceBreak(Short sentenceBreak) {
        this.sentenceBreak = sentenceBreak;
        return this;
    }

    /**
     * Get the paragraph break parameter.
     */
    public Short getParagraphBreak() {
        return paragraphBreak;
    }

    /**
     * Set the paragraph break parameter.
     */
    public void setParagraphBreak(Short paragraphBreak) {
        this.paragraphBreak = paragraphBreak;
    }

    /**
     * Set the paragraph break parameter.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Parameters withParagraphBreak(Short paragraphBreak) {
        this.paragraphBreak = paragraphBreak;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Parameters [rate=");
        builder.append(rate);
        builder.append(", volume=");
        builder.append(volume);
        builder.append(", sentenceBreak=");
        builder.append(sentenceBreak);
        builder.append(", paragraphBreak=");
        builder.append(paragraphBreak);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((paragraphBreak == null) ? 0 : paragraphBreak.hashCode());
        result = prime * result + ((rate == null) ? 0 : rate.hashCode());
        result = prime * result + ((sentenceBreak == null) ? 0 : sentenceBreak.hashCode());
        result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
        Parameters other = (Parameters) obj;
        if (paragraphBreak == null) {
            if (other.paragraphBreak != null) {
                return false;
            }
        } else if (!paragraphBreak.equals(other.paragraphBreak)) {
            return false;
        }
        if (rate == null) {
            if (other.rate != null) {
                return false;
            }
        } else if (!rate.equals(other.rate)) {
            return false;
        }
        if (sentenceBreak == null) {
            if (other.sentenceBreak != null) {
                return false;
            }
        } else if (!sentenceBreak.equals(other.sentenceBreak)) {
            return false;
        }
        if (volume == null) {
            if (other.volume != null) {
                return false;
            }
        } else if (!volume.equals(other.volume)) {
            return false;
        }
        return true;
    }
}
