// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.implementation.TextAnalyticsClientImpl;
import com.azure.ai.textanalytics.implementation.models.ErrorResponseException;
import com.azure.ai.textanalytics.implementation.models.StringIndexType;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous TextAnalyticsClient type. */
@ServiceClient(builder = TextAnalyticsClientBuilder.class, isAsync = true)
public final class TextAnalyticsAsyncClient {
    private final TextAnalyticsClientImpl serviceClient;

    /**
     * Initializes an instance of TextAnalyticsClient client.
     *
     * @param serviceClient the service client implementation.
     */
    TextAnalyticsAsyncClient(TextAnalyticsClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The API returns a list of recognized entities with links to a well-known knowledge base. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * @param input Collection of documents to analyze.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is
     *     not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets. Defaults to Text
     *     Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *     https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<String>> entitiesLinkingWithResponse(
            String input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return this.serviceClient.entitiesLinkingWithResponseAsync(input, modelVersion, showStats, stringIndexType);
    }

    /**
     * The API returns a list of recognized entities with links to a well-known knowledge base. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * @param input Collection of documents to analyze.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is
     *     not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets. Defaults to Text
     *     Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *     https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<String> entitiesLinking(
            String input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return this.serviceClient.entitiesLinkingAsync(input, modelVersion, showStats, stringIndexType);
    }
}
