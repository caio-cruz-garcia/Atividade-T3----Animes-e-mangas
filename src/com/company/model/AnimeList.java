package com.company.model;

import java.util.ArrayList;
import java.util.List;


/**
 * List for anime
 * @version 1.1
 * @since 2020-09-14
 *
 */
/* Version 1.0
 *     - Created class
 *
 * Version 1.1
 *     - Added private list
 *     - Added method AnimeList
 *     - Added constructor
 *     - Added method addAnime
 *     - Added method getAnimes
 *     - Added toString
 *

 */
public class AnimeList {
    private List<Anime> animes;

    /**
     * Constructor.
     * Creates the list.
     */
    public AnimeList() {
        this.animes = new ArrayList<>();
    }

    /**
     * Add a anime to the list
     * @param anime Anime to add
     */
    public void addAnime(Anime anime){
        this.animes.add(anime);
    }

    /**
     * Returns the list of animes
     * @return List of animes
     */
    public final List<Anime> getAnimes() {
        return this.animes;
    }

    /**
     * Returns the entire list as String
     * @return String
     */
    @Override
    public String toString() {
        return "AnimeList{" +
                "animes=" + animes +
                '}';
    }
}
