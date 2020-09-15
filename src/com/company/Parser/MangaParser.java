package com.company.Parser;

import com.company.model.Manga;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>class MangaParser</h1>
 * Made to parse the json info as an manga list
 * <p>
 * @version 1.0
 * @since 2020-09-14
 *
 * Version 1.0
 *  - added parseJson(string), returns mangalist
 */

public class MangaParser {
    public static List<Manga> parseJson(String json){
        JSONObject retorno = new JSONObject(json);
        JSONArray animesJson = retorno.getJSONArray("results");
        List<Manga> mangaList = new ArrayList<>();
        for (Object manga :
                animesJson) {
            mangaList.add(new Manga(
                    ((JSONObject)manga).getString("title"),
                    ((JSONObject)manga).getString("image_url"),
                    ((JSONObject)manga).getString("synopsis"),
                    ((JSONObject)manga).getInt("chapters"),
                    ((JSONObject)manga).getInt("episodes"),
                    ((JSONObject)manga).getFloat("score")
            ));
        }
        return mangaList;
    }
}
