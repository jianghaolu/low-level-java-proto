package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.ObjectSerializer;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicRequest {
    private final ObjectSerializer objectSerializer;
    private final HttpPipeline httpPipeline;
    private HttpHeaders headers = new HttpHeaders();
    private final Map<String, String> queries = new HashMap<>();
    private HttpMethod httpMethod;
    private String url;
    private byte[] body;
    private Context context;

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

    public ObjectSerializer getObjectSerializer() {
        return objectSerializer;
    }

    public HttpPipeline getHttpPipeline() {
        return httpPipeline;
    }

    public Context getContext() {
        return context;
    }

    public DynamicRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public DynamicRequest setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public DynamicRequest addHeader(String header, String value) {
        headers.put(header, value);
        return this;
    }

    public DynamicRequest addHeader(HttpHeader httpHeader) {
        if (httpHeader == null) {
            throw new IllegalArgumentException("httpHeader");
        }
        headers.put(httpHeader.getName(), httpHeader.getValue());
        return this;
    }

    public DynamicRequest setHeaders(HttpHeaders httpHeaders) {
        this.headers = httpHeaders;
        return this;
    }

    public DynamicRequest setBody(String body) {
        this.body = body.getBytes(StandardCharsets.UTF_8);
        return this;
    }

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

    public DynamicRequest setPathParam(String parameterName, String value) {
        if (!url.contains("{" + parameterName + "}")) {
            throw new IllegalArgumentException("no path param \"" + parameterName + "\"");
        }
        url = url.replace("{" + parameterName + "}", value);
        return this;
    }

    public DynamicRequest setQueryParam(String parameterName, String value) {
        queries.put(parameterName, value);
        return this;
    }

    public DynamicRequest context(Context context) {
        this.context = context;
        return this;
    }

    protected HttpRequest buildRequest() {
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

    public DynamicResponse send() {
        return sendAsync().block();
    }

    public Mono<DynamicResponse> sendAsync() {
        return httpPipeline.send(buildRequest(), context)
                .flatMap(httpResponse -> BinaryData.fromFlux(httpResponse.getBody())
                        .map(data -> new DynamicResponse(objectSerializer, httpResponse, data)));
    }
}
