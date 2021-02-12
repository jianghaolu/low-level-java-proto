// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation;

import com.azure.ai.textanalytics.implementation.models.AnalyzeBatchInput;
import com.azure.ai.textanalytics.implementation.models.AnalyzeJobState;
import com.azure.ai.textanalytics.implementation.models.AnalyzeResponse;
import com.azure.ai.textanalytics.implementation.models.CancelHealthJobResponse;
import com.azure.ai.textanalytics.implementation.models.EntitiesResult;
import com.azure.ai.textanalytics.implementation.models.EntityLinkingResult;
import com.azure.ai.textanalytics.implementation.models.ErrorResponseException;
import com.azure.ai.textanalytics.implementation.models.HealthResponse;
import com.azure.ai.textanalytics.implementation.models.HealthcareJobState;
import com.azure.ai.textanalytics.implementation.models.KeyPhraseResult;
import com.azure.ai.textanalytics.implementation.models.LanguageBatchInput;
import com.azure.ai.textanalytics.implementation.models.LanguageResult;
import com.azure.ai.textanalytics.implementation.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.implementation.models.PiiResult;
import com.azure.ai.textanalytics.implementation.models.SentimentResponse;
import com.azure.ai.textanalytics.implementation.models.StringIndexType;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import java.util.UUID;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the TextAnalyticsClient type. */
public final class TextAnalyticsClientImpl {
    /** The proxy service used to perform REST calls. */
    private final TextAnalyticsClientService service;

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
        this.service =
                RestProxy.create(TextAnalyticsClientService.class, this.httpPipeline, this.getSerializerAdapter());
    }

    /**
     * The interface defining all the services for TextAnalyticsClient to be used by the proxy service to perform REST
     * calls.
     */
    @Host("{Endpoint}/text/analytics/v3.1-preview.3")
    @ServiceInterface(name = "TextAnalyticsClient")
    private interface TextAnalyticsClientService {
        @Post("/analyze")
        @ExpectedResponses({202})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<AnalyzeResponse> analyze(
                @HostParam("Endpoint") String endpoint,
                @BodyParam("application/json") AnalyzeBatchInput body,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/analyze/jobs/{jobId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<AnalyzeJobState>> analyzeStatus(
                @HostParam("Endpoint") String endpoint,
                @PathParam("jobId") String jobId,
                @QueryParam("showStats") Boolean showStats,
                @QueryParam("$top") Integer top,
                @QueryParam("$skip") Integer skip,
                @HeaderParam("Accept") String accept,
                Context context);

        @Get("/entities/health/jobs/{jobId}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<HealthcareJobState>> healthStatus(
                @HostParam("Endpoint") String endpoint,
                @PathParam("jobId") UUID jobId,
                @QueryParam("$top") Integer top,
                @QueryParam("$skip") Integer skip,
                @QueryParam("showStats") Boolean showStats,
                @HeaderParam("Accept") String accept,
                Context context);

        @Delete("/entities/health/jobs/{jobId}")
        @ExpectedResponses({202})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<CancelHealthJobResponse> cancelHealthJob(
                @HostParam("Endpoint") String endpoint,
                @PathParam("jobId") UUID jobId,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/entities/health/jobs")
        @ExpectedResponses({202})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<HealthResponse> health(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("model-version") String modelVersion,
                @QueryParam("stringIndexType") StringIndexType stringIndexType,
                @BodyParam("application/json") MultiLanguageBatchInput input,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/entities/recognition/general")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<EntitiesResult>> entitiesRecognitionGeneral(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("model-version") String modelVersion,
                @QueryParam("showStats") Boolean showStats,
                @QueryParam("stringIndexType") StringIndexType stringIndexType,
                @BodyParam("application/json") MultiLanguageBatchInput input,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/entities/recognition/pii")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<PiiResult>> entitiesRecognitionPii(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("model-version") String modelVersion,
                @QueryParam("showStats") Boolean showStats,
                @QueryParam("domain") String domain,
                @QueryParam("stringIndexType") StringIndexType stringIndexType,
                @BodyParam("application/json") MultiLanguageBatchInput input,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/entities/linking")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<EntityLinkingResult>> entitiesLinking(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("model-version") String modelVersion,
                @QueryParam("showStats") Boolean showStats,
                @QueryParam("stringIndexType") StringIndexType stringIndexType,
                @BodyParam("application/json") MultiLanguageBatchInput input,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/keyPhrases")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<KeyPhraseResult>> keyPhrases(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("model-version") String modelVersion,
                @QueryParam("showStats") Boolean showStats,
                @BodyParam("application/json") MultiLanguageBatchInput input,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/languages")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<LanguageResult>> languages(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("model-version") String modelVersion,
                @QueryParam("showStats") Boolean showStats,
                @BodyParam("application/json") LanguageBatchInput input,
                @HeaderParam("Accept") String accept,
                Context context);

        @Post("/sentiment")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<SentimentResponse>> sentiment(
                @HostParam("Endpoint") String endpoint,
                @QueryParam("model-version") String modelVersion,
                @QueryParam("showStats") Boolean showStats,
                @QueryParam("opinionMining") Boolean opinionMining,
                @QueryParam("stringIndexType") StringIndexType stringIndexType,
                @BodyParam("application/json") MultiLanguageBatchInput input,
                @HeaderParam("Accept") String accept,
                Context context);
    }

    /**
     * Submit a collection of text documents for analysis. Specify one or more unique tasks to be executed.
     *
     * @param body Collection of documents to analyze and tasks to execute.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<AnalyzeResponse> analyzeWithResponseAsync(AnalyzeBatchInput body, Context context) {
        final String accept = "application/json, text/json";
        return service.analyze(this.getEndpoint(), body, accept, context);
    }

    /**
     * Get the status of an analysis job. A job may consist of one or more tasks. Once all tasks are completed, the job
     * will transition to the completed state and results will be available for each task.
     *
     * @param jobId Job ID for Analyze.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param top (Optional) Set the maximum number of results per task. When both $top and $skip are specified, $skip
     *     is applied first.
     * @param skip (Optional) Set the number of elements to offset in the response. When both $top and $skip are
     *     specified, $skip is applied first.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the status of an analysis job.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<AnalyzeJobState>> analyzeStatusWithResponseAsync(
            String jobId, Boolean showStats, Integer top, Integer skip, Context context) {
        final String accept = "application/json, text/json";
        return service.analyzeStatus(this.getEndpoint(), jobId, showStats, top, skip, accept, context);
    }

    /**
     * Get details of the healthcare prediction job specified by the jobId.
     *
     * @param jobId Job ID.
     * @param top (Optional) Set the maximum number of results per task. When both $top and $skip are specified, $skip
     *     is applied first.
     * @param skip (Optional) Set the number of elements to offset in the response. When both $top and $skip are
     *     specified, $skip is applied first.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details of the healthcare prediction job specified by the jobId.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<HealthcareJobState>> healthStatusWithResponseAsync(
            UUID jobId, Integer top, Integer skip, Boolean showStats, Context context) {
        final String accept = "application/json, text/json";
        return service.healthStatus(this.getEndpoint(), jobId, top, skip, showStats, accept, context);
    }

    /**
     * Cancel healthcare prediction job.
     *
     * @param jobId Job ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<CancelHealthJobResponse> cancelHealthJobWithResponseAsync(UUID jobId, Context context) {
        final String accept = "application/json, text/json";
        return service.cancelHealthJob(this.getEndpoint(), jobId, accept, context);
    }

    /**
     * Start a healthcare analysis job to recognize healthcare related entities (drugs, conditions, symptoms, etc) and
     * their relations.
     *
     * @param input Collection of documents to analyze.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is
     *     not specified, the API should default to the latest, non-preview version.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets. Defaults to Text
     *     Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *     https://aka.ms/text-analytics-offsets.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<HealthResponse> healthWithResponseAsync(
            MultiLanguageBatchInput input, String modelVersion, StringIndexType stringIndexType, Context context) {
        final String accept = "application/json, text/json";
        return service.health(this.getEndpoint(), modelVersion, stringIndexType, input, accept, context);
    }

    /**
     * The API returns a list of general named entities in a given document. For the list of supported entity types,
     * check &lt;a href="https://aka.ms/taner"&gt;Supported Entity Types in Text Analytics API&lt;/a&gt;. See the &lt;a
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
    public Mono<Response<EntitiesResult>> entitiesRecognitionGeneralWithResponseAsync(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            StringIndexType stringIndexType,
            Context context) {
        final String accept = "application/json, text/json";
        return service.entitiesRecognitionGeneral(
                this.getEndpoint(), modelVersion, showStats, stringIndexType, input, accept, context);
    }

    /**
     * The API returns a list of entities with personal information (\"SSN\", \"Bank Account\" etc) in the document. For
     * the list of supported entity types, check &lt;a href="https://aka.ms/tanerpii"&gt;Supported Entity Types in Text
     * Analytics API&lt;/a&gt;. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics
     * API&lt;/a&gt; for the list of enabled languages.
     *
     * @param input Collection of documents to analyze.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is
     *     not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param domain (Optional) if specified, will set the PII domain to include only a subset of the entity categories.
     *     Possible values include: 'PHI', 'none'.
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
    public Mono<Response<PiiResult>> entitiesRecognitionPiiWithResponseAsync(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            String domain,
            StringIndexType stringIndexType,
            Context context) {
        final String accept = "application/json, text/json";
        return service.entitiesRecognitionPii(
                this.getEndpoint(), modelVersion, showStats, domain, stringIndexType, input, accept, context);
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
    public Mono<Response<EntityLinkingResult>> entitiesLinkingWithResponseAsync(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            StringIndexType stringIndexType,
            Context context) {
        final String accept = "application/json, text/json";
        return service.entitiesLinking(
                this.getEndpoint(), modelVersion, showStats, stringIndexType, input, accept, context);
    }

    /**
     * The API returns a list of strings denoting the key phrases in the input text. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * @param input Collection of documents to analyze.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is
     *     not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyPhraseResult>> keyPhrasesWithResponseAsync(
            MultiLanguageBatchInput input, String modelVersion, Boolean showStats, Context context) {
        final String accept = "application/json, text/json";
        return service.keyPhrases(this.getEndpoint(), modelVersion, showStats, input, accept, context);
    }

    /**
     * The API returns the detected language and a numeric score between 0 and 1. Scores close to 1 indicate 100%
     * certainty that the identified language is true. See the &lt;a href="https://aka.ms/talangs"&gt;Supported
     * languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     *
     * @param input Collection of documents to analyze for language endpoint.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is
     *     not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LanguageResult>> languagesWithResponseAsync(
            LanguageBatchInput input, String modelVersion, Boolean showStats, Context context) {
        final String accept = "application/json, text/json";
        return service.languages(this.getEndpoint(), modelVersion, showStats, input, accept, context);
    }

    /**
     * The API returns a detailed sentiment analysis for the input text. The analysis is done in multiple levels of
     * granularity, start from the a document level, down to sentence and key terms (aspects) and opinions.
     *
     * @param input Collection of documents to analyze.
     * @param modelVersion (Optional) This value indicates which model will be used for scoring. If a model-version is
     *     not specified, the API should default to the latest, non-preview version.
     * @param showStats (Optional) if set to true, response will contain request and document level statistics.
     * @param opinionMining (Optional) if set to true, response will contain input and document level statistics
     *     including aspect-based sentiment analysis results.
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
    public Mono<Response<SentimentResponse>> sentimentWithResponseAsync(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            Boolean opinionMining,
            StringIndexType stringIndexType,
            Context context) {
        final String accept = "application/json, text/json";
        return service.sentiment(
                this.getEndpoint(), modelVersion, showStats, opinionMining, stringIndexType, input, accept, context);
    }
}