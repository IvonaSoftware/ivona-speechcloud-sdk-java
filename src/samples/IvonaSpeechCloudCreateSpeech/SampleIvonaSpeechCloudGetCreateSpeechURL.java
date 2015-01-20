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
package IvonaSpeechCloudCreateSpeech;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.CreateSpeechRequest;
import com.ivona.services.tts.model.Input;
import com.ivona.services.tts.model.Voice;

/**
 * Class that generates singed URL for IVONA SpeechCloud CreateSpeech operation. This URL can be safely passed to
 * client application to final invocation.
 */
public class SampleIvonaSpeechCloudGetCreateSpeechURL {

    static IvonaSpeechCloudClient speechCloud;

    private static void init() {
        speechCloud = new IvonaSpeechCloudClient(
                new ClasspathPropertiesFileCredentialsProvider("resources/IvonaCredentials.properties"));
        speechCloud.setEndpoint("https://tts.eu-west-1.ivonacloud.com");
    }

    public static void main(String[] args) throws Exception {

        init();

        CreateSpeechRequest createSpeechRequest = new CreateSpeechRequest();
        Input input = new Input();
        Voice voice = new Voice();

        voice.setName("Salli");
        input.setData("This is a sample text to be synthesized.");

        createSpeechRequest.setInput(input);
        createSpeechRequest.setVoice(voice);

        System.out.println("Requested URL: " + speechCloud.getCreateSpeechUrl(createSpeechRequest));
    }
}
