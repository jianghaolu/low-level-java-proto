// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.ProxyOptions;
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import com.azure.core.util.Context;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.net.InetSocketAddress;

import static com.azure.ai.textanalytics.util.JsonNodeBuilders.array;
import static com.azure.ai.textanalytics.util.JsonNodeBuilders.object;

/**
 * Sample demonstrates how to recognize the linked entities of document.
 */
public class RecognizeLinkedEntitiesWithJson {
    /**
     * Main method to invoke this demo about how to recognize the linked entities of document.
     *
     * @param args Unused arguments to the program.
     */
    public static void main(String[] args) {
        // Instantiate a client that will be used to call the service.
        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential("{ApiKey}"))
                .endpoint("{Endpoint}")
                .httpClient(new NettyAsyncHttpClientBuilder().proxy(new ProxyOptions(ProxyOptions.Type.HTTP, new InetSocketAddress("localhost", 8888))).build())
                .build();

        ObjectNode batchInput = object("documents", array(object("id", "0").with("text", "Old Faithful is a geyser at Yellowstone Park."))).end();

        ObjectNode deserialized = client.entitiesLinking() // RequestSpec
                .body(batchInput) // RequestSpec
                .context(Context.NONE) // RequestSpec
                .invoke()  // ResponseSpec
                .as(ObjectNode.class) // Mono<EntityLinkingResponse>
                .block();

        if (deserialized != null && deserialized.has("documents")) {
            ArrayNode document = (ArrayNode) deserialized.get("documents");

            document.forEach(linkedEntity -> {
                System.out.println("Linked Entities:");
                System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s,"
                                + " Bing Entity Search API ID: %s.%n",
                        linkedEntity.get("name").asText(), linkedEntity.get("dataSource").asText(), linkedEntity.get("url").asText(),
                        linkedEntity.get("dataSource").asText(), linkedEntity.get("bingId").asText());
                linkedEntity.get("matches").forEach(entityMatch -> System.out.printf(
                        "Matched entity: %s, confidence score: %f.%n",
                        entityMatch.get("text").asText(), entityMatch.get("confidenceScore").asDouble()));
            });
        }

    }
}