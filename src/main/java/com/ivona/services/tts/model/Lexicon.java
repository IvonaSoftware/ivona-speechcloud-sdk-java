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
 * Class representing a lexicon.
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class Lexicon {
    private String name;
    private String contents;

    /**
     * Get the lexicon name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the lexicon name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the lexicon name.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Lexicon withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the PLS contents of this lexicon.
     */
    public String getContents() {
        return this.contents;
    }

    /**
     * Set the PLS contents of this lexicon.
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Set the PLS contents of this lexicon.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Lexicon withContents(String contents) {
        this.contents = contents;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Lexicon [name=");
        builder.append(name);
        builder.append(", contents=");
        builder.append(contents);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((contents == null) ? 0 : contents.hashCode());
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

        Lexicon other = (Lexicon) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (contents == null) {
            if (other.contents != null) {
                return false;
            }
        } else if (!contents.equals(other.contents)) {
            return false;
        }

        return true;
    }

}
