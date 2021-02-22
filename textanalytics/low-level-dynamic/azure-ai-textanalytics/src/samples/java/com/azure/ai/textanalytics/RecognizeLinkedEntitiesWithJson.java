// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.TypeReference;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

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
                .build();

        JsonObject document = Json.createObjectBuilder()
                .add("id", "0")
                .add("text", "Old Faithful is a geyser at Yellowstone Park.")
                .build();

        JsonObject batchInput = Json.createObjectBuilder()
                .add("documents", Json.createArrayBuilder().add(document).build())
                .build();

        JsonObject deserialized = client.entitiesLinking() // DynamicRequest
                .setBody(batchInput) // DynamicRequest
                .context(Context.NONE) // DynamicRequest
                .send()  // DynamicResponse
                .getBody() // BinaryData
                .toObject(TypeReference.createInstance(JsonObject.class)); // JsonObject

        if (deserialized != null && deserialized.containsKey("documents")) {
            JsonArray documents = deserialized.getJsonArray("documents");

            documents.forEach(linkedEntity -> {
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
}