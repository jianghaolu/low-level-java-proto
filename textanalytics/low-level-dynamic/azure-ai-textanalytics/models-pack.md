# Azure REST Bindings for Azure Cognitive Services Text Analytics client library for Java - Models pack

A models-pack contains all the models you may use to conveniently serialize and deserialize JSON objects required for the APIs. To serialize and deserialize JSON objects, you will need to add a dependency to your classpath:

```xml
<dependency>
  <groupId>com.azure</groupId>
  <artifactId>azure-core-serializer-json-jackson</artifactId>
  <version>1.0.2</version>
</dependency>
```

You will then be able to pass the request model directly to the `setBody(Object)` method on `DynamicRequest`, and deserialize a `BinaryData` directly to the response model:

```java
TextAnalyticsClient client = new TextAnalyticsClientBuilder()
    .credential(new AzureKeyCredential("{ApiKey}"))
    .endpoint("{Endpoint}")
    .build();

MultiLanguageInput input = new MultiLanguageInput()
    .setId("0").setText("Old Faithful is a geyser at Yellowstone Park.");
MultiLanguageBatchInput batchInput = new MultiLanguageBatchInput().setDocuments(Collections.singletonList(input));

EntityLinkingResult result = client.getLinkedEntities() // DynamicRequest
    .setBody(batchInput) // DynamicRequest
    .send()  // DynamicResponse
    .getBody() // BinaryData
    .toObject(EntityLinkingResult.class);
```