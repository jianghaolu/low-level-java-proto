package com.azure.ai.textanalytics.util;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.ResponseBase;
import com.azure.core.http.rest.SimpleResponse;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ResponseSpec<T extends Response<?>> {
    Mono<T> invoke();
}
