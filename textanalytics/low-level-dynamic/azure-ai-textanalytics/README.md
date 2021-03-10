# Azure REST Bindings for Azure Cognitive Services Text Analytics client library for Java

azure-ai-textanalytics-protocol is an experimental library for interacting directly with the REST endpoints for the Azure Cognitive Services Text Analytics service.

At this time, if you are looking to interact with the Azure Cognitive Services Text Analytics service, we recommend using the officially supported [Azure.AI.TextAnalytics](https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/textanalytics/azure-ai-textanalytics) library.

## Getting started

### Install the package

### Prerequisites

### Authenticate the client

To create the client, you can use an `AzureKeyCredential`, with your API Key:

```java
TextAnalyticsClient client = new TextAnalyticsClientBuilder()
        .credential(new AzureKeyCredential("{api key from portal}"))
        .endpoint("{endpoint from portal}")
        .build();
```

## Key concepts

Operations on the Text Analytics client consume and produce JSON data. Instead of representing the input and output for an operation with a specific type, the general purpose `JsonData` type is used. `JsonData` makes it easy to build and consume JSON payloads. You can use the [service documentation](https://westus2.dev.cognitive.microsoft.com/docs/services/TextAnalytics-v3-1-preview-1/operations/Languages) to understand the contents of the JSON payloads sent as part of a request or response.  The service exposes the following operations:

- [Detect Language](https://westus2.dev.cognitive.microsoft.com/docs/services/TextAnalytics-v3-1-preview-1/operations/Languages)
- [Entities containing personal information](https://westus2.dev.cognitive.microsoft.com/docs/services/TextAnalytics-v3-1-preview-1/operations/EntitiesRecognitionPii)
- [Key Phrases](https://westus2.dev.cognitive.microsoft.com/docs/services/TextAnalytics-v3-1-preview-1/operations/KeyPhrases)
- [Linked entities from a well known knowledge base](https://westus2.dev.cognitive.microsoft.com/docs/services/TextAnalytics-v3-1-preview-1/operations/EntitiesLinking)
- [Named Entity Recognition](https://westus2.dev.cognitive.microsoft.com/docs/services/TextAnalytics-v3-1-preview-1/operations/EntitiesRecognitionGeneral)
- [Sentiment](https://westus2.dev.cognitive.microsoft.com/docs/services/TextAnalytics-v3-1-preview-1/operations/Sentiment)

### DynamicRequest/DynamicResponse

`DynamicRequest` and `DynamicResponse` are designed for interacting with the REST APIs. All the APIs in `TextAnalyticClient` return a `DynamicRequest` where you can call `send()` or `sendAsync()` to get a `DynamicResponse`.

You can set path parameters, query parameters, headers, and the request body on a `DynamicRequest` object. You can serialize the request body into a String with your preferred serializer and call `.setBody(String)` or use a JSON serializer by calling `.setBody(Object)`.

Once you have a `DynamicResponse` you can get the response status code, headers, and the response body. The response body is returned as a `BinaryData` where you can get the String value and deserialize with your preferred serializer.
 
For example the client has the following API method:

| Name                  | Returns                 | Description                                                               |
|-----------------------|-------------------------|---------------------------------------------------------------------------|
| `getSentiment` | `DynamicRequest`        | Returns a `DynamicRequest` which can be modified and then sent.           |

We can call this API which determines if text is positive or negative. In the following example, we are using [JSON-P](https://javaee.github.io/jsonp/getting-started.html) to build and parse the JSON objects.

```java Snippet:DynamicRequestAndResponse
JsonObject document = Json.createObjectBuilder()
    .add("id", "0")
    .add("text", "Great atmosphere. Close to plenty of restaurants, hotels, and transit! Staff are friendly and helpful.")
    .add("language", "en")
    .build();

JsonObject batchInput = Json.createObjectBuilder()
    .add("documents", Json.createArrayBuilder().add(document).build())
    .build();

DynamicRequest req = client.getSentiment().setBody(batchInput.toString());
DynamicResponse res = req.send();

if (res.getStatusCode() != 200 /*OK*/)
{
    // The call failed for some reason, log a message
    System.out.println(String.format("Requested Failed with status %s: %s", res.getStatusCode(), res.getBody().toString()));
}
else
{
    String responseBody = res.getBody().toString();
    JsonObject deserialized = Json.createReader(new StringReader(responseBody)).readObject();
    System.out.println(String.format("Sentiment of document is %s", deserialized.getJsonArray("documents").get(0).asJsonObject().getString("sentiment")));
}
```

**Note**: You must explicitly check the Status value on the response to understand if the operation was successful. The methods which send a request **do not** throw an exception if the service returns a non 2XX HTTP Status Code.

### BinaryData

`BinaryData` is a class designed to help users parse response bodies into strings, byte arrays, InputStreams, and model type objects.

```java
// build DynamicRequest
DynamicResponse res = req.send();
BinaryData body = res.getBody();
String bodyString = body.toString();
byte[] bodyByteArray = body.toBytes();
InputStream bodyInputStream = body.toStream();
```

## Examples

### Detect Language

```Java Snippet:DetectLanguagesSample
TextAnalyticsClient client = new TextAnalyticsClientBuilder()
    .credential(new AzureKeyCredential("<api-key>"))
    .endpoint("<endpoint>")
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
```

## Troubleshooting

## Next steps

## Contributing

This project welcomes contributions and suggestions. Most contributions require you to agree to a Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us the rights to use your contribution. For details, visit https://cla.microsoft.com.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide a CLA and decorate the PR appropriately (e.g., label, comment). Simply follow the instructions provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct][code_of_conduct]. For more information see the [Code of Conduct FAQ][code_of_conduct_faq] or contact opencode@microsoft.com with any additional questions or comments.

[code_of_conduct]: https://opensource.microsoft.com/codeofconduct
[code_of_conduct_faq]: https://opensource.microsoft.com/codeofconduct/faq/