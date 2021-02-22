package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.BinaryData;
import com.azure.core.util.serializer.ObjectSerializer;

public class DynamicResponse {
    final ObjectSerializer objectSerializer;
    final HttpResponse response;
    final BinaryData body;

    public DynamicResponse(ObjectSerializer objectSerializer, HttpResponse response, BinaryData body) {
        this.objectSerializer = objectSerializer;
        this.response = response;
        this.body = body;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public HttpHeaders getHeaders() {
        return response.getHeaders();
    }

    public HttpRequest getRequest() {
        return response.getRequest();
    }

    public BinaryData getBody() {
        return body;
    }
}
