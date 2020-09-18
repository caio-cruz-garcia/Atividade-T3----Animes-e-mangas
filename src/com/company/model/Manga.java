package com.company.model;

import com.company.enums.MangaTypes;

/**
 * The class used to represent the Manga.
 *
 * @version 1.3
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
 *      - Added enum MangaTypes for the class
 *      - Added getter and setters for enum MangaTypes
 *
 * Version 1.2
 *      - Added getAll()
 *
 * Version 1.3
 *      - Added "volumes" to getAll()
 */

public class Manga {
    private String name;
    private String url;
    private String synopsis;
    private int chapters;
    private int volumes;
    private MangaTypes types;
    private float score;

    /**
     * Constructor which immediately creates an manga instance.
     * @param name Name of the manga
     * @param url Url to the poster
     * @param synopsis Synopsis of what it is about
     * @param chapters Total number of chapters
     * @param volumes Total number of volumes
     * @param types The type this manga is
     * @param score How well rated it is.
     */
    public Manga(String name, String url, String synopsis, int chapters, int volumes,  MangaTypes types, float score) {
        this.name = name;
        this.url = url;
        this.synopsis = synopsis;
        this.chapters = chapters;
        this.volumes = volumes;
        this.types = types;
        this.score = score;
    }

    /**
     * @return name of manga
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Sets a new name for the manga
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return url of the manga
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url Sets a new url for the manga
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return Return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     *
     * @param synopsis Sets a new Synopsis for the manga
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     *
     * @return Return the number of chapters
     */
    public int getChapters() {
        return chapters;
    }

    /**
     *
     * @param chapters Sets a new number of chapters for the manga
     */
    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    /**
     *
     * @return Return the number of volumes
     */
    public int getVolumes() {
        return volumes;
    }

    /**
     *
     * @param volumes Set a new number of volumes for the manga
     */
    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    /**
     *
     * @return Return the type of the manga as its own enum
     */
    public MangaTypes getTypes() {
        return types;
    }

    /**
     *
     * @return Return the type of the manga as a string
     */
    public String getTypesString() {
        return ""+types;
    }

    /**
     *
     * @param types (Enum) Set a new type for the manga
     */
    public void setTypes(MangaTypes types) {
        this.types = types;
    }

    /**
     *
     * @return Returns the score of the manga
     */
    public float getScore() {
        return score;
    }

    /**
     *
     * @param score Set a new score for the manga
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * Output all data of the manga at once.
     */
    public void getAll(){
        System.out.println("Title.: " + name);
        System.out.println("Poster.: " + url);
        System.out.println("Synopsis.: " + synopsis);
        System.out.println("Chapters.: " + chapters);
        System.out.println("Volumes.: " + volumes);
        System.out.println("Types.: " + types);
        System.out.println("Score.: " + score);
    }
}
