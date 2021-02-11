package com.azure.ai.textanalytics.util;

import reactor.core.publisher.Mono;

public interface RequestSpec<T extends Mono<String>> {
    RequestSpec<T> header(String header, String value);

    RequestSpec<T> body(String body);

    RequestSpec<T> body(Object body);

    RequestSpec<T> param(String parameterName, String value);
}
