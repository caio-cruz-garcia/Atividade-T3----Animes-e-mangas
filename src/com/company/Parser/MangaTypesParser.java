package com.company.Parser;

import com.company.enums.MangaTypes;

/**
 * <h1>Class MangaTypesParser</h1>
 * Parses a string and returns the correct enum type.
 * @version 1.0
 * @since 2020-09-15
 */
public class MangaTypesParser {
    public static MangaTypes toTypes(String types){
        if(types.equals("novel")) return MangaTypes.NOVEL;
        if(types.equals("oneshot")) return MangaTypes.ONESHOT;
        if(types.equals("doujin")) return MangaTypes.DOUJIN;
        if(types.equals("manhwa")) return MangaTypes.MANHWA;
        if(types.equals("manhua")) return MangaTypes.MANHUA;
        else return MangaTypes.MANGA;
    }
}