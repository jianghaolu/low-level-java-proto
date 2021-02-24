package com.azure.ai.textanalytics.http;

import com.azure.core.http.HttpResponse;
import com.azure.core.util.BinaryData;
import com.azure.core.util.serializer.ObjectSerializer;

public class SimpleDynamicResponse extends DynamicResponse<BinaryData> {
    public SimpleDynamicResponse(ObjectSerializer objectSerializer, HttpResponse response, BinaryData body) {
        super(objectSerializer, response, body);
    }

    @Override
    public BinaryData getBody() {
        return body;
    }
}
