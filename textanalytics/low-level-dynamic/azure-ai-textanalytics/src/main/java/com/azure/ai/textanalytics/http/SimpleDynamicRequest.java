package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpHeader;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.ObjectSerializer;
import reactor.core.publisher.Mono;

public class SimpleDynamicRequest extends DynamicRequest<Object, BinaryData> {
    public SimpleDynamicRequest(ObjectSerializer objectSerializer, HttpPipeline httpPipeline) {
        super(objectSerializer, httpPipeline);
    }

    @Override
    public SimpleDynamicRequest setUrl(String url) {
        return (SimpleDynamicRequest) super.setUrl(url);
    }

    @Override
    public SimpleDynamicRequest setHttpMethod(HttpMethod httpMethod) {
        return (SimpleDynamicRequest) super.setHttpMethod(httpMethod);
    }

    @Override
    public SimpleDynamicRequest addHeader(String header, String value) {
        return (SimpleDynamicRequest) super.addHeader(header, value);
    }

    @Override
    public SimpleDynamicRequest addHeader(HttpHeader httpHeader) {
        return (SimpleDynamicRequest) super.addHeader(httpHeader);
    }

    @Override
    public SimpleDynamicRequest setHeaders(HttpHeaders httpHeaders) {
        return (SimpleDynamicRequest) super.setHeaders(httpHeaders);
    }

    @Override
    public SimpleDynamicRequest setBody(String body) {
        return (SimpleDynamicRequest) super.setBody(body);
    }

    @Override
    public SimpleDynamicRequest setBody(Object body) {
        return (SimpleDynamicRequest) super.setBody(body);
    }

    @Override
    public SimpleDynamicRequest setPathParam(String parameterName, String value) {
        return (SimpleDynamicRequest) super.setPathParam(parameterName, value);
    }

    @Override
    public SimpleDynamicRequest setQueryParam(String parameterName, String value) {
        return (SimpleDynamicRequest) super.setQueryParam(parameterName, value);
    }

    @Override
    public SimpleDynamicRequest setContext(Context context) {
        return (SimpleDynamicRequest) super.setContext(context);
    }

    public SimpleDynamicResponse send() {
        return sendAsync().block();
    }

    public Mono<SimpleDynamicResponse> sendAsync() {
        return httpPipeline.send(buildRequest(), context)
                .flatMap(httpResponse -> BinaryData.fromFlux(httpResponse.getBody())
                        .map(data -> new SimpleDynamicResponse(objectSerializer, httpResponse, data)));
    }
}
