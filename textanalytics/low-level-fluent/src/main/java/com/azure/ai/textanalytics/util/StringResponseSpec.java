package com.azure.ai.textanalytics.util;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.http.rest.SimpleResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

public class StringResponseSpec implements ResponseSpec<Response<String>> {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Mono<Response<String>> response;

    public StringResponseSpec(Mono<Response<String>> response) {
        this.response = response;
    }

    <V> ResponseSpec<SimpleResponse<V>> deserialize(Class<V> clazz) {
        return () -> response.map(r -> {
            try {
                return new SimpleResponse<>(r, objectMapper.readValue(r.getValue(), clazz));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

    <H, V> ResponseSpec<ResponseBase<H, V>> deserialize(Class<H> headerClazz, Class<V> clazz) {
        return null;
    }

    @Override
    public Mono<Response<String>> invoke() {
        return null;
    }
}
