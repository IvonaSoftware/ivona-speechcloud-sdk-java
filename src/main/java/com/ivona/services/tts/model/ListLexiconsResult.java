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
 * Class representing ListLexicons result
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class ListLexiconsResult {
    private List<String> lexiconNames;

    /**
     * Get the list of lexicon names from result.
     */
    public List<String> getLexiconNames() {
        return lexiconNames;
    }

    /**
     * Set the list of lexicon names for this result.
     */
    public void setLexiconNames(List<String> lexiconNames) {
        this.lexiconNames = lexiconNames;
    }

    /**
     * Set the list of lexicon names for this result.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public ListLexiconsResult withLexiconNames(List<String> lexiconNames) {
        this.lexiconNames = lexiconNames;
        return this;
    }

    @Override
    public String toString() {
        return "ListLexiconsResult [lexiconNames=" + lexiconNames + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lexiconNames == null) ? 0 : lexiconNames.hashCode());
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

        ListLexiconsResult other = (ListLexiconsResult) obj;
        if (lexiconNames == null) {
            if (other.lexiconNames != null) {
                return false;
            }
        } else if (!lexiconNames.equals(other.lexiconNames)) {
            return false;
        }

        return true;
    }
}
