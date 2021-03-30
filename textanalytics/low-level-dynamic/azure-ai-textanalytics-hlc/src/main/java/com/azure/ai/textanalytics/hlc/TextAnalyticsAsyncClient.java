// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.hlc;

import com.azure.ai.textanalytics.hlc.implementation.TextAnalyticsClientImpl;
import com.azure.ai.textanalytics.hlc.models.EntitiesResult;
import com.azure.ai.textanalytics.hlc.models.EntityLinkingResult;
import com.azure.ai.textanalytics.hlc.models.ErrorResponseException;
import com.azure.ai.textanalytics.hlc.models.KeyPhraseResult;
import com.azure.ai.textanalytics.hlc.models.LanguageBatchInput;
import com.azure.ai.textanalytics.hlc.models.LanguageResult;
import com.azure.ai.textanalytics.hlc.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.hlc.models.PiiEntitiesResult;
import com.azure.ai.textanalytics.hlc.models.SentimentResponse;
import com.azure.ai.textanalytics.hlc.models.StringIndexType;
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
     * The API returns a list of general named entities in a given document. For the list of supported entity types,
     * check &lt;a href="https://aka.ms/taner"&gt;Supported Entity Types in Text Analytics API&lt;/a&gt;. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * @param input Collection of documents to analyze.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<EntitiesResult> entitiesRecognitionGeneral(MultiLanguageBatchInput input) {
        return this.serviceClient.entitiesRecognitionGeneralAsync(input);
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
     * @param domain (Optional) if set to 'PHI', response will contain only PHI entities.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets. Defaults to Text
     *     Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *     https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<PiiEntitiesResult>> entitiesRecognitionPiiWithResponse(
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
     * @param domain (Optional) if set to 'PHI', response will contain only PHI entities.
     * @param stringIndexType (Optional) Specifies the method used to interpret string offsets. Defaults to Text
     *     Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *     https://aka.ms/text-analytics-offsets.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PiiEntitiesResult> entitiesRecognitionPii(
            MultiLanguageBatchInput input,
            String modelVersion,
            Boolean showStats,
            String domain,
            StringIndexType stringIndexType) {
        return this.serviceClient.entitiesRecognitionPiiAsync(input, modelVersion, showStats, domain, stringIndexType);
    }

    /**
     * The API returns a list of entities with personal information (\"SSN\", \"Bank Account\" etc) in the document. For
     * the list of supported entity types, check &lt;a href="https://aka.ms/tanerpii"&gt;Supported Entity Types in Text
     * Analytics API&lt;/a&gt;. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics
     * API&lt;/a&gt; for the list of enabled languages.
     *
     * @param input Collection of documents to analyze.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PiiEntitiesResult> entitiesRecognitionPii(MultiLanguageBatchInput input) {
        return this.serviceClient.entitiesRecognitionPiiAsync(input);
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
     * The API returns a list of recognized entities with links to a well-known knowledge base. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * @param input Collection of documents to analyze.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<EntityLinkingResult> entitiesLinking(MultiLanguageBatchInput input) {
        return this.serviceClient.entitiesLinkingAsync(input);
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
     * The API returns a list of strings denoting the key phrases in the input text. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * @param input Collection of documents to analyze.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<KeyPhraseResult> keyPhrases(MultiLanguageBatchInput input) {
        return this.serviceClient.keyPhrasesAsync(input);
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
     * The API returns the detected language and a numeric score between 0 and 1. Scores close to 1 indicate 100%
     * certainty that the identified language is true. See the &lt;a href="https://aka.ms/talangs"&gt;Supported
     * languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     *
     * @param input Collection of documents to analyze for language endpoint.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<LanguageResult> languages(LanguageBatchInput input) {
        return this.serviceClient.languagesAsync(input);
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

    /**
     * The API returns a detailed sentiment analysis for the input text. The analysis is done in multiple levels of
     * granularity, start from the a document level, down to sentence and key terms (aspects) and opinions.
     *
     * @param input Collection of documents to analyze.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SentimentResponse> sentiment(MultiLanguageBatchInput input) {
        return this.serviceClient.sentimentAsync(input);
    }
}
