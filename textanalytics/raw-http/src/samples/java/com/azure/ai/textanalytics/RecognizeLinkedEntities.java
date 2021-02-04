// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics;

import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpRequest;

import java.util.Arrays;
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
        HttpClient httpclient = HttpClient.createDefault();
        try
        {
            String baseUrl = String.format("%s/text/analytics/v3.1-preview.3/entities/linking", "{Endpoint}");
            HttpRequest request = new HttpRequest(HttpMethod.POST, baseUrl);
            request.setHeader("Accept", "application/json, text/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "{ApiKey}");
            request.setBody("{\"documents\":[{\"id\":\"0\",\"text\":\"Old Faithful is a geyser at Yellowstone Park.\"}]}");
            String response = httpclient.send(request).block().getBodyAsString().block();
            Pattern pattern = Pattern.compile("\"entities\": *\\[(.*)(?<!\\[])}]");

            if (response != null) {
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    List<String> entities = Arrays.asList(matcher.group(1).split("},\\{"));
                    entities.forEach(entity -> {
                        Matcher nameMatcher = Pattern.compile("\"name\":\"([^\"]+)\"").matcher(entity);
                        String name = null;
                        if (nameMatcher.find()) {
                            name = nameMatcher.group(1);
                        }
                        Matcher dataSourceMatcher = Pattern.compile("\"dataSource\":\"([^\"]+)\"").matcher(entity);
                        String dataSource = null;
                        if (dataSourceMatcher.find()) {
                            dataSource = dataSourceMatcher.group(1);
                        }
                        Matcher urlMatcher = Pattern.compile("\"url\":\"([^\"]+)\"").matcher(entity);
                        String url = null;
                        if (urlMatcher.find()) {
                            url = urlMatcher.group(1);
                        }
                        Matcher bingIdMatcher = Pattern.compile("\"bingId\":\"([^\"]+)\"").matcher(entity);
                        String bingId = null;
                        if (bingIdMatcher.find()) {
                            bingId = bingIdMatcher.group(1);
                        }
                        System.out.println("Linked Entities:");
                        System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s,"
                                        + " Bing Entity Search API ID: %s.%n",
                                name, dataSource, url, dataSource, bingId);

                        Pattern matchesPattern = Pattern.compile("\"matches\": *\\[([^]]+)]");
                        Matcher matchesMatcher = matchesPattern.matcher(entity);
                        if (matchesMatcher.find()) {
                            List<String> matches = Arrays.asList(matchesMatcher.group(1).split("},\\{"));
                            matches.forEach(entityMatch -> {
                                Matcher textMatcher = Pattern.compile("\"text\":\"([^\"]+)\"").matcher(entityMatch);
                                String text = null;
                                if (textMatcher.find()) {
                                    text = textMatcher.group(1);
                                }
                                Matcher confidenceScoreMatcher = Pattern.compile("\"confidenceScore\":([0-9.]+)").matcher(entityMatch);
                                String confidenceScore = "0";
                                if (confidenceScoreMatcher.find()) {
                                    confidenceScore = confidenceScoreMatcher.group(1);
                                }
                                System.out.printf(
                                        "Matched entity: %s, confidence score: %f.%n",
                                        text, Double.parseDouble(confidenceScore));
                            });
                        }
                    });
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}