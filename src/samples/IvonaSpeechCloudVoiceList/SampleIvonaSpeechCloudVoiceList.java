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
package IvonaSpeechCloudVoiceList;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.ListVoicesRequest;
import com.ivona.services.tts.model.ListVoicesResult;
import com.ivona.services.tts.model.Voice;

/**
 * Class with sample voice list usage.
 * Shows how to display all voices and how to filter voice list.
 */
public class SampleIvonaSpeechCloudVoiceList {

    static IvonaSpeechCloudClient speechCloud;

    private static void init() {
        speechCloud = new IvonaSpeechCloudClient(
                new ClasspathPropertiesFileCredentialsProvider("resources/IvonaCredentials.properties"));
        speechCloud.setEndpoint("https://tts.eu-west-1.ivonacloud.com");
    }

    public static void main(String[] args) {
        init();
        ListVoicesRequest allVoicesRequest = new ListVoicesRequest();
        ListVoicesResult allVoicesResult = speechCloud.listVoices(allVoicesRequest);
        System.out.println("All voices: " + allVoicesResult);

        ListVoicesRequest enUsVoicesRequest = new ListVoicesRequest();
        Voice voice = new Voice();
        voice.setLanguage("en-US");
        enUsVoicesRequest.setVoice(voice);
        ListVoicesResult enUsVoiceResult = speechCloud.listVoices(enUsVoicesRequest);
        System.out.println("en-US voices: " + enUsVoiceResult);
    }

}
