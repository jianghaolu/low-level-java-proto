package com.azure.ai.textanalytics;

import java.util.Scanner;

public class TextAnalyticsUserStudy {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        task1();
        System.out.println("Task 2:");
        task2();
        System.out.println("Task 3:");
        task3();
        System.out.println("Task 4:");
        task4();
        System.out.println("Task 5:");
        task5();
    }

    // Task 1: You are provided with a data set of raw movie reviews in english from IMDB in a JSON format
    // in the file named [C:\\study\\reviews_english.json].
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
        System.out.println("5) How this API feels compared to Rest API's you've used in the past:");
        System.out.println("");
        System.out.println("6) How this API feels compared to other Azure SDK API's you've used in the past:");
        System.out.println("");
        System.out.println("7) What do you think about provided documentation:");
        System.out.println("");
        System.out.println("8) What do you think about IntelliSense documentation:");
        System.out.println("");
    }

    private static String readEnglishReviews() {
        Scanner s = new Scanner(TextAnalyticsUserStudy.class.getResourceAsStream("/reviews_english.json")).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
