package com.company.tests;

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

        System.out.println("Status Code:" + response.statusCode());
        System.out.println("Body:" + response.body());
        return response.body();
    }

    public static void main(String[] args) throws Exception {
        String theUrl ="https://api.jikan.moe/v3/search/anime?q=Fate/Zero&page=1";
        try {
            String output = apiTest(theUrl);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
