// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation;

import com.azure.ai.textanalytics.implementation.models.ErrorResponseException;
import com.azure.ai.textanalytics.implementation.models.StringIndexType;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Initializes a new instance of the TextAnalyticsClient type. */
public final class TextAnalyticsClientImpl {
    /**
     * Supported Cognitive Services endpoints (protocol and hostname, for example:
     * https://westus.api.cognitive.microsoft.com).
     */
    private final String endpoint;

    /**
     * Gets Supported Cognitive Services endpoints (protocol and hostname, for example:
     * https://westus.api.cognitive.microsoft.com).
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /** The HTTP pipeline to send requests through. */
    private final HttpPipeline httpPipeline;

    /**
     * Gets The HTTP pipeline to send requests through.
     *
     * @return the httpPipeline value.
     */
    public HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /** The serializer to serialize an object into a string. */
    private final SerializerAdapter serializerAdapter;

    /**
     * Gets The serializer to serialize an object into a string.
     *
     * @return the serializerAdapter value.
     */
    public SerializerAdapter getSerializerAdapter() {
        return this.serializerAdapter;
    }

    /**
     * Initializes an instance of TextAnalyticsClient client.
     *
     * @param endpoint Supported Cognitive Services endpoints (protocol and hostname, for example:
     *     https://westus.api.cognitive.microsoft.com).
     */
    public TextAnalyticsClientImpl(String endpoint) {
        this(
                new HttpPipelineBuilder()
                        .policies(new UserAgentPolicy(), new RetryPolicy(), new CookiePolicy())
                        .build(),
                JacksonAdapter.createDefaultSerializerAdapter(),
                endpoint);
    }

    /**
     * Initializes an instance of TextAnalyticsClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param endpoint Supported Cognitive Services endpoints (protocol and hostname, for example:
     *     https://westus.api.cognitive.microsoft.com).
     */
    public TextAnalyticsClientImpl(HttpPipeline httpPipeline, String endpoint) {
        this(httpPipeline, JacksonAdapter.createDefaultSerializerAdapter(), endpoint);
    }

    /**
     * Initializes an instance of TextAnalyticsClient client.
     *
     * @param httpPipeline The HTTP pipeline to send requests through.
     * @param serializerAdapter The serializer to serialize an object into a string.
     * @param endpoint Supported Cognitive Services endpoints (protocol and hostname, for example:
     *     https://westus.api.cognitive.microsoft.com).
     */
    public TextAnalyticsClientImpl(HttpPipeline httpPipeline, SerializerAdapter serializerAdapter, String endpoint) {
        this.httpPipeline = httpPipeline;
        this.serializerAdapter = serializerAdapter;
        this.endpoint = endpoint;
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
    public Mono<Response<JsonNode>> entitiesLinkingWithResponseAsync(
            JsonNode input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        final String accept = "application/json, text/json";
        return FluxUtil.withContext(
                context -> entitiesLinkingWithResponseAsync(input, modelVersion, showStats, stringIndexType, context));
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<JsonNode>> entitiesLinkingWithResponseAsync(
            JsonNode input,
            String modelVersion,
            Boolean showStats,
            StringIndexType stringIndexType,
            Context context) {
        String url = String.format("%s/text/analytics/v3.1-preview.3/entities/linking", getEndpoint());
        List<String> queries = new ArrayList<>();
        if (modelVersion != null) {
            queries.add("model-version=" + modelVersion);
        };
        if (showStats != null) {
            queries.add("show-stats=" + showStats);
        }
        if (stringIndexType != null) {
            queries.add("stringIndexType=" + stringIndexType.toString());
        }
        if (!queries.isEmpty()) {
            url = url + "?" + String.join("&", queries);
        }
        HttpRequest request = new HttpRequest(HttpMethod.POST, url);
        request.setHeader("Accept", "application/json, text/json");
        request.setBody(input.toString());
        return invoke(request, context).flatMap(res ->
                res.getBodyAsByteArray().map(responseBody ->
                {
                    try {
                        return new SimpleResponse<>(request, res.getStatusCode(), res.getHeaders(), new ObjectMapper().readTree(responseBody));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }));
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
    public Mono<JsonNode> entitiesLinkingAsync(
            JsonNode input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return entitiesLinkingWithResponseAsync(input, modelVersion, showStats, stringIndexType)
                .flatMap(
                        (Response<JsonNode> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<JsonNode> entitiesLinkingAsync(
            JsonNode input,
            String modelVersion,
            Boolean showStats,
            StringIndexType stringIndexType,
            Context context) {
        return entitiesLinkingWithResponseAsync(input, modelVersion, showStats, stringIndexType, context)
                .flatMap(
                        (Response<JsonNode> res) -> {
                            if (res.getValue() != null) {
                                return Mono.just(res.getValue());
                            } else {
                                return Mono.empty();
                            }
                        });
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
    public JsonNode entitiesLinking(
            JsonNode input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return entitiesLinkingAsync(input, modelVersion, showStats, stringIndexType).block();
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
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<JsonNode> entitiesLinkingWithResponse(
            JsonNode input,
            String modelVersion,
            Boolean showStats,
            StringIndexType stringIndexType,
            Context context) {
        return entitiesLinkingWithResponseAsync(input, modelVersion, showStats, stringIndexType, context).block();
    }

    public Mono<HttpResponse> invoke(HttpRequest request, Context context) {
        return getHttpPipeline().send(request, context);
    }
}
