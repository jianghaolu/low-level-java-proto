package com.azure.ai.textanalytics.util;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpRequest;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestSpec {
    private final SerializerAdapter serializerAdapter;
    private final HttpPipeline httpPipeline;
    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, String> queries = new HashMap<>();
    private HttpMethod httpMethod;
    private String url;
    private String body;
    private Context context;

    public RequestSpec(SerializerAdapter serializerAdapter, HttpPipeline httpPipeline) {
        if (serializerAdapter == null) {
            throw new IllegalArgumentException("serializerAdapter");
        }
        if (httpPipeline == null) {
            throw new IllegalArgumentException("httpPipeline");
        }
        this.serializerAdapter = serializerAdapter;
        this.httpPipeline = httpPipeline;
    }

    public SerializerAdapter getSerializerAdapter() {
        return serializerAdapter;
    }

    public HttpPipeline getHttpPipeline() {
        return httpPipeline;
    }

    public Context getContext() {
        return context;
    }

    public RequestSpec url(String url) {
        this.url = url;
        return this;
    }

    public RequestSpec httpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public RequestSpec header(String header, String value) {
        headers.put(header, value);
        return this;
    }

    public RequestSpec body(String body) {
        this.body = body;
        return this;
    }

    public RequestSpec body(Object body) {
        try {
            this.body = serializerAdapter.serialize(body, SerializerEncoding.JSON);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public RequestSpec param(String parameterName, Object value) {
        if (url.contains("{" + parameterName + "}")) {
            url = url.replace("{" + parameterName + "}", serializerAdapter.serializeRaw(value));
        } else {
            queries.put(parameterName, serializerAdapter.serializeRaw(value));
        }
        return this;
    }

    public RequestSpec context(Context context) {
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
            url = url + String.join("&", queries.keySet().stream().map(key -> key + "=" + queries.get(key)).collect(Collectors.toList()));
        }
        HttpRequest request = new HttpRequest(httpMethod, url);
        if (!headers.isEmpty()) {
            request = request.setHeaders(new HttpHeaders(headers));
        }
        if (body != null && !body.isEmpty()) {
            request = request.setBody(body);
        }
        return request;
    }

    public ResponseSpec invoke() {
        return new ResponseSpec(serializerAdapter, httpPipeline.send(buildRequest(), context));
    }
}
