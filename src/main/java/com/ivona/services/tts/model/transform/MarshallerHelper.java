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
package com.ivona.services.tts.model.transform;

import java.util.Map;

/**
 * The class which contains simple methods used by CreateSpeech and ListVoices marshallers.
 */
public class MarshallerHelper {
    public static void putToMapIfNotNull(Map<String, String> map, final String key, final String value) {
        if (value != null) {
            map.put(key, value);
        }
    }

    public static void putToMapIfNotNull(Map<String, String> map, final String key, final Short value) {
        putToMapIfNotNull(map, key, value.toString());
    }
}
