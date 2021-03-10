package com.azure.ai.textanalytics;

import com.azure.core.credential.AzureKeyCredential;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    // Task 2: You are provided with a data set of movie reviews in english from IMDB.
    // You have a helper method readEnglishReviews() that reads the data for you.
    // Use text analytics services and detect the sentiment of each review and print out the result to the console
    // “review 2 is [positive/mixed/negative]”.
    private static void task2() {
    }

    // Task 3: You are provided with a set of models in the azure-ai-textanalytics-models/src/main/java directory.
    // Use the models there to complete the previous task.
    private static void task3() {

    }

    // Task 4: You are provided with a data set of movie reviews in mixed languages from IMDB.
    // You have a helper method readMixedLanguageReviews() that reads the data for you.
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

    private static List<String> readEnglishReviews() {
        return Arrays.asList(
                "My wife Theresa Kaplan really likes this Stranger Things mystery, in the hands of its directors, the Duffer Brothers, is at turns touching and harriwing",
                "This is an example of why the majority of action films are the same. Generic and boring, there's really nothing worth watching here. A complete waste of the then barely-tapped talents of Ice-T and Ice Cube, who've each proven many times over that they are capable of acting, and acting well. Don't bother with this one, go see New Jack City",
                "Not even the Beatles could write songs everyone liked, and although Walter Hill is no mop-top he's second to none when it comes to thought provoking action movies.",
                "Being a long-time fan of Japanese film, I expected more than this. I can't really be bothered to write to much, as this movie is just so poor. ",
                "Wealthy horse ranchers in Buenos Aires have a long-standing no-trading policy with the Crawfords of Manhattan, but what happens when the mustachioed Latin son falls for a certain Crawford with bright eyes, blonde hair, and some perky moves on the dance floor? 20th Century-Fox musical has a glossy veneer yet seems a bit tatty around the edges. It is very heavy on the frenetic, gymnastic-like dancing",
                "Cage plays a drunk and gets high critically praise. Elizabeth Shue Actually has to do a love seen with the most unattractive and overrated piece of dung flesh in Hollywood. I literally vomited while watching this film. Of course I had the flu, but that does not mean this film did not contribute to the vomit in the kamode.",
                "New York family is the last in their neighborhood to get a television set, which nearly ruins David Niven's marriage to Mitzi Gaynor.",
                "I really love the Die Hard, probably the best movie of all times. I watched it back in Spain in horrible translation, but still loved it",
                "arb & Star Go to Vista Del Mar took us by surprise like a benevolent water spirit, a reference you'll get if you watch this truly zany comedy from the minds of Kristen Wiig and Annie Mumolo, who also star as the titular Barb and Star, best friends who decide to leave their little Nebraska town for a vacation in the fictional Floridian paradise of Vista Del Mar.",
                "In Lee Isaac Chung's Minari, a grandma arrives from Korea carrying seeds to grow a minari plant, a delicious tasting water dropwort that spreads like a weed in marshy spaces. Just where crops and people can grow and thrive is on this gorgeous film's mind. "
        );
    }

    private static List<String> readMixedLanguageReviews() {
        return Arrays.asList(
                "My wife Theresa Kaplan really likes this Stranger Things mystery, in the hands of its directors, the Duffer Brothers, is at turns touching and harriwing.",
                "所有的喜剧演员都很搞笑。 我以前曾在Comedy Central上看到过它们，但是将它们融合在一起是一个好主意。 我爱亚马逊Prime，也喜欢他们的表演。 它们比Netflix好得多。 我摆脱了我的Netflix Amazon摇滚和Netflix百里香与岩石的结合，但是方式很糟糕",
                "Matt Damon and director Alexander Payne squander the comic potential of this unwieldy high-concept satire in the Downsizing , it was a joy to laugh after losing my father John Smith whom I was a caregiver for",
                "Emily obviously a low-budget film but the story got me caught-up in the film .. it felt like a real story that many of us get caught-up in .. the role religion plays in marriage relationship & what happens if one in the couple figures out they really only follow that faith because the spouse believes not them. I know several couples who have struggled with this but they were NOT able to keep the marriage together. I liked the honesty & transperancy of the story. Definitely worth your time to watch .. ",
                "Я люблю сериал Друзья, смотрю снова и снова",
                "Is it based on Friends, liked the show, but too long for my taste, not going to watch again",
                "Mi programa favorito en estos días es The Boys, ofrece una nueva perspectiva y acción, también divertido",
                "The Backyardigans is probably the most anoying show I ever watched, especially I hate the music",
                "Once upon a time in Hollywood is such an unexpected and great moovie, too bad I was not able to watch it at as my credit card (1233 3233 3455 55) was declined. Could you confirm why? My name is Danny Froom"
        );
    }
}
