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

## Troubleshooting

## Next steps

## Contributing

This project welcomes contributions and suggestions. Most contributions require you to agree to a Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us the rights to use your contribution. For details, visit https://cla.microsoft.com.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide a CLA and decorate the PR appropriately (e.g., label, comment). Simply follow the instructions provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct][code_of_conduct]. For more information see the [Code of Conduct FAQ][code_of_conduct_faq] or contact opencode@microsoft.com with any additional questions or comments.

[code_of_conduct]: https://opensource.microsoft.com/codeofconduct
[code_of_conduct_faq]: https://opensource.microsoft.com/codeofconduct/faq/
