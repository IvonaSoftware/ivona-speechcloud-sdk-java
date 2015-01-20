/*
 * Copyright 2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 *    http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.ivona.services.tts.http.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.BinaryUtils;

/**
 * Modified version of AWS4Singer that supports pure HTTP GET without additional HTTP headers.
 */
public class AWS4HttpGetAwareSigner extends AWS4Signer {

    @Override
    public void sign(Request<?> request, AWSCredentials credentials) throws AmazonClientException {
        // anonymous credentials, don't sign
        if (credentials instanceof AnonymousAWSCredentials) {
            return;
        }

        AWSCredentials sanitizedCredentials = sanitizeCredentials(credentials);
        if (sanitizedCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) sanitizedCredentials);
        }

        addHostHeader(request);

        long dateMilli = getDateFromRequest(request);

        final String dateStamp = getDateStamp(dateMilli);
        String scope = getScope(request, dateStamp);

        String contentSha256 = calculateContentHash(request);

        final String timeStamp = getTimeStamp(dateMilli);

        String signingCredentials = sanitizedCredentials.getAWSAccessKeyId() + "/" + scope;

        HeaderSigningResult headerSigningResult;

        if (request.getHttpMethod() == HttpMethodName.GET) {
            request.addParameter("X-Amz-Date", timeStamp);
            request.addParameter("X-Amz-Algorithm", ALGORITHM);
            request.addParameter("X-Amz-Credential", signingCredentials);
            request.addParameter("X-Amz-SignedHeaders", getSignedHeadersString(request));

            headerSigningResult = computeSignature(request, dateStamp, timeStamp, ALGORITHM, contentSha256, sanitizedCredentials);
            request.addParameter("X-Amz-Signature", BinaryUtils.toHex(headerSigningResult.getSignature()));

        } else {

            request.addHeader("X-Amz-Date", timeStamp);

            if (request.getHeaders().get("x-amz-content-sha256") != null
                    && request.getHeaders().get("x-amz-content-sha256").equals("required")) {
                request.addHeader("x-amz-content-sha256", contentSha256);
            }

            headerSigningResult = computeSignature(request, dateStamp, timeStamp, ALGORITHM, contentSha256, sanitizedCredentials);

            String credentialsAuthorizationHeader =
                    "Credential=" + signingCredentials;
            String signedHeadersAuthorizationHeader =
                    "SignedHeaders=" + getSignedHeadersString(request);
            String signatureAuthorizationHeader =
                    "Signature=" + BinaryUtils.toHex(headerSigningResult.getSignature());

            String authorizationHeader = ALGORITHM + " "
                    + credentialsAuthorizationHeader + ", "
                    + signedHeadersAuthorizationHeader + ", "
                    + signatureAuthorizationHeader;

            request.addHeader("Authorization", authorizationHeader);
        }

        processRequestPayload(request, headerSigningResult);
    }
}