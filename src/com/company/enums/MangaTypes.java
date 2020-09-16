package com.company.enums;

/**
 * Known manga types
 * @version 1.0
 * @since 2020-09-14
 */
public enum MangaTypes {
    MANGA("manga"),
    NOVEL("novel"),
    ONESHOT("oneshot"),
    DOUJIN("doujin"),
    MANHWA("manhwa"),
    MANHUA("manhua");



    private String display;
    MangaTypes(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }
}
