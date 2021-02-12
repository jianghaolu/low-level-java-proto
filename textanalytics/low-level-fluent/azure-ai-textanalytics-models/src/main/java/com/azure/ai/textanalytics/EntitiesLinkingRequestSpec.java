package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.util.RequestSpec;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.SerializerAdapter;

public class EntitiesLinkingRequestSpec extends RequestSpec {
    public EntitiesLinkingRequestSpec(SerializerAdapter serializerAdapter, HttpPipeline httpPipeline) {
        super(serializerAdapter, httpPipeline);
    }

    public EntitiesLinkingRequestSpec body(MultiLanguageBatchInput body) {
        return (EntitiesLinkingRequestSpec) super.body(body);
    }

    @Override
    public EntitiesLinkingResponseSpec invoke() {
        return new EntitiesLinkingResponseSpec(getSerializerAdapter(), getHttpPipeline().send(buildRequest(), getContext()));
    }

    @Override
    public EntitiesLinkingRequestSpec url(String url) {
        return (EntitiesLinkingRequestSpec) super.url(url);
    }

    @Override
    public EntitiesLinkingRequestSpec httpMethod(HttpMethod httpMethod) {
        return (EntitiesLinkingRequestSpec) super.httpMethod(httpMethod);
    }

    @Override
    public EntitiesLinkingRequestSpec header(String header, String value) {
        return (EntitiesLinkingRequestSpec) super.header(header, value);
    }

    @Override
    public EntitiesLinkingRequestSpec body(String body) {
        return (EntitiesLinkingRequestSpec) super.body(body);
    }

    @Override
    public EntitiesLinkingRequestSpec body(Object body) {
        return (EntitiesLinkingRequestSpec) super.body(body);
    }

    @Override
    public EntitiesLinkingRequestSpec param(String parameterName, Object value) {
        return (EntitiesLinkingRequestSpec) super.param(parameterName, value);
    }

    @Override
    public EntitiesLinkingRequestSpec context(Context context) {
        return (EntitiesLinkingRequestSpec) super.context(context);
    }
}
