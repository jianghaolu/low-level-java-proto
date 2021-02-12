// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.models.DocumentLinkedEntities;
import com.azure.ai.textanalytics.models.EntityLinkingResult;
import com.azure.ai.textanalytics.models.MultiLanguageBatchInput;
import com.azure.ai.textanalytics.models.MultiLanguageInput;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.ProxyOptions;
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import com.azure.core.util.Context;

import java.net.InetSocketAddress;
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
        TextAnalyticsModelClient client = (TextAnalyticsModelClient) new TextAnalyticsClientBuilder()
                .credential(new AzureKeyCredential("{ApiKey}"))
                .endpoint("{Endpoint}")
                .httpClient(new NettyAsyncHttpClientBuilder().proxy(new ProxyOptions(ProxyOptions.Type.HTTP, new InetSocketAddress("localhost", 8888))).build())
                .build();

        MultiLanguageInput input = new MultiLanguageInput()
                .setId("0").setText("Old Faithful is a geyser at Yellowstone Park.");
        MultiLanguageBatchInput batchInput = new MultiLanguageBatchInput().setDocuments(Collections.singletonList(input));

        EntityLinkingResult result = client.entitiesLinking() // RequestSpec
                .body(batchInput) // RequestSpec
                .context(Context.NONE) // RequestSpec
                .invoke()  // ResponseSpec
                .asEntityLinkingResult() // Mono<EntityLinkingResponse>
                .block();

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