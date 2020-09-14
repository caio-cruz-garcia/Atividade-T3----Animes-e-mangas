package com.company.model;

/**
 * <h1>class Anime</h1>
 * The class used to represent the anime.
 *
 * @version 1.0
 * @since 2020-09-14
 *
 * Version 1.0
 *  - created class
 *  - added variables
 *  - added getters and setters
 *  - added constructor
 *
 */
public class Anime {
    private String name;
    private String url;
    private String synopsis;
    private int episodes;
    private float score;

    public Anime(String name, String url, String synopsis, int episodes, float score) {
        this.name = name;
        this.url = url;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
