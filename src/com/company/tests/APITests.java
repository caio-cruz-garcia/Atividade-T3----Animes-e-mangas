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
//        String theUrl ="https://api.jikan.moe/v3/search/anime?q=berserk&page=1";
        String theUrl ="https://api.jikan.moe/v3/search/manga?q=berserk";
        try {
            String output = apiTest(theUrl);
//            for (Anime anime: AnimeParser.parseJson(output)) {
            for (Manga manga: MangaParser.parseJson(output)) {
                System.out.println("Anime.:" + manga.getName());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
