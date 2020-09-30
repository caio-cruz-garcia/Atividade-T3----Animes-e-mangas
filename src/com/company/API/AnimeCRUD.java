package com.company.API;

import com.company.Parser.AnimeParser;
import com.company.model.Anime;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

/**
 * CRUD for Anime. Contains a variety of methods made to make usage easier
 * @version 1.2
 * @since 2020-09-15
 *
 */

/* Version 1.0
 *     - Created class
 *     - Implemented CRUD<Anime> and CRUDFields
 *     - Added comment as javadoc
 *     - method getLink() updated
 *     - method getByName() updated
 *     - method getByGenre() updated
 *     - method getByType() updated
 *     - method create() updated
 *     - method read() updated
 *     - method update() updated
 *     - method delete() updated
 *     - method get() updated
 *
 * Version 1.1
 *     - method create() deleted
 *     - method read() deleted
 *     - method update() deleted
 *     - method delete() deleted
 *     - method delete() deleted
 *     - method getByName() updated
 *     - method getByGenre() updated
 *     - method getByType() updated
 *
 * Version 1.2
 *     - method getByName() updated
 *          - Shortened
 *     - method getByGenre() updated
 *          - Shortened
 *     - method getByType() updated
 *          - Shortened
 *
 */
public class AnimeCRUD implements CRUD, CRUDFields<Anime> {

    /**
     * Takes a string for the name, return a list of anime found
     * @param condition Anime name to search
     * @return List of anime
     * @throws Exception Throws exception
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
     * Used to store the link for the api
     * @return String with the basic API link
     */
    @Override
    public String getLink() {
        return "https://api.jikan.moe/v3/search/anime";
    }

    /**
     * Takes the name and returns a list of animes that have the same name
     * @param name String that contains the name to search
     * @return return string
     */
    @Override
    public List<Anime> getByName(String name) {
        try {
            return AnimeParser.parseJson(get(getLink() + "?q=" + name));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Takes the name and returns a list of animes that have the same name, using genre as an extra filter
     * @param name String that contains the name to search
     * @param genre String that contains the genre to search
     * @return returns string
     */
    @Override
    public List<Anime> getByGenre(String name, String genre) {
        try {
            return AnimeParser.parseJson(get(getLink() + "?q=" + name + "?genre=" + genre));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Takes the name and returns a list of animes that have the same name, using type as an extra filter
     * @param name String that contains the name to search
     * @param type String that contains the type to search
     * @return returns string
     */
    @Override
    public List<Anime> getByType(String name, String type) {
        try {
            return AnimeParser.parseJson(get(getLink() + "?q=" + name + "?type=" + type));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
