// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Context;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

/**
 * Sample demonstrates how to recognize the linked entities of document.
 */
public class GetLanguagesWithJson {
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

        JsonObject doc1 = Json.createObjectBuilder()
                .add("id", "1")
                .add("text", "Hello world")
                .add("countryHint", "US")
                .build();

        JsonObject doc2 = Json.createObjectBuilder()
                .add("id", "2")
                .add("text", "Bonjour tout le monde")
                .build();

        JsonObject doc3 = Json.createObjectBuilder()
                .add("id", "3")
                .add("text", "La carretera estaba atascada. Había mucho tráfico el día de ayer.")
                .build();

        JsonObject batchInput = Json.createObjectBuilder()
                .add("documents", Json.createArrayBuilder().add(doc1).add(doc2).add(doc3).build())
                .build();

        String responseBody = client.getlanguages() // DynamicRequest
                .setBody(batchInput.toString()) // DynamicRequest
                .setContext(Context.NONE) // DynamicRequest
                .send()  // DynamicResponse
                .getBody() // BinaryData
                .toString(); // String

        JsonObject deserialized = Json.createReader(new StringReader(responseBody)).readObject();

        if (deserialized != null && deserialized.containsKey("documents")) {
            deserialized.getJsonArray("documents").forEach(value -> {
                System.out.println(String.format("Detected language is %s with confidence score %f",
                        value.asJsonObject().getJsonObject("detectedLanguage").getString("name"),
                        value.asJsonObject().getJsonObject("detectedLanguage").getJsonNumber("confidenceScore").doubleValue()));
            });
        }
    }
}