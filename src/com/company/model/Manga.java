package com.company.model;

import com.company.enums.MangaTypes;

/**
 * <h1>class Manga</h1>
 * The class used to represent the Manga.
 *
 * @version 1.2
 * @since 2020-09-14
 *
 * Version 1.0
 *  - created class
 *  - added variables
 *  - added getters and setters
 *  - added constructor
 *
 * Version 1.1
 *  - Added enum MangaTypes for the class
 *  - Added getter and setters for enum MangaTypes
 *
 * Version 1.2
 *  - Added getAll()
 */

public class Manga {
    private String name;
    private String url;
    private String synopsis;
    private int chapters;
    private int volumes;
    private MangaTypes types;
    private float score;

    public Manga(String name, String url, String synopsis, int chapters, int volumes,  MangaTypes types, float score) {
        this.name = name;
        this.url = url;
        this.synopsis = synopsis;
        this.chapters = chapters;
        this.volumes = volumes;
        this.types = types;
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

    public MangaTypes getTypes() {
        return types;
    }

    public String getTypesString() {
        return ""+types;
    }

    public void setTypes(MangaTypes types) {
        this.types = types;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void getAll(){
        System.out.println("Title.: " + name);
        System.out.println("Poster.: " + url);
        System.out.println("Synopsis.: " + synopsis);
        System.out.println("Chapters.: " + chapters);
        System.out.println("Types.: " + types);
        System.out.println("Score.: " + score);
    }
}
