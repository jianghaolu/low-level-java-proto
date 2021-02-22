package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.EntityLinkingResult;
import com.azure.ai.textanalytics.http.DynamicResponse;
import com.azure.core.http.HttpResponse;
import com.azure.core.util.serializer.ObjectSerializer;
import com.azure.core.util.serializer.SerializerAdapter;
import reactor.core.publisher.Mono;

public class EntitiesLinkingDynamicResponse extends DynamicResponse {
    public EntitiesLinkingDynamicResponse(ObjectSerializer objectSerializer, HttpResponse response) {
        super(objectSerializer, response);
    }

    public Mono<EntityLinkingResult> asEntityLinkingResult() {
        return super.as(EntityLinkingResult.class);
    }
}
