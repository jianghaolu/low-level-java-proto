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

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        JsonObject document = Json.createObjectBuilder()
                .add("id", "0")
                .add("text", "Old Faithful is a geyser at Yellowstone Park.")
                .build();

        JsonObject batchInput = Json.createObjectBuilder()
                .add("documents", Json.createArrayBuilder().add(document).build())
                .build();

        String response = client.entitiesLinking(batchInput.toString(), null, null, null);

        JsonReader jsonReader = Json.createReader(new StringReader(response));
        JsonObject result = jsonReader.readObject();

        result.getJsonArray("entities").forEach(linkedEntity -> {
            JsonObject entity = linkedEntity.asJsonObject();
            System.out.println("Linked Entities:");
            System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s,"
                            + " Bing Entity Search API ID: %s.%n",
                    entity.getString("name"), entity.getString("dataSource"), entity.getString("url"),
                    entity.getString("dataSource"), entity.getString("bingId"));
            entity.getJsonArray("matches").forEach(entityMatch -> {
                JsonObject match = entity.asJsonObject();
                System.out.printf(
                        "Matched entity: %s, confidence score: %f.%n",
                        match.getString("text"), match.getJsonNumber("confidenceScore").doubleValue());
            });
        });

    }
}