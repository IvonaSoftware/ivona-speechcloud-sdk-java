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
 * Class representing voice details.
 * Voice can be described with 3 parameters - name, gender and language.
 * <p>
 * Not all the fields have to be set in order to create synthesis.
 * Best matching voice will be selected basing on fields provided.
 * <p>
 * Please check the service documentation for more details.
 *
 * @see <a href="http://developer.ivona.com/en/speechcloud/speechcloud_developer_guide.html">Speech Cloud Developer Guide</a>
 */
public class Voice {

    private String name;
    private String language;
    private String gender;

    /**
     * Get the name of the voice.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the voice.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the name of the voice.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Voice withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the language of the voice.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Set the language of the voice.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Set the language of the voice.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Voice withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Get the gender of the voice.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the gender of the voice.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Set the gender of the voice.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     */
    public Voice withGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Voice [name=");
        builder.append(name);
        builder.append(", language=");
        builder.append(language);
        builder.append(", gender=");
        builder.append(gender);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Voice other = (Voice) obj;
        if (gender == null) {
            if (other.gender != null) {
                return false;
            }
        } else if (!gender.equals(other.gender)) {
            return false;
        }
        if (language == null) {
            if (other.language != null) {
                return false;
            }
        } else if (!language.equals(other.language)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
}
