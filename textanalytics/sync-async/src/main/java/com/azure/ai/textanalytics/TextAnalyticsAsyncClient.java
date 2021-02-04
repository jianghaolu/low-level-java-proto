// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.implementation.TextAnalyticsClientImpl;
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
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import java.util.UUID;
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
     * Submit a collection of text documents for analysis. Specify one or more unique tasks to be executed.
     *
     * @param body Collection of documents to analyze and tasks to execute.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<AnalyzeResponse> analyzeWithResponse(AnalyzeBatchInput body) {
        return this.serviceClient.analyzeWithResponseAsync(body);
    }

    /**
     * Submit a collection of text documents for analysis. Specify one or more unique tasks to be executed.
     *
     * @param body Collection of documents to analyze and tasks to execute.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> analyze(AnalyzeBatchInput body) {
        return this.serviceClient.analyzeAsync(body);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the status of an analysis job.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<AnalyzeJobState>> analyzeStatusWithResponse(
            String jobId, Boolean showStats, Integer top, Integer skip) {
        return this.serviceClient.analyzeStatusWithResponseAsync(jobId, showStats, top, skip);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the status of an analysis job.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<AnalyzeJobState> analyzeStatus(String jobId, Boolean showStats, Integer top, Integer skip) {
        return this.serviceClient.analyzeStatusAsync(jobId, showStats, top, skip);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details of the healthcare prediction job specified by the jobId.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<HealthcareJobState>> healthStatusWithResponse(
            UUID jobId, Integer top, Integer skip, Boolean showStats) {
        return this.serviceClient.healthStatusWithResponseAsync(jobId, top, skip, showStats);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return details of the healthcare prediction job specified by the jobId.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<HealthcareJobState> healthStatus(UUID jobId, Integer top, Integer skip, Boolean showStats) {
        return this.serviceClient.healthStatusAsync(jobId, top, skip, showStats);
    }

    /**
     * Cancel healthcare prediction job.
     *
     * @param jobId Job ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<CancelHealthJobResponse> cancelHealthJobWithResponse(UUID jobId) {
        return this.serviceClient.cancelHealthJobWithResponseAsync(jobId);
    }

    /**
     * Cancel healthcare prediction job.
     *
     * @param jobId Job ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> cancelHealthJob(UUID jobId) {
        return this.serviceClient.cancelHealthJobAsync(jobId);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<HealthResponse> healthWithResponse(
            MultiLanguageBatchInput input, String modelVersion, StringIndexType stringIndexType) {
        return this.serviceClient.healthWithResponseAsync(input, modelVersion, stringIndexType);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> health(MultiLanguageBatchInput input, String modelVersion, StringIndexType stringIndexType) {
        return this.serviceClient.healthAsync(input, modelVersion, stringIndexType);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<EntitiesResult>> entitiesRecognitionGeneralWithResponse(
            MultiLanguageBatchInput input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return this.serviceClient.entitiesRecognitionGeneralWithResponseAsync(
                input, modelVersion, showStats, stringIndexType);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<EntitiesResult> entitiesRecognitionGeneral(
            MultiLanguageBatchInput input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return this.serviceClient.entitiesRecognitionGeneralAsync(input, modelVersion, showStats, stringIndexType);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<PiiResult>> entitiesRecognitionPiiWithResponse(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            String domain,
            StringIndexType stringIndexType) {
        return this.serviceClient.entitiesRecognitionPiiWithResponseAsync(
                input, modelVersion, showStats, domain, stringIndexType);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PiiResult> entitiesRecognitionPii(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            String domain,
            StringIndexType stringIndexType) {
        return this.serviceClient.entitiesRecognitionPiiAsync(input, modelVersion, showStats, domain, stringIndexType);
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
    public Mono<Response<EntityLinkingResult>> entitiesLinkingWithResponse(
            MultiLanguageBatchInput input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
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
    public Mono<EntityLinkingResult> entitiesLinking(
            MultiLanguageBatchInput input, String modelVersion, Boolean showStats, StringIndexType stringIndexType) {
        return this.serviceClient.entitiesLinkingAsync(input, modelVersion, showStats, stringIndexType);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<KeyPhraseResult>> keyPhrasesWithResponse(
            MultiLanguageBatchInput input, String modelVersion, Boolean showStats) {
        return this.serviceClient.keyPhrasesWithResponseAsync(input, modelVersion, showStats);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyPhraseResult> keyPhrases(MultiLanguageBatchInput input, String modelVersion, Boolean showStats) {
        return this.serviceClient.keyPhrasesAsync(input, modelVersion, showStats);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<LanguageResult>> languagesWithResponse(
            LanguageBatchInput input, String modelVersion, Boolean showStats) {
        return this.serviceClient.languagesWithResponseAsync(input, modelVersion, showStats);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LanguageResult> languages(LanguageBatchInput input, String modelVersion, Boolean showStats) {
        return this.serviceClient.languagesAsync(input, modelVersion, showStats);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SentimentResponse>> sentimentWithResponse(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            Boolean opinionMining,
            StringIndexType stringIndexType) {
        return this.serviceClient.sentimentWithResponseAsync(
                input, modelVersion, showStats, opinionMining, stringIndexType);
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
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SentimentResponse> sentiment(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            Boolean opinionMining,
            StringIndexType stringIndexType) {
        return this.serviceClient.sentimentAsync(input, modelVersion, showStats, opinionMining, stringIndexType);
    }
}
