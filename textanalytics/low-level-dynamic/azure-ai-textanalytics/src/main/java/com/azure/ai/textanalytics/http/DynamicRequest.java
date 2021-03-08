// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.serializer.ObjectSerializer;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A customizable HTTP request instantiated from a low level client.
 */
public class DynamicRequest {
    private final ObjectSerializer objectSerializer;
    private final HttpPipeline httpPipeline;
    private HttpHeaders headers = new HttpHeaders();
    private final Map<String, String> queries = new HashMap<>();
    private HttpMethod httpMethod;
    private String url;
    private byte[] body;
    private Context context;
    private String[] requiredPathParameters;
    private String[] requiredQueryParameters;
    private String[] optionalQueryParameters;
    private String requestBodyType;
    private String responseBodyType;

    /**
     * Creates an instance of the Dynamic request.
     *
     * @param objectSerializer a serializer for serializing and deserializing payloads
     * @param httpPipeline the pipeline to send the actual HTTP request
     */
    public DynamicRequest(ObjectSerializer objectSerializer, HttpPipeline httpPipeline) {
        if (objectSerializer == null) {
            throw new IllegalArgumentException("objectSerializer");
        }
        if (httpPipeline == null) {
            throw new IllegalArgumentException("httpPipeline");
        }
        this.objectSerializer = objectSerializer;
        this.httpPipeline = httpPipeline;
    }

    /**
     * @return the underlying serializer used by this DynamicRequest
     */
    public ObjectSerializer getObjectSerializer() {
        return objectSerializer;
    }

    /**
     * @return the pipeline to sending HTTP requests used by this DynamicRequest
     */
    public HttpPipeline getHttpPipeline() {
        return httpPipeline;
    }

    /**
     * Sets the url for the HTTP request
     * @param url the URL for the request
     * @return the modified DynamicRequest object
     */
    public DynamicRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Sets the url for the HTTP request
     * @param httpMethod the HTTP method for the request
     * @return the modified DynamicRequest object
     */
    public DynamicRequest setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    /**
     * Adds a header to the HTTP request.
     * @param header the header key
     * @param value the header value
     * @return the modified DynamicRequest object
     */
    public DynamicRequest addHeader(String header, String value) {
        headers.put(header, value);
        return this;
    }

    /**
     * Adds a header to the HTTP request
     * @param httpHeader the header to add
     * @return the modified DynamicRequest object
     */
    public DynamicRequest addHeader(HttpHeader httpHeader) {
        if (httpHeader == null) {
            throw new IllegalArgumentException("httpHeader");
        }
        headers.put(httpHeader.getName(), httpHeader.getValue());
        return this;
    }

    /**
     * Sets the headers on the HTTP request
     * @param httpHeaders the new headers to replace all existing headers
     * @return the modified DynamicRequest object
     */
    public DynamicRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = httpHeaders;
        return this;
    }

    /**
     * Sets the body content on the HTTP request
     * @param body the serialized body content
     * @return the modified DynamicRequest object
     */
    public DynamicRequest setBody(String body) {
        this.body = body.getBytes(StandardCharsets.UTF_8);
        return this;
    }

    /**
     * Sets the body on the HTTP request
     * @param body the body object that will be serialized
     * @return the modified DynamicRequest object
     */
    public DynamicRequest setBody(Object body) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            objectSerializer.serialize(outputStream, body);
            this.body = outputStream.toByteArray();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    /**
     * Sets the value for a specific path parameter in the URL. The path parameter must be wrapped in a pair of
     * curly braces, like "{paramName}".
     * @param parameterName the path parameter's name in the curly braces
     * @param value the String value to replace the path parameter
     * @return the modified DynamicRequest object
     */
    public DynamicRequest setPathParam(String parameterName, String value) {
        if (!url.contains("{" + parameterName + "}")) {
            throw new IllegalArgumentException("no path param \"" + parameterName + "\"");
        }
        url = url.replace("{" + parameterName + "}", value);
        return this;
    }

    /**
     * Adds a query parameter to the request URL.
     * @param parameterName the name of the query parameter
     * @param value the value of the query parameter
     * @return the modified DynamicRequest object
     */
    public DynamicRequest addQueryParam(String parameterName, String value) {
        queries.put(parameterName, value);
        return this;
    }

    private HttpRequest buildRequest() {
        if (url == null) {
            throw new IllegalArgumentException("url");
        }
        if (httpMethod == null) {
            throw new IllegalArgumentException("httpMethod");
        }
        if (!queries.isEmpty()) {
            url = url + (url.contains("?") ? "&" : "?");
            url = url + queries.keySet().stream().map(key -> key + "=" + queries.get(key)).collect(Collectors.joining("&"));
        }
        HttpRequest request = new HttpRequest(httpMethod, url);
        if (headers != null) {
            request = request.setHeaders(headers);
        }
        if (body != null && body.length != 0) {
            request = request.setBody(body);
        }
        return request;
    }

    /**
     * Sends the request through the HTTP pipeline synchronously.
     * @return the dynamic response received from the API
     */
    public DynamicResponse send() {
        return send(Context.NONE);
    }

    /**
     * Sends the request through the HTTP pipeline synchronously.
     * @param context the context to send with the request
     * @return the dynamic response received from the API
     */
    public DynamicResponse send(Context context) {
        return httpPipeline.send(buildRequest(), context)
                .flatMap(httpResponse -> BinaryData.fromFlux(httpResponse.getBody())
                        .map(data -> new DynamicResponse(httpResponse, data)))
                .block();
    }

    /**
     * Sends the request through the HTTP pipeline asynchronously.
     * @return the reactor publisher for the dynamic response to subscribe to
     */
    public Mono<DynamicResponse> sendAsync() {
        return FluxUtil.withContext(context -> httpPipeline.send(buildRequest(), context)
                .flatMap(httpResponse -> BinaryData.fromFlux(httpResponse.getBody())
                        .map(data -> new DynamicResponse(httpResponse, data))));
    }
}
