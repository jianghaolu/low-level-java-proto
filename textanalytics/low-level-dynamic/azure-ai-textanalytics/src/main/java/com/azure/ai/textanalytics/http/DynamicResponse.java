package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.BinaryData;
import com.azure.core.util.serializer.ObjectSerializer;

/**
 * A response received from sending a DynamicRequest.
 */
public class DynamicResponse {
    final ObjectSerializer objectSerializer;
    final HttpResponse response;
    final BinaryData body;

    /**
     * Creates an instance of the DynamicResponse.
     * @param objectSerializer a serializer for serializing and deserializing payloads
     * @param response the underlying HTTP response
     * @param body the full HTTP response body
     */
    public DynamicResponse(ObjectSerializer objectSerializer, HttpResponse response, BinaryData body) {
        this.objectSerializer = objectSerializer;
        this.response = response;
        this.body = body;
    }

    /**
     * @return the HTTP status code of the response
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * @return the HTTP headers of the response
     */
    public HttpHeaders getHeaders() {
        return response.getHeaders();
    }

    /**
     * @return the original HTTP request sent to get this response
     */
    public HttpRequest getRequest() {
        return response.getRequest();
    }

    /**
     * @return the response body
     */
    public BinaryData getBody() {
        return body;
    }
}
