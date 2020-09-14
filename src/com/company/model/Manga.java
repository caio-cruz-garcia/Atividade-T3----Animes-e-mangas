package com.company.model;

/**
 * <h1>class Manga</h1>
 * The class used to represent the Manga.
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

public class Manga {
    private String name;
    private String url;
    private String synopsis;
    private int chapters;
    private int volumes;
    private float score;

    public Manga(String name, String url, String synopsis, int chapters, int volumes, float score) {
        this.name = name;
        this.url = url;
        this.synopsis = synopsis;
        this.chapters = chapters;
        this.volumes = volumes;
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

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
