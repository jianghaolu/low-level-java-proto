package com.azure.ai.textanalytics.util;

import com.azure.core.http.HttpResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.core.util.serializer.SerializerEncoding;
import reactor.core.publisher.Mono;

import java.io.IOException;

public class ResponseSpec {
    final SerializerAdapter serializerAdapter;
    final Mono<HttpResponse> response;

    public ResponseSpec(SerializerAdapter serializerAdapter, Mono<HttpResponse> response) {
        this.serializerAdapter = serializerAdapter;
        this.response = response;
    }

    public Mono<String> asString() {
        return response.flatMap(HttpResponse::getBodyAsString);
    }

    public Mono<byte[]> asByteArray() {
        return response.flatMap(HttpResponse::getBodyAsByteArray);
    }

    public Mono<HttpResponse> asHttpResponse() {
        return response;
    }

    public <T> Mono<T> as(Class<T> clazz) {
        return response.flatMap(r -> r.getBodyAsString().map(body -> {
            try {
                return serializerAdapter.deserialize(body, clazz, SerializerEncoding.JSON);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    public <T> Mono<Response<T>> asResponse(Class<T> bodyClass) {
        return response.flatMap(r -> r.getBodyAsString().map(body -> {
            try {
                return new SimpleResponse<>(r.getRequest(),
                        r.getStatusCode(),
                        r.getHeaders(),
                        serializerAdapter.deserialize(body, bodyClass, SerializerEncoding.JSON));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    public <H, V> Mono<ResponseBase<H, V>> asResponse(Class<H> headerClass, Class<V> bodyClass) {
        return response.flatMap(r -> r.getBodyAsString().map(body -> {
            try {
                return new ResponseBase<>(r.getRequest(),
                        r.getStatusCode(),
                        r.getHeaders(),
                        serializerAdapter.deserialize(r.getHeaders(), headerClass),
                        serializerAdapter.deserialize(body, bodyClass, SerializerEncoding.JSON));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
