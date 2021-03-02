// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Context;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.StringReader;

/**
 * Sample demonstrates how to recognize the linked entities of document.
 */
public class GetSentimentWithJson {
    /**
     * Main method to invoke this demo about how to recognize the linked entities of document.
     *
     * @param args Unused arguments to the program.
     */
    public static void main(String[] args) {
        // Instantiate a client that will be used to call the service.
        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential("<api-key-from-portal>"))
                .endpoint("<endpoint-from-portal>")
                .build();

        JsonObject document = Json.createObjectBuilder()
                .add("id", "0")
                .add("text", "Great atmosphere. Close to plenty of restaurants, hotels, and transit! Staff are friendly and helpful.")
                .add("language", "en")
                .build();

        JsonObject batchInput = Json.createObjectBuilder()
                .add("documents", Json.createArrayBuilder().add(document).build())
                .build();

        String responseBody = client.getSentiment() // DynamicRequest
                .setBody(batchInput.toString()) // DynamicRequest
                .setContext(Context.NONE) // DynamicRequest
                .send()  // DynamicResponse
                .getBody() // BinaryData
                .toString(); // String

        JsonObject deserialized = Json.createReader(new StringReader(responseBody)).readObject();

        if (deserialized != null && deserialized.containsKey("documents")) {
            System.out.println(String.format("Sentiment of document is %s", deserialized.getJsonArray("documents").get(0).asJsonObject().getString("sentiment")));
        }
    }
}