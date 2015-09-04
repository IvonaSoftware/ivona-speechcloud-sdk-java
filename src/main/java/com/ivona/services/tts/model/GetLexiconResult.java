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
 * Class representing GetLexicon result
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class GetLexiconResult {

    private Lexicon lexicon;

    /**
     * Get the lexicon from result.
     */
    public Lexicon getLexicon() {
        return lexicon;
    }

    /**
     * Set the lexicon for this result.
     */
    public void setLexicon(Lexicon lexicon) {
        this.lexicon = lexicon;
    }

    /**
     * Set the lexicon for this result.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public GetLexiconResult withLexicon(Lexicon lexicon) {
        this.lexicon = lexicon;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GetLexiconResult [lexicon=");
        builder.append(lexicon);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lexicon == null) ? 0 : lexicon.hashCode());
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

        GetLexiconResult other = (GetLexiconResult) obj;
        if (lexicon == null) {
            if (other.lexicon != null) {
                return false;
            }
        } else if (!lexicon.equals(other.lexicon)) {
            return false;
        }

        return true;
    }
}
