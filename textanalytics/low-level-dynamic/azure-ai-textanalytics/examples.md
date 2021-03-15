## User study examples

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

### Get Entities

```Java Snippet:GetLinkedEntitiesWithJson
TextAnalyticsClient client = new TextAnalyticsClientBuilder()
    .credential(new AzureKeyCredential("<api-key>"))
    .endpoint("<endpoint>")
    .build();

JsonObject document = Json.createObjectBuilder()
        .add("id", "0")
        .add("text", "Old Faithful is a geyser at Yellowstone Park.")
        .build();

JsonObject batchInput = Json.createObjectBuilder()
        .add("documents", Json.createArrayBuilder().add(document).build())
        .build();

String responseBody = client.getLinkedEntities() // DynamicRequest
        .setBody(batchInput.toString()) // DynamicRequest
        .send()  // DynamicResponse
        .getBody() // BinaryData
        .toString(); // String

JsonObject deserialized = Json.createReader(new StringReader(responseBody)).readObject();

if (deserialized != null && deserialized.containsKey("documents")) {
    JsonArray entities = deserialized.getJsonArray("documents").get(0).asJsonObject().getJsonArray("entities");

    entities.forEach(linkedEntity -> {
        JsonObject entity = linkedEntity.asJsonObject();
        System.out.println("Linked Entities:");
        System.out.printf("Name: %s, entity ID in data source: %s, URL: %s, data source: %s,"
                        + " Bing Entity Search API ID: %s.%n",
                entity.getString("name"), entity.getString("dataSource"), entity.getString("url"),
                entity.getString("dataSource"), entity.getString("bingId"));
        entity.getJsonArray("matches").forEach(entityMatch -> {
            JsonObject match = entityMatch.asJsonObject();
            System.out.printf(
                    "Matched entity: %s, confidence score: %f.%n",
                    match.getString("text"), match.getJsonNumber("confidenceScore").doubleValue());
        });
    });
}
```
