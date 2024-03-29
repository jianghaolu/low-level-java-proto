// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics;

import com.azure.core.annotation.ServiceClientBuilder;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.HttpPolicyProviders;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.util.Configuration;
import com.azure.core.util.serializer.ObjectSerializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** A builder for creating a new instance of the TextAnalyticsClient type. */
@ServiceClientBuilder(serviceClients = {TextAnalyticsClient.class})
public final class TextAnalyticsClientBuilder {
    private static final String SDK_NAME = "name";

    private static final String SDK_VERSION = "version";

    private final Map<String, String> properties = new HashMap<>();

    /** Create an instance of the TextAnalyticsClientBuilder. */
    public TextAnalyticsClientBuilder() {
        this.pipelinePolicies = new ArrayList<>();
    }

    /*
     * Supported Cognitive Services endpoints (protocol and hostname, for
     * example: https://westus.api.cognitive.microsoft.com).
     */
    private String endpoint;

    /**
     * Sets Supported Cognitive Services endpoints (protocol and hostname, for example:
     * https://westus.api.cognitive.microsoft.com).
     *
     * @param endpoint the endpoint value.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /*
     * The serializer to serialize an object into a string.
     */
    private ObjectSerializer objectSerializer;

    /**
     * Sets The serializer to serialize an object into a string.
     *
     * @param objectSerializer the objectSerializer value.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder objectSerializer(ObjectSerializer objectSerializer) {
        this.objectSerializer = objectSerializer;
        return this;
    }

    /*
     * The HTTP pipeline to send requests through
     */
    private HttpPipeline pipeline;

    /**
     * Sets The HTTP pipeline to send requests through.
     *
     * @param pipeline the pipeline value.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder pipeline(HttpPipeline pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    /*
     * The HTTP client used to send the request.
     */
    private HttpClient httpClient;

    /**
     * Sets The HTTP client used to send the request.
     *
     * @param httpClient the httpClient value.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /*
     * The configuration store that is used during construction of the service
     * client.
     */
    private Configuration configuration;

    /**
     * Sets The configuration store that is used during construction of the service client.
     *
     * @param configuration the configuration value.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder configuration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    /*
     * The logging configuration for HTTP requests and responses.
     */
    private HttpLogOptions httpLogOptions;

    /**
     * Sets The logging configuration for HTTP requests and responses.
     *
     * @param httpLogOptions the httpLogOptions value.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder httpLogOptions(HttpLogOptions httpLogOptions) {
        this.httpLogOptions = httpLogOptions;
        return this;
    }

    /*
     * The retry policy that will attempt to retry failed requests, if
     * applicable.
     */
    private RetryPolicy retryPolicy;

    /**
     * Sets The retry policy that will attempt to retry failed requests, if applicable.
     *
     * @param retryPolicy the retryPolicy value.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder retryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
        return this;
    }

    /*
     * The list of Http pipeline policies to add.
     */
    private final List<HttpPipelinePolicy> pipelinePolicies;

    /**
     * Adds a custom Http pipeline policy.
     *
     * @param customPolicy The custom Http pipeline policy to add.
     * @return the TextAnalyticsClientBuilder.
     */
    public TextAnalyticsClientBuilder addPolicy(HttpPipelinePolicy customPolicy) {
        pipelinePolicies.add(customPolicy);
        return this;
    }

    private HttpPipeline createHttpPipeline() {
        Configuration buildConfiguration =
                (configuration == null) ? Configuration.getGlobalConfiguration() : configuration;
        if (httpLogOptions == null) {
            httpLogOptions = new HttpLogOptions();
        }
        List<HttpPipelinePolicy> policies = new ArrayList<>();
        String clientName = properties.getOrDefault(SDK_NAME, "UnknownName");
        String clientVersion = properties.getOrDefault(SDK_VERSION, "UnknownVersion");
        policies.add(
                new UserAgentPolicy(httpLogOptions.getApplicationId(), clientName, clientVersion, buildConfiguration));
        HttpPolicyProviders.addBeforeRetryPolicies(policies);
        policies.add(retryPolicy == null ? new RetryPolicy() : retryPolicy);
        policies.add(new CookiePolicy());
        policies.addAll(this.pipelinePolicies);
        HttpPolicyProviders.addAfterRetryPolicies(policies);
        policies.add(new HttpLoggingPolicy(httpLogOptions));
        HttpPipeline httpPipeline =
                new HttpPipelineBuilder()
                        .policies(policies.toArray(new HttpPipelinePolicy[0]))
                        .httpClient(httpClient)
                        .build();
        return httpPipeline;
    }

    /**
     * Builds an instance of TextAnalyticsClient low level client.
     *
     * @return an instance of TextAnalyticsClient.
     */
    public TextAnalyticsClient buildClient() {
        TextAnalyticsClient client = new TextAnalyticsClient(endpoint, pipeline, objectSerializer);
        return client;
    }
}
