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
 * Class representing the speech marks requested for a synthesis.
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class SpeechMarks {
    private boolean sentence;
    private boolean ssml;
    private boolean viseme;
    private boolean word;

    /**
     * Returns true if sentence speech marks are .
     */
    public boolean isSentence() {
        return sentence;
    }

    /**
     * Enable or disable sentence speech marks.
     */
    public void setSentence(boolean sentence) {
        this.sentence = sentence;
    }

    /**
     * Enable or disable sentence speech marks.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public SpeechMarks withSentence(boolean sentence) {
        this.sentence = sentence;
        return this;
    }

    /**
     * Returns true if SSML speech marks are .
     */
    public boolean isSsml() {
        return ssml;
    }

    /**
     * Enable or disable SSML speech marks.
     */
    public void setSsml(boolean ssml) {
        this.ssml = ssml;
    }

    /**
     * Enable or disable SSML speech marks.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public SpeechMarks withSsml(boolean ssml) {
        this.ssml = ssml;
        return this;
    }

    /**
     * Returns true if viseme speech marks are .
     */
    public boolean isViseme() {
        return viseme;
    }

    /**
     * Enable or disable viseme speech marks.
     */
    public void setViseme(boolean viseme) {
        this.viseme = viseme;
    }

    /**
     * Enable or disable viseme speech marks.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public SpeechMarks withViseme(boolean viseme) {
        this.viseme = viseme;
        return this;
    }

    /**
     * Returns true if word speech marks are .
     */
    public boolean isWord() {
        return word;
    }

    /**
     * Enable or disable word speech marks.
     */
    public void setWord(boolean word) {
        this.word = word;
    }

    /**
     * Enable or disable word speech marks.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public SpeechMarks withWord(boolean word) {
        this.word = word;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SpeechMarks [sentence=");
        builder.append(sentence);
        builder.append(", ssml=");
        builder.append(ssml);
        builder.append(", viseme=");
        builder.append(viseme);
        builder.append(", word=");
        builder.append(word);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (sentence ? 1 : 0);
        result = prime * result + (ssml ? 1 : 0);
        result = prime * result + (viseme ? 1 : 0);
        result = prime * result + (word ? 1 : 0);
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
        SpeechMarks other = (SpeechMarks) obj;
        if (sentence != other.sentence) {
            return false;
        }
        if (ssml != other.ssml) {
            return false;
        }
        if (viseme != other.viseme) {
            return false;
        }
        if (word != other.word) {
            return false;
        }
        return true;
    }
}
