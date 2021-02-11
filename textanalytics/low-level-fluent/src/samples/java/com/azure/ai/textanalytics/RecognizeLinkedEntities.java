// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.implementation.models.DocumentLinkedEntities;
import com.azure.ai.textanalytics.implementation.models.EntityLinkingResult;
import com.azure.ai.textanalytics.implementation.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.implementation.models.MultiLanguageInput;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.ProxyOptions;
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

/**
 * Sample demonstrates how to recognize the linked entities of document.
 */
public class RecognizeLinkedEntities {
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
                .buildClient();

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode input = mapper.createObjectNode();
        input.put("id", "0");
        input.put("text", "Old Faithful is a geyser at Yellowstone Park.");
        ArrayNode documents = mapper.createArrayNode();
        documents.add(input);
        ObjectNode batchInput = mapper.createObjectNode();
        batchInput.set("documents", documents);
        JsonNode result = client.entitiesLinking(batchInput, null, null, null);
        JsonNode document = result.get("documents").get(0);

        ((ArrayNode) document.get("entities")).forEach(linkedEntity -> {
            System.out.println("Linked Entities:");
            System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s,"
                            + " Bing Entity Search API ID: %s.%n",
                    linkedEntity.get("name").asText(), linkedEntity.get("dataSource").asText(), linkedEntity.get("url").asText(),
                    linkedEntity.get("dataSource").asText(), linkedEntity.get("bingId").asText());
            linkedEntity.get("matches").forEach(entityMatch -> System.out.printf(
                    "Matched entity: %s, confidence score: %f.%n",
                    entityMatch.get("text").asText(), entityMatch.get("confidenceScore").asDouble()));
        });


        client.entityLinking() // RequestSpec
                .requestHeader("foo", "bar") // RequestSpec
                .requestBody(batchInput) // RequestSpec
                .invokeAsync()  // ResponseSpec<String>
                .decodeResponse(EntityLinkingResponse.class); // ResponseSpec<EntityLinkingResponse>
    }
}