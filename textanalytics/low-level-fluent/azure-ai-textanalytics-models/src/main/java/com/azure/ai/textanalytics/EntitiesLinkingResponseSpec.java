package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.EntityLinkingResult;
import com.azure.ai.textanalytics.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.util.ResponseSpec;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.serializer.SerializerAdapter;
import reactor.core.publisher.Mono;

public class EntitiesLinkingResponseSpec extends ResponseSpec {
    public EntitiesLinkingResponseSpec(SerializerAdapter serializerAdapter, Mono<HttpResponse> response) {
        super(serializerAdapter, response);
    }

    public Mono<EntityLinkingResult> asEntityLinkingResult() {
        return super.as(EntityLinkingResult.class);
    }
}
