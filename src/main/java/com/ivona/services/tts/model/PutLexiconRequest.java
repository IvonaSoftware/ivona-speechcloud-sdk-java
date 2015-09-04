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

import com.amazonaws.AmazonWebServiceRequest;

/**
 * Class representing PutLexicon request
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class PutLexiconRequest extends AmazonWebServiceRequest {

    private Lexicon lexicon;

    /**
     * Get the lexicon for the request.
     */
    public Lexicon getLexicon() {
        return lexicon;
    }

    /**
     * Set the lexicon for the request.
     */
    public void setLexicon(Lexicon lexicon) {
        this.lexicon = lexicon;
    }

    /**
     * Set the lexicon for the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public PutLexiconRequest withLexicon(Lexicon lexicon) {
        this.lexicon = lexicon;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PutLexiconRequest [lexicon=");
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

        PutLexiconRequest other = (PutLexiconRequest) obj;
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
