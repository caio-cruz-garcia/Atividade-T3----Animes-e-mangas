package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * List for manga.
 * @version 1.0
 * @since 2020-09-15
 */
/* Version 1.0
 *     - Created class
 *
 * Version 1.1
 *     - Added private list
 *     - Added method mangaList
 *     - Added constructor
 *     - Added method addManga
 *     - Added method getMangas
 *     - Added toString
 *

 */
public class MangaList {
    private List<Manga> mangas;

    /**
     * initialize an arraylist for the class
     */
    public MangaList() {
        this.mangas = new ArrayList<>();
    }

    /**
     * Add a Manga to the list
     * @param manga Manga to add
     */
    public void addManga(Manga manga){
        this.mangas.add(manga);
    }

    /**
     * Returns the list of Mangas
     * @return List of Mangas
     */
    public final List<Manga> getMangas() {
        return this.mangas;
    }

    /**
     * Returns the entire list as String
     * @return String
     */
    @Override
    public String toString() {
        return "MangaList{" +
                "mangas=" + mangas +
                '}';
    }
}
