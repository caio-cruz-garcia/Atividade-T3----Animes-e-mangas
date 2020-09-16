package com.company.enums;

/**
 * Known anime types. While not used for the Anime itself, it is used in the CRUD searches.
 * @deprecated
 * @version 1.0
 * @since 2020-09-14
 */
public enum AnimeTypes {
    TV("TV"),
    OVA("OVA"),
    MOVIE("Movie"),
    SPECIAL("Special"),
    ONA("ONA"),
    MUSIC("Music");

    private String display;
    AnimeTypes(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }
}