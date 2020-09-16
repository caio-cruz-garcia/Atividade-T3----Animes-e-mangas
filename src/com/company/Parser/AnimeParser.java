package com.company.Parser;

import com.company.model.Anime;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Made to parse the json info as an anime list
 * @version 1.0
 * @since 2020-09-14
 */

/* Version 1.0
 *      - added parseJson(string), returns animelist
 */

public class AnimeParser {

    /**
     * The method used to parse the anime info, obtained in the website, into a list of animes
     * @param json Takes JSON to convert
     * @return a list of animes
     */
    public static List<Anime> parseJson(String json){
        JSONObject retorno = new JSONObject(json);
        JSONArray animesJson = retorno.getJSONArray("results");
        List<Anime> animeList = new ArrayList<>();
        for (Object anime :
                animesJson) {
            animeList.add(new Anime(
                    ((JSONObject)anime).getString("title"),
                    ((JSONObject)anime).getString("image_url"),
                    ((JSONObject)anime).getString("synopsis"),
                    ((JSONObject)anime).getInt("episodes"),
                    ((JSONObject)anime).getFloat("score")
            ));
        }
        return animeList;
    }
}
