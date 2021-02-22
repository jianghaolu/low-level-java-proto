package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.http.DynamicRequest;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.SerializerAdapter;

public class EntitiesLinkingDynamicRequest extends DynamicRequest {
    public EntitiesLinkingDynamicRequest(ObjectSerializer objectSerializer, HttpPipeline httpPipeline) {
        super(objectSerializer, httpPipeline);
    }

    public EntitiesLinkingDynamicRequest setBody(MultiLanguageBatchInput body) {
        return (EntitiesLinkingDynamicRequest) super.setBody(body);
    }

    @Override
    public EntitiesLinkingDynamicResponse send() {
        return new EntitiesLinkingDynamicResponse(getObjectSerializer(), getHttpPipeline().send(buildRequest(), getContext()));
    }

    @Override
    public EntitiesLinkingDynamicRequest setUrl(String url) {
        return (EntitiesLinkingDynamicRequest) super.setUrl(url);
    }

    @Override
    public EntitiesLinkingDynamicRequest setHttpMethod(HttpMethod httpMethod) {
        return (EntitiesLinkingDynamicRequest) super.setHttpMethod(httpMethod);
    }

    @Override
    public EntitiesLinkingDynamicRequest addHeader(String header, String value) {
        return (EntitiesLinkingDynamicRequest) super.addHeader(header, value);
    }

    @Override
    public EntitiesLinkingDynamicRequest setBody(String body) {
        return (EntitiesLinkingDynamicRequest) super.setBody(body);
    }

    @Override
    public EntitiesLinkingDynamicRequest setBody(Object body) {
        return (EntitiesLinkingDynamicRequest) super.setBody(body);
    }

    @Override
    public EntitiesLinkingDynamicRequest setPathParam(String parameterName, Object value) {
        return (EntitiesLinkingDynamicRequest) super.setQueryParam(parameterName, value);
    }

    @Override
    public EntitiesLinkingDynamicRequest context(Context context) {
        return (EntitiesLinkingDynamicRequest) super.context(context);
    }
}
