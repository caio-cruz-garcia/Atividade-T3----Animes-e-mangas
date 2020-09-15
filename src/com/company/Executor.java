package com.company;

import com.company.API.AnimeCRUD;
import com.company.DAO.AnimeDAO;
import com.company.model.Anime;

import java.util.List;
import java.util.Scanner;

/**
 * <h1>class Executor</h1>
 * The class where most of the code is run.
 *
 * @version 1.0
 * @since 2020-09-15
 *
 * Version 1.0
 *      - Created class Executor.
 *      - Added javadocs as comments
 *      - Added variables
 *      - Added constructor
 *      - Added method selectOneAnime()
 *      - Added method checkAnime()
 *      - Added method printAllAnimes()
 *
 *
 */
public class Executor {
    private AnimeDAO animeDAO = new AnimeDAO();
    private static List<Anime> animeList;
    private static AnimeCRUD animeCRUD = new AnimeCRUD();
    private static Scanner scanner = new Scanner(System.in);

    public Executor() {
    }

    /**
     * method selectOneAnime
     * Made for both SQL and API, where it will list all names found and ask you to select which one you want to select.
     * @param animeList Takes an animelist
     * @return Returns an anime.
     */
    public static Anime selectOneAnime(List<Anime> animeList){
        int exit = 0;
        System.out.println("Listing all animes...");
        for (int i = 0; i < animeList.size(); i++) {
            System.out.println(i + " - " + animeList.get(i).getName());
        }

        while (exit == 0){
            System.out.println("Please select one of the above.:");
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

    /**
     * method checkAnime
     * Takes the chance to check if it's in the database and output the data. If it's there, just write it.
     * Else, swap all spaces with %20 and make API request. Then immediately add it to the databank and print the data obtained
     */
    public void checkAnime(){
        Anime anime;
        System.out.println("Please write the name of the anime.");
        String name = scanner.next();
        animeList = (animeDAO.get("name LIKE '%" + name + "%'" ));
        if (animeList.size() != 0 ){
            System.out.println("Found the following in the database.:");
            anime = selectOneAnime(animeList);

        } else {
            System.out.println("Not found in database. Moving to API call...");
            animeList = animeCRUD.getByName(name);
            anime = selectOneAnime(animeList);
            System.out.println("Adding to databank... Please wait...");
            animeDAO.create(anime);
        }
        anime.getAll();
    }

    /**
     * method printAllAnimes
     * Takes all animes from the database and print them.
     */
    public void printAllAnimes(){
        AnimeDAO animeDAO = new AnimeDAO();
        List<Anime> animeList = animeDAO.getAll();

        for (Anime anime: animeList) {
            System.out.println("-------------------------------------------");
            anime.getAll();

        }

    }


    /**
     * method execute
     * Main method where it takes the user input and display accordingly
     */
    public void execute(){
        int exit = 0;
        int choice;
        while (exit == 0){
            menu();
            choice = Integer.parseInt(scanner.next());
            switch (choice){
                case 1:
                    System.out.println("Finish manga first before proceeding");
                    break;
                case 2:
                    System.out.println("Finish manga first before proceeding");
                    break;
                case 3:
                    checkAnime();
                    break;
                case 4:
                    printAllAnimes();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    exit = 1;
                    break;
                default:
                    System.out.println("Input not recognize.");

            }
        }

    }

    public void menu(){
        System.out.println("Please make your choice.\n" +
                "1 - Manga.\n" +
                "2 - Show all mangas.\n" +
                "3 - Anime.\n" +
                "4 - Show all animes.\n" +
                "0 - Exit");
    }




}
