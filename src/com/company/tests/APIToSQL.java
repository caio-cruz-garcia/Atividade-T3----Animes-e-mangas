package com.company.tests;

import com.company.API.AnimeCRUD;
import com.company.DAO.AnimeDAO;
import com.company.model.Anime;
import com.company.model.AnimeList;

import java.util.List;
import java.util.Scanner;

/**
 * <h1>class APIToSQL</h1>
 * This here we'll simulate the attempt at gathering an API and inserting it on the SQL table.
 * Both animes and mangas
 */
public class APIToSQL {
    // First, we'll attempt to simulate a request for looking up at the anime table for an anime called "xxxHOLiCxxx".
    // Since, at the time we're writing this code, it is not there, it will return a 0, indicating that it failed to find it.
    // Therefore code will attempt to locate it via API, bringing multiple examples of possible animes. User will be requested to select a specific one.
    // Once done, it'll add to the table.

    public static void main(String[] args) {
        String goodAnime = "xxxHOLiC";

        AnimeDAO animeDAO = new AnimeDAO();
        List<Anime> animeList = (animeDAO.get("name LIKE '%" + goodAnime + "%'" ));
        AnimeCRUD animeCRUD = new AnimeCRUD();
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
            //animeList = animeCRUD.getByName(goodAnime);
            //Anime anime = selectOne(animeList);
            //animeDAO.create(anime);
        }


    }

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


}
