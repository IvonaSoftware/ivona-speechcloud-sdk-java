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

import java.io.Serializable;

/**
 * Class representing DeleteLexiconRequest request
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class DeleteLexiconRequest extends AmazonWebServiceRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String lexiconName;

    /**
     * Get the lexicon name for the request.
     */
    public String getLexiconName() {
        return lexiconName;
    }

    /**
     * Set the lexicon name for the request.
     */
    public void setLexiconName(String lexiconName) {
        this.lexiconName = lexiconName;
    }

    /**
     * Set the lexicon name for the request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public DeleteLexiconRequest withLexiconName(String lexiconName) {
        this.lexiconName = lexiconName;
        return this;
    }

    @Override
    public String toString() {
        return "DeleteLexiconRequest [lexiconName=" + lexiconName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lexiconName == null) ? 0 : lexiconName.hashCode());
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

        DeleteLexiconRequest other = (DeleteLexiconRequest) obj;
        if (lexiconName == null) {
            if (other.lexiconName != null) {
                return false;
            }
        } else if (!lexiconName.equals(other.lexiconName)) {
            return false;
        }

        return true;
    }
}
