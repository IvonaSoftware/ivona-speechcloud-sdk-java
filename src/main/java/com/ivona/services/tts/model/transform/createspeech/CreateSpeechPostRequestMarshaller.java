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
package com.ivona.services.tts.model.transform.createspeech;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONWriter;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.CreateSpeechRequest;
import com.ivona.services.tts.model.Input;
import com.ivona.services.tts.model.OutputFormat;
import com.ivona.services.tts.model.Parameters;
import com.ivona.services.tts.model.SpeechMarks;
import com.ivona.services.tts.model.Voice;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * CreateSpeechRequest Marshaller - transforms CreateSpeechRequest class into Json POST request
 */
public class CreateSpeechPostRequestMarshaller implements Marshaller<Request<CreateSpeechRequest>, CreateSpeechRequest>,
        CreateSpeechRequestMarshaller {

    protected final static String RESOURCE_PATH = "CreateSpeech";

    protected final static String JSON_KEY_INPUT = "Input";
    protected final static String JSON_KEY_INPUT_DATA = "Data";
    protected final static String JSON_KEY_INPUT_TYPE = "Type";
    protected final static String JSON_KEY_OUTPUT_FORMAT = "OutputFormat";
    protected final static String JSON_KEY_OUTPUT_FORMAT_CODEC = "Codec";
    protected final static String JSON_KEY_OUTPUT_FORMAT_SAMPLE_RATE = "SampleRate";
    protected final static String JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS = "SpeechMarks";
    protected final static String JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_SENTENCE = "Sentence";
    protected final static String JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_SSML = "Ssml";
    protected final static String JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_VISEME = "Viseme";
    protected final static String JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_WORD = "Word";
    protected final static String JSON_KEY_PARAMETERS = "Parameters";
    protected final static String JSON_KEY_LEXICONS = "LexiconNames";
    protected final static String JSON_KEY_PARAMETERS_RATE = "Rate";
    protected final static String JSON_KEY_PARAMETERS_VOLUME = "Volume";
    protected final static String JSON_KEY_PARAMETERS_PARAGRAPH_BREAK = "ParagraphBreak";
    protected final static String JSON_KEY_PARAMETERS_SENTENCE_BREAK = "SentenceBreak";
    protected final static String JSON_KEY_VOICE = "Voice";
    protected final static String JSON_KEY_VOICE_NAME = "Name";
    protected final static String JSON_KEY_VOICE_LANGUAGE = "Language";
    protected final static String JSON_KEY_VOICE_GENDER = "Gender";

    public Request<CreateSpeechRequest> marshall(CreateSpeechRequest createSpeechRequest) {

        if (createSpeechRequest == null) {
            throw new AmazonClientException("null createSpeechRequest passed to marshall(...)");
        }

        Request<CreateSpeechRequest> request = new DefaultRequest<CreateSpeechRequest>(createSpeechRequest,
                IvonaSpeechCloudClient.SERVICE_NAME);
        request.setHttpMethod(HttpMethodName.POST);
        setRequestPayload(request, createSpeechRequest);
        request.setResourcePath(RESOURCE_PATH);

        return request;
    }

    private void setRequestPayload(Request<CreateSpeechRequest> request, CreateSpeechRequest createSpeechRequest) {
        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (createSpeechRequest.getInput() != null) {
                Input input = createSpeechRequest.getInput();

                jsonWriter.key(JSON_KEY_INPUT);
                jsonWriter.object();
                if (input.getData() != null) {
                    jsonWriter.key(JSON_KEY_INPUT_DATA).value(input.getData());
                }
                if (input.getType() != null) {
                    jsonWriter.key(JSON_KEY_INPUT_TYPE).value(input.getType());
                }
                jsonWriter.endObject();
            }

            if (createSpeechRequest.getOutputFormat() != null) {
                OutputFormat outputFormat = createSpeechRequest.getOutputFormat();

                jsonWriter.key(JSON_KEY_OUTPUT_FORMAT);
                jsonWriter.object();
                if (outputFormat.getCodec() != null) {
                    jsonWriter.key(JSON_KEY_OUTPUT_FORMAT_CODEC).value(outputFormat.getCodec());
                }
                if (outputFormat.getSampleRate() != null && outputFormat.getSampleRate() > 0) {
                    jsonWriter.key(JSON_KEY_OUTPUT_FORMAT_SAMPLE_RATE).value((long) outputFormat.getSampleRate());
                }
                if (outputFormat.getSpeechMarks() != null) {
                    jsonWriter.key(JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS);
                    jsonWriter.object();
                    SpeechMarks speechMarks = outputFormat.getSpeechMarks();
                    if (speechMarks != null) {
                        if (speechMarks.isSentence()) {
                            jsonWriter.key(JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_SENTENCE).value(true);
                        }
                        if (speechMarks.isSsml()) {
                            jsonWriter.key(JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_SSML).value(true);
                        }
                        if (speechMarks.isViseme()) {
                            jsonWriter.key(JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_VISEME).value(true);
                        }
                        if (speechMarks.isWord()) {
                            jsonWriter.key(JSON_KEY_OUTPUT_FORMAT_SPEECHMARKS_WORD).value(true);
                        }
                    }
                    jsonWriter.endObject();
                }
                jsonWriter.endObject();
            }

            if (createSpeechRequest.getParameters() != null) {
                Parameters parameters = createSpeechRequest.getParameters();

                jsonWriter.key(JSON_KEY_PARAMETERS);
                jsonWriter.object();
                if (parameters.getRate() != null) {
                    jsonWriter.key(JSON_KEY_PARAMETERS_RATE).value(parameters.getRate());
                }
                if (parameters.getVolume() != null) {
                    jsonWriter.key(JSON_KEY_PARAMETERS_VOLUME).value(parameters.getVolume());
                }
                if (parameters.getSentenceBreak() != null) {
                    jsonWriter.key(JSON_KEY_PARAMETERS_SENTENCE_BREAK).value((long) parameters.getSentenceBreak());
                }
                if (parameters.getParagraphBreak() != null) {
                    jsonWriter.key(JSON_KEY_PARAMETERS_PARAGRAPH_BREAK).value((long) parameters.getParagraphBreak());
                }
                jsonWriter.endObject();
            }

            if (createSpeechRequest.getLexiconNames() != null) {
                List<String> names = createSpeechRequest.getLexiconNames();
                jsonWriter.key(JSON_KEY_LEXICONS).value(names);
            }

            if (createSpeechRequest.getVoice() != null) {
                Voice voice = createSpeechRequest.getVoice();

                jsonWriter.key(JSON_KEY_VOICE);
                jsonWriter.object();
                if (voice.getGender() != null) {
                    jsonWriter.key(JSON_KEY_VOICE_GENDER).value(voice.getGender());
                }
                if (voice.getLanguage() != null) {
                    jsonWriter.key(JSON_KEY_VOICE_LANGUAGE).value(voice.getLanguage());
                }
                if (voice.getName() != null) {
                    jsonWriter.key(JSON_KEY_VOICE_NAME).value(voice.getName());
                }
                jsonWriter.endObject();
            }
            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF_8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length", Integer.toString(content.length));
        } catch (JSONException e) {
            throw new AmazonClientException("Unable to marshall request to JSON", e);
        } catch (UnsupportedEncodingException e) {
            throw new AmazonClientException("Unable to marshall request to JSON", e);
        }
    }
}
