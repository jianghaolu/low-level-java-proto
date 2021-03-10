package com.azure.ai.textanalytics;

import com.azure.core.credential.AzureKeyCredential;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.Scanner;

public class TextAnalyticsUserStudy {
    private static final TextAnalyticsClient client = new TextAnalyticsClientBuilder()
            .endpoint(System.getenv("AZURE_COGNITIVE_SERVICES_ENDPOINT"))
            .credential(new AzureKeyCredential(System.getenv("AZURE_COGNITIVE_SERVICES_KEY")))
            .build();

    private static String readEnglishReviews() {
        Scanner s = new Scanner(TextAnalyticsUserStudy.class.getResourceAsStream("/reviews_english.json")).useDelimiter("\\A");
        String content = s.hasNext() ? s.next() : "";
        return content.replaceAll("\r?\n", "").replaceAll("\t", "");
    }

    public static void main(String[] args) {
        System.out.println("Task 1:");
        task1();
        System.out.println("Task 2:");
        task2();
        System.out.println("Task 3:");
        task3();
        System.out.println("Task 4:");
        task4();
    }

    // Task 1: You are provided with a data set of raw movie reviews in english from IMDB in a JSON format
    // in the file named [resources\\reviews_english.json].
    // Please use text analytics API to perform analysis on the first 10 reviews.
    // You have a helper method available that reads the data from the input JSON for you.
    // Use text analytics services and detect whether a review is positive or not positive and print out the result to the console
    // “review 2 is [positive/not positive]”.
    private static void task1() {
    }

    // Task 2: Take the first 10 reviews. For words or phrases in those reviews that can be categorized as a Person, Location, or Organization,
    // identify whether they are a person, location, or organization.
    // Print the phrase found in text and its category, e.g.Kurt Russell is a Person.
    private static void task2() {
        JsonReader jsonReader = Json.createReader(new StringReader(readEnglishReviews()));
        JsonArray reviews = jsonReader.readArray();
        for (int i = 0; i < 10; i++) {
            JsonObject review = reviews.get(i).asJsonObject();
            String text = review.getString("text");
            JsonObject request = Json.createObjectBuilder().add("documents", Json.createArrayBuilder()
                    .add(Json.createObjectBuilder().add("id", "0").add("text", text).add("language", "en").build())
                    .build()).build();
            String response = client.getEntities()
                    .setBody(request.toString())
                    .send()
                    .getBody()
                    .toString();

            JsonArray entities = Json.createReader(new StringReader(response)).readObject().getJsonArray("documents").get(0).asJsonObject().getJsonArray("entities");
            System.out.println("Review " + (i+1) + ":");
            entities.forEach(entity -> {
                System.out.println("\t" + entity.asJsonObject().getString("text") + " is a " + entity.asJsonObject().getString("category"));
            });
        }
    }

    // Task 3: Take 10 reviews. Detect Person entities that may have entries in the Wikipedia and print all associated hyperlinks to the console
    private static void task3() {

    }

    // Task 4: You are provided with a set of models in the azure-ai-textanalytics-models directory.
    // Use the models there to complete task 3.
    private static void task4() {

    }

    // Task 5: Feedback
    private static void task5() {
        System.out.println("1) How did you like this API on scale 1-5, where 1 is liked the least and 5 = liked the most");
        System.out.println("");
        System.out.println("2) What do you find frustrating or unappealing about this API");
        System.out.println("");
        System.out.println("3) What did you like about this API:");
        System.out.println("");
        System.out.println("4) Suggest 1 thing to improve, that would have the most impact on your experience");
        System.out.println("");
        System.out.println("5) How is this API compared to Rest API's you've used in the past:");
        System.out.println("");
        System.out.println("6) How is this API compared to other Azure SDK API's you've used in the past:");
        System.out.println("");
        System.out.println("7) What do you think about the provided documentation:");
        System.out.println("");
        System.out.println("8) What do you think about IntelliSense documentation:");
        System.out.println("");
    }
}
