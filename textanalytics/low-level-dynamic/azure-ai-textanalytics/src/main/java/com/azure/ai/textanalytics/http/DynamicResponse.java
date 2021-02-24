package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.BinaryData;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.TypeReference;

public class DynamicResponse<ResT> {
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

    public ResT getBody() {
        return body.toObject(new TypeReference<ResT>() { });
    }
}
