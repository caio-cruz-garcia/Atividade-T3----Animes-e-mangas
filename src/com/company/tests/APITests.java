package com.company.tests;

import com.company.Parser.AnimeParser;
import com.company.Parser.MangaParser;
import com.company.model.Anime;
import com.company.model.Manga;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * (TEST CLASS).
 * Class purely made for testing API calls and learning about it's outputs.
 * Should not be considered in the final product.
 */
public class APITests {
    public static String apiTest(String request_url) throws Exception{
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create(request_url)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println("Status Code:" + response.statusCode());
//        System.out.println("Body:" + response.body());
        return response.body();
    }

    public static void main(String[] args) throws Exception {
        String theUrl ="https://api.jikan.moe/v3/search/anime?q=hellgirl"; //%20kei1";
//        String theUrl ="https://api.jikan.moe/v3/search/manga?q=berserk";
        try {
            String output = apiTest(theUrl);
            for (Anime anime: AnimeParser.parseJson(output)) {

//            for (Manga manga: MangaParser.parseJson(output)) {
                System.out.println("-----------------------------");
//                System.out.println("Manga.: " + manga.getName());
//                System.out.println("URL.: " + manga.getUrl());
//                System.out.println("synopsis.: " + manga.getSynopsis());
//                System.out.println("chapters.: " + manga.getChapters());
//                System.out.println("volumes.: " + manga.getVolumes());
//                System.out.println("type.: " + manga.getTypesString());
//                System.out.println("score.: " + manga.getScore());
                System.out.println("Anime.:" + anime.getName());
                System.out.println("URL.: " + anime.getUrl());
                System.out.println("synopsis.: " + anime.getSynopsis());
                System.out.println("volumes.: " + anime.getEpisodes());
                System.out.println("score.: " + anime.getScore());

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
