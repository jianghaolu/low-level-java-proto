// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.DocumentLinkedEntities;
import com.azure.ai.textanalytics.models.EntityLinkingResult;
import com.azure.ai.textanalytics.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.models.MultiLanguageInput;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Context;
import com.azure.core.util.serializer.TypeReference;

import java.util.Collections;

/**
 * Sample demonstrates how to recognize the linked entities of document.
 */
public class RecognizeLinkedEntitiesWithModels {
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

        MultiLanguageInput input = new MultiLanguageInput()
                .setId("0").setText("Old Faithful is a geyser at Yellowstone Park.");
        MultiLanguageBatchInput batchInput = new MultiLanguageBatchInput().setDocuments(Collections.singletonList(input));

        EntityLinkingResult result = client.getLinkedEntities() // DynamicRequest
                .setBody(batchInput) // DynamicRequest
                .setContext(Context.NONE) // DynamicRequest
                .send()  // DynamicResponse
                .getBody() // BinaryData
                .toObject(TypeReference.createInstance(EntityLinkingResult.class));

        DocumentLinkedEntities document = result.getDocuments().get(0);

        document.getEntities().forEach(linkedEntity -> {
            System.out.println("Linked Entities:");
            System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s,"
                            + " Bing Entity Search API ID: %s.%n",
                    linkedEntity.getName(), linkedEntity.getDataSource(), linkedEntity.getUrl(),
                    linkedEntity.getDataSource(), linkedEntity.getBingId());
            linkedEntity.getMatches().forEach(entityMatch -> System.out.printf(
                    "Matched entity: %s, confidence score: %f.%n",
                    entityMatch.getText(), entityMatch.getConfidenceScore()));
        });

    }
}