package com.company.Parser;

import com.company.enums.MangaTypes;

/**
 * Parses a string and returns the correct enum type.
 * @version 1.1
 * @since 2020-09-15
 */

/*
 * Version 1.0
 *      - Added possible types
 *
 *  Version 1.1
 *      - Fixed the "types.equal" by capitalizing each letter
 */
public class MangaTypesParser {
    public static MangaTypes toTypes(String types){
        if(types.equals("Novel")) return MangaTypes.NOVEL;
        if(types.equals("Oneshot")) return MangaTypes.ONESHOT;
        if(types.equals("Doujin")) return MangaTypes.DOUJIN;
        if(types.equals("Manhwa")) return MangaTypes.MANHWA;
        if(types.equals("Manhua")) return MangaTypes.MANHUA;
        else return MangaTypes.MANGA;
    }
}