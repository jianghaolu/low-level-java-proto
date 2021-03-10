package com.azure.ai.textanalytics;

import com.azure.core.credential.AzureKeyCredential;

import java.util.Scanner;

public class TextAnalyticsUserStudy {
    private static final TextAnalyticsClient client = new TextAnalyticsClientBuilder()
            .endpoint(System.getenv("AZURE_COGNITIVE_SERVICES_ENDPOINT"))
            .credential(new AzureKeyCredential(System.getenv("AZURE_COGNITIVE_SERVICES_KEY")))
            .build();

    public static void main(String[] args) {
        System.out.println("Task 1:");
        task1("The Backyardigans is probably the most annoying show I ever watched, especially I hate the music");
        System.out.println("Task 2:");
        task2();
        System.out.println("Task 3:");
        task3();
        System.out.println("Task 4:");
        task4();
    }

    // Task 1: You are provided with a movie review from IMDB. Please use text analytics service and detect the
    // sentiment of the review and print out the result to the console "The review is [positive/mixed/negative]".
    private static void task1(String reviewText) {

    }

    // Task 2: You are provided with a data set of movie reviews in english from IMDB in a JSON format
    // in the file named [resources\\reviews_english.json].
    // You have a helper method readEnglishReviews() that reads the data from the input JSON for you.
    // Use text analytics services and detect the sentiment of each review and print out the result to the console
    // “review 2 is [positive/mixed/negative]”.
    private static void task2() {
    }

    // Task 3: You are provided with a set of models in the azure-ai-textanalytics-models/src/main/java directory.
    // Use the models there to complete the previous task.
    private static void task3() {

    }

    // Task 4: You are provided with a data set of movie reviews in mixed languages from IMDB in a JSON format
    // in the file named [resources\\reviews_mixed.json].
    // You have a helper method readMixedLanguageReviews() that reads the data from the input JSON for you.
    // Use text analytics services and get the language of each review and print out the result to the console
    // “review 2 is in [English/Spanish/French]”.
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
        System.out.println("6) What do you think about the provided documentation:");
        System.out.println("");
        System.out.println("7) What do you think about IntelliSense documentation:");
        System.out.println("");
        System.out.println("8) When would you choose to use the JSON based client vs model based client:");
        System.out.println("");
        System.out.println("9) Would you use this client in production:");
        System.out.println("");
    }

    private static String readEnglishReviews() {
        Scanner s = new Scanner(TextAnalyticsUserStudy.class.getResourceAsStream("/reviews_english.json")).useDelimiter("\\A");
        String content = s.hasNext() ? s.next() : "";
        return content.replaceAll("\r?\n", "").replaceAll("\t", "");
    }

    private static String readMixedLanguageReviews() {
        Scanner s = new Scanner(TextAnalyticsUserStudy.class.getResourceAsStream("/reviews_mixed.json")).useDelimiter("\\A");
        String content = s.hasNext() ? s.next() : "";
        return content.replaceAll("\r?\n", "").replaceAll("\t", "");
    }
}
