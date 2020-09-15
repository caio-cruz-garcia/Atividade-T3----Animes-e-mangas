package com.company.enums;

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
