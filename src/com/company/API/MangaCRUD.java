package com.company.API;

import com.company.Parser.AnimeParser;
import com.company.Parser.MangaParser;
import com.company.model.Manga;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

/**
 * <h1>Class AnimeCRUD</h1>
 * CRUD for Anime. Contains a variety of methods made to make usage easier
 * <p>
 * <br>
 *     Version 1.0
 *     - Created class
 *     - Implemented CRUD<Manga> and CRUDFields
 *     - Added comment as javadoc
 *     - method getLink() updated
 *     - method getByName() updated
 *     - method getByGenre() updated
 *     - method getByType() updated
 *
 *
 * @version 1.0
 * @since 2020-09-15
 */
public class MangaCRUD implements CRUD, CRUDFields<Manga> {
    /**
     * method get()
     * Takes a string for the name, return a list of anime found
     * @param condition Anime name to search
     * @return List of anime
     * @throws Exception
     */
    @Override
    public String get(String condition) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create(condition)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /**
     * method getLink
     * Used to store the link for the api
     * @return
     */
    @Override
    public String getLink() {
        return "https://api.jikan.moe/v3/search/manga";
    }

    /**
     * method getByName
     * Takes the name and returns a list of mangas that have the same name
     * @param name String that contains the name to search
     * @return return string
     */
    @Override
    public List<Manga> getByName(String name) {
        try {
            List<Manga> output = MangaParser.parseJson(get(getLink() + "?q=" + name));
            return output;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * method getByGenre
     * Takes the name and returns a list of mangas that have the same name, using genre as an extra filter
     * @param name String that contains the name to search
     * @param genre String that contains the genre to search
     * @return returns string
     */
    @Override
    public List<Manga> getByGenre(String name, String genre) {
        try {
            List<Manga> output = MangaParser.parseJson(get(getLink() + "?q=" + name + "?genre=" + genre));
            return output;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * method getByType
     * Takes the name and returns a list of mangas that have the same name, using type as an extra filter
     * @param name String that contains the name to search
     * @param type String that contains the type to search
     * @return returns string
     */
    @Override
    public List<Manga> getByType(String name, String type) {
        try {
            List<Manga> output = MangaParser.parseJson(get(getLink() + "?q=" + name + "?type=" + type));
            return output;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
