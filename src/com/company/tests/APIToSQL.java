package com.company.tests;

import com.company.API.AnimeCRUD;
import com.company.API.MangaCRUD;
import com.company.DAO.AnimeDAO;
import com.company.DAO.MangaDAO;
import com.company.model.Anime;
import com.company.model.AnimeList;
import com.company.model.Manga;

import java.util.List;
import java.util.Scanner;

/**
 * (TEST).
 * This here we'll simulate the attempt at gathering an API and inserting it on the SQL table.
 * Both animes and mangas.
 * Should not be considered in the final product.
 */
public class APIToSQL {
    // First, we'll attempt to simulate a request for looking up at the anime table for an anime called "xxxHOLiCxxx".
    // Since, at the time we're writing this code, it is not there, it will return a 0, indicating that it failed to find it.
    // Therefore code will attempt to locate it via API, bringing multiple examples of possible animes. User will be requested to select a specific one.
    // Once done, it'll add to the table.

    public static void main(String[] args) {
        String goodAnime = "hellgirl";

        String goodManga = "berserk";

        AnimeDAO animeDAO = new AnimeDAO();
        List<Anime> animeList = (animeDAO.get("name LIKE '%" + goodAnime + "%'"));
        AnimeCRUD animeCRUD = new AnimeCRUD();

        MangaDAO mangaDAO = new MangaDAO();
        List<Manga> mangaList = (mangaDAO.get("name LIKE '%" + goodManga + "%'"));
        MangaCRUD mangaCRUD = new MangaCRUD();

        /*
        if (animeList.size() != 0 ){
            System.out.println("Found in database.");
            for (Anime anime: animeList) {
                System.out.println("--------------------------");
                System.out.println("Anime.: " + anime.getName());
                System.out.println("Image.: " + anime.getUrl());
                System.out.println("Synopsis.: " + anime.getSynopsis());
                System.out.println("Score.: " + anime.getScore());

            }

        } else {
            System.out.println("Not found in database. Moving to API call");
            animeList = animeCRUD.getByName(goodAnime);
            Anime anime = selectOne(animeList);
            anime.getAll();
            //animeDAO.create(anime);
        }

         */
        if (mangaList.size() != 0) {
            System.out.println("Found in database.");
            for (Manga manga : mangaList) {
                System.out.println("--------------------------");
                System.out.println("Manga.: " + manga.getName());
                System.out.println("Image.: " + manga.getUrl());
                System.out.println("Synopsis.: " + manga.getSynopsis());
                System.out.println("Score.: " + manga.getScore());

            }

        } else {
            System.out.println("Not found in database. Moving to API call");
            mangaList = mangaCRUD.getByName(goodManga);
            Manga manga = selectOne(mangaList);
            manga.getAll();
            mangaDAO.create(manga);
        }


    }

    /*
    public static Anime selectOne(List<Anime> animeList){
        int exit = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select one.:");
        for (int i = 0; i < animeList.size(); i++) {
            System.out.println(i + " - " + animeList.get(i).getName());
        }

        while (exit == 0){
            int choice = Integer.parseInt(scanner.next());
            if (choice <= animeList.size()){
                exit = 1;
                return animeList.get(choice);
            } else {
                System.out.println("Please input a valid choice");
            }
        }
        return null;
    }

     */

    public static Manga selectOne(List<Manga> mangaList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select one.:");
        for (int i = 0; i < mangaList.size(); i++) {
            System.out.println(i + " - " + mangaList.get(i).getName());
        }

        while (true){
                int choice = Integer.parseInt(scanner.next());
                if (choice <= mangaList.size()) {
                    return mangaList.get(choice);
                } else {
                    System.out.println("Please input a valid choice");
                }
            }
    }
}