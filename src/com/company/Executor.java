package com.company;

import com.company.API.AnimeCRUD;
import com.company.API.MangaCRUD;
import com.company.DAO.AnimeDAO;
import com.company.DAO.MangaDAO;
import com.company.model.Anime;
import com.company.model.Manga;

import java.util.List;
import java.util.Scanner;

/**
 * The class where most of the code is run.
 *
 * @version 1.0
 * @since 2020-09-15
 *
 */

/*
 * Version 1.0
 *      - Created class Executor.
 *      - Added javadocs as comments
 *      - Added variables
 *      - Added constructor
 *      - Added method selectOneAnime()
 *      - Added method checkAnime()
 *      - Added method printAllAnimes()
 *      - Added method printAllMangas()
 *      - Added method spaceFixer()
 *      - Added method selectOneManga()
 *      - Added method checkManga()
 */
public class Executor {
    private AnimeDAO animeDAO = new AnimeDAO();
    private static AnimeCRUD animeCRUD = new AnimeCRUD();
    private MangaDAO mangaDAO = new MangaDAO();
    private static MangaCRUD mangaCRUD = new MangaCRUD();
    private static Scanner scanner = new Scanner(System.in);

    /**
     *  Constructor
     */
    public Executor() {
    }

    /**
     * Takes string and, for every space, replace with %20.
     * Url encoding.
     * @param text Text to convert
     * @return Converted text
     */
    public String spaceFixer(String text){
        text = text.replaceAll(" ","%20");
        return text;
    }

    /**
     * Made for both SQL and API, where it will list all names found and ask you to select which one you want to select.
     * @param animeList Takes an animelist
     * @return Returns an anime.
     */
    public static Anime selectOneAnime(List<Anime> animeList){
        System.out.println("Listing all animes...");
        for (int i = 0; i < animeList.size(); i++) {
            System.out.println(i + " - " + animeList.get(i).getName());
        }

        while (true){
            System.out.println("Please select one of the above.:");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice <= animeList.size()){
                return animeList.get(choice);
            } else {
                System.out.println("Please input a valid choice");
            }
        }
    }

    /**
     * Made for both SQL and API, where it will list all names found and ask you to select which one you want to select.
     * @param mangaList Takes an mangaList
     * @return Returns an anime.
     */
    public static Manga selectOneManga(List<Manga> mangaList){
        System.out.println("Listing all animes...");
        for (int i = 0; i < mangaList.size(); i++) {
            System.out.println(i + " - " + mangaList.get(i).getName());
        }

        while (true){
            System.out.println("Please select one of the above.:");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice <= mangaList.size()){
                return mangaList.get(choice);
            } else {
                System.out.println("Please input a valid choice");
            }
        }
    }

    /**
     * Takes the chance to check if it's in the database and output the data. If it's there, just write it.
     * Else, swap all spaces with %20 and make API request. Then immediately add it to the databank and print the data obtained.
     */
    public void checkAnime(){
        Anime anime;
        System.out.println("Please write the name of the anime.");
        String name = scanner.nextLine();
        List<Anime> animeList = (animeDAO.get("name LIKE '%" + name + "%'"));
        if (animeList.size() != 0 ){
            System.out.println("Found the following in the database.:");
            anime = selectOneAnime(animeList);

        } else {
            System.out.println("Not found in database. Moving to API call...");
            animeList = animeCRUD.getByName(spaceFixer(name));
            anime = selectOneAnime(animeList);
            System.out.println("Adding to databank... Please wait...");
            animeDAO.create(anime);
        }
        anime.getAll();
    }

    /**
     * Takes the chance to check if it's in the database and output the data. If it's there, just write it.
     * Else, swap all spaces with %20 and make API request. Then immediately add it to the databank and print the data obtained.
     */
    public void checkManga(){
        Manga manga;
        System.out.println("Please write the name of the manga.");
        String name = scanner.nextLine();
        List<Manga> mangaList = (mangaDAO.get("name LIKE '%" + name + "%'"));
        if (mangaList.size() != 0 ){
            System.out.println("Found the following in the database.:");
            manga = selectOneManga(mangaList);

        } else {
            System.out.println("Not found in database. Moving to API call...");
            mangaList = mangaCRUD.getByName(spaceFixer(name));
            manga = selectOneManga(mangaList);
            System.out.println("Adding to databank... Please wait...");
            mangaDAO.create(manga);
        }
        manga.getAll();
    }

    /**
     * Takes all animes from the database and print them.
     */
    public void printAllAnimes(){
        AnimeDAO animeDAO = new AnimeDAO();
        List<Anime> animeList = animeDAO.getAll();

        for (Anime anime: animeList) {
            System.out.println("-------------------------------------------");
            anime.getAll();

        }
        System.out.println("-------------------------------------------\n");

    }

    /**
     * Takes all mangas from the database and print them.
     */
    public void printAllMangas(){
        MangaDAO mangaDAO = new MangaDAO();
        List<Manga> mangaList = mangaDAO.getAll();

        for (Manga manga: mangaList) {
            System.out.println("-------------------------------------------");
            manga.getAll();

        }
        System.out.println("-------------------------------------------\n");

    }


    /**
     * Main method where it takes the user input and display accordingly.
     */
    public void execute(){
        int exit = 0;
        int choice;
        while (exit == 0){
            menu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    checkManga();
                    break;
                case 2:
                    printAllMangas();
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
                    System.out.println("Input not recognized.");

            }
        }

    }

    /**
     * Contains all current possible choices.
     */
    public void menu(){
        System.out.println("Please make your choice.\n" +
                "1 - Manga.\n" +
                "2 - Show all mangas.\n" +
                "3 - Anime.\n" +
                "4 - Show all animes.\n" +
                "0 - Exit");
    }
}
