// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.anomalydetector;

import com.azure.ai.anomalydetector.models.DetectRequest;
import com.azure.ai.anomalydetector.models.EntireDetectResponse;
import com.azure.ai.anomalydetector.models.TimeGranularity;
import com.azure.ai.anomalydetector.models.TimeSeriesPoint;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.ContentType;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.ProxyOptions;
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import com.azure.core.http.policy.AddHeadersPolicy;
import com.azure.core.http.policy.AzureKeyCredentialPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sample for detecting anomalies in a piece of time series.
 */
public class DetectAnomaliesEntireSeries {

    /**
     * Main method to invoke this demo.
     *
     * @param args Unused arguments to the program.
     */
    public static void main(final String[] args) {
        String endpoint = "{endpoint}";
        String key = "{key}";
        HttpHeaders headers = new HttpHeaders()
            .put("Accept", ContentType.APPLICATION_JSON);

        HttpPipelinePolicy authPolicy = new AzureKeyCredentialPolicy("Ocp-Apim-Subscription-Key",
            new AzureKeyCredential(key));
        AddHeadersPolicy addHeadersPolicy = new AddHeadersPolicy(headers);

        HttpPipeline httpPipeline = new HttpPipelineBuilder().httpClient(new NettyAsyncHttpClientBuilder().proxy(new ProxyOptions(ProxyOptions.Type.HTTP, new InetSocketAddress("localhost", 8888))).build())
            .policies(authPolicy, addHeadersPolicy).build();
        // Instantiate a client that will be used to call the service.
        AnomalyDetectorClient anomalyDetectorClient = new AnomalyDetectorClientBuilder()
            .pipeline(httpPipeline)
            .endpoint(endpoint)
            .buildClient();

        // Read the time series from csv file and organize the time series into list of TimeSeriesPoint.
        // The sample csv file has no header, and it contains 2 columns, namely timestamp and value.
        // The following is a snippet of the sample csv file:
        //      2018-03-01T00:00:00Z,32858923
        //      2018-03-02T00:00:00Z,29615278
        //      2018-03-03T00:00:00Z,22839355
        //      2018-03-04T00:00:00Z,25948736
        BufferedReader reader = new BufferedReader(new InputStreamReader(DetectAnomaliesEntireSeries.class.getResourceAsStream("/request-data.csv")));
        List<TimeSeriesPoint> series = reader.lines()
            .map(line -> line.trim())
            .filter(line -> line.length() > 0)
            .map(line -> line.split(",", 2))
            .filter(splits -> splits.length == 2)
            .map(splits -> {
                TimeSeriesPoint timeSeriesPoint = new TimeSeriesPoint();
                timeSeriesPoint.setTimestamp(OffsetDateTime.parse(splits[0]));
                timeSeriesPoint.setValue(Float.parseFloat(splits[1]));
                return timeSeriesPoint;
            })
            .collect(Collectors.toList());

        System.out.println("Detecting anomalies as a batch...");
        DetectRequest request = new DetectRequest();
        request.setSeries(series);
        // Set the granularity to be DAILY since the minimal interval in time of the sample data is one day.
        request.setGranularity(TimeGranularity.DAILY);
        EntireDetectResponse response = anomalyDetectorClient.detectEntireSeries(request);
        if (response.getIsAnomaly().contains(true)) {
            System.out.println("Anomalies found in the following data positions:");
            for (int i = 0; i < request.getSeries().size(); ++i) {
                if (response.getIsAnomaly().get(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("No anomalies were found in the series.");
        }
    }
}
