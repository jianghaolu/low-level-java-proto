// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.BinaryData;

/**
 * A response received from sending a DynamicRequest.
 */
public class DynamicResponse {
    private final HttpResponse response;
    private final BinaryData body;

    /**
     * Creates an instance of the DynamicResponse.
     * @param response the underlying HTTP response
     * @param body the full HTTP response body
     */
    public DynamicResponse(HttpResponse response, BinaryData body) {
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
