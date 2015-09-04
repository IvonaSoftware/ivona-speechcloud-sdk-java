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
package IvonaSpeechCloudLexicons;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.DeleteLexiconRequest;

/**
 * Class with sample delete lexicon usage.
 * Shows how to delete the lexicon.
 */
public class SampleIvonaSpeechCloudDeleteLexicon {

    static IvonaSpeechCloudClient speechCloud;

    private final static String LEXICON_NAME = "LexiconToDelete";

    private static void init() {
        speechCloud = new IvonaSpeechCloudClient(
                new ClasspathPropertiesFileCredentialsProvider("resources/IvonaCredentials.properties"));
        speechCloud.setEndpoint("https://tts.eu-west-1.ivonacloud.com");
    }

    public static void main(String[] args) {
        init();
        DeleteLexiconRequest deleteLexiconRequest = new DeleteLexiconRequest().withLexiconName(LEXICON_NAME);
        speechCloud.deleteLexicon(deleteLexiconRequest);
    }

}
