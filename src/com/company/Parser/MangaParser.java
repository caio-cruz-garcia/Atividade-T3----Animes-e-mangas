package com.company.Parser;

import com.company.model.Manga;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Made to parse the json info as an manga list
 * @version 1.0
 * @since 2020-09-15
 */

/* Version 1.0
 *      - added parseJson(string), returns mangalist
 *      - added MangaTypesParser
 */

public class MangaParser {

    /**
     * The method used to parse the manga info, obtained in the website, into a list of mangas
     * @param json Takes JSON to convert
     * @return a list of mangas
     */
    public static List<Manga> parseJson(String json){
        JSONObject retorno = new JSONObject(json);
        JSONArray mangasJson = retorno.getJSONArray("results");
        List<Manga> mangaList = new ArrayList<>();
        for (Object manga :
                mangasJson) {
            mangaList.add(new Manga(
                    ((JSONObject)manga).getString("title"),
                    ((JSONObject)manga).getString("image_url"),
                    ((JSONObject)manga).getString("synopsis"),
                    ((JSONObject)manga).getInt("chapters"),
                    ((JSONObject)manga).getInt("volumes"),
                    MangaTypesParser.toTypes(((JSONObject)manga).getString("type")),
                    ((JSONObject)manga).getFloat("score")
            ));
        }
        return mangaList;
    }
}
