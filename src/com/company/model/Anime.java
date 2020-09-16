package com.company.model;

/**
 * The class used to represent the anime.
 *
 * @version 1.1
 * @since 2020-09-14
 *
 */

/* Version 1.0
 *      - created class
 *      - added variables
 *      - added getters and setters
 *      - added constructor
 *
 * Version 1.1
 *      - added "getAll" that prints all variables
 *
 */
public class Anime {
    private String name;
    private String url;
    private String synopsis;
    private int episodes;
    private float score;

    /**
     * Constructor for Anime class, already creating with specified values
     * @param name Name of the anime
     * @param url Url of the poster
     * @param synopsis Synopsis of the anime
     * @param episodes Amount of episodes it has
     * @param score Score it has obtained
     */
    public Anime(String name, String url, String synopsis, int episodes, float score) {
        this.name = name;
        this.url = url;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.score = score;
    }

    /**
     *
     * @return Name of the anime
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Set a new name for the anime
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The url of the poster
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url Set a new url for the anime
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return the anime Synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     *
     * @param synopsis Set a new Synopsis for the anime
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     *
     * @return the number of episodes the anime has
     */
    public int getEpisodes() {
        return episodes;
    }

    /**
     *
     * @param episodes Set a new number of episodes for the anime
     */
    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    /**
     *
     * @return the score the anime has
     */
    public float getScore() {
        return score;
    }

    /**
     *
     * @param score Set a new number for the score
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * A method made to output all data the anime has.
     */
    public void getAll(){
        System.out.println("Title.:" + name);
        System.out.println("Poster.:" + url);
        System.out.println("Synopsis.:" + synopsis);
        System.out.println("Episodes.:" + episodes);
        System.out.println("Score.:" + score);
    }
}
