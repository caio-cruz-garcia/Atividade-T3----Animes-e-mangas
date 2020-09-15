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
 *
 *
 */
public class Executor {
    private AnimeDAO animeDAO = new AnimeDAO();
    private List<Anime> animeList;
    private AnimeCRUD animeCRUD = new AnimeCRUD();
    private Scanner scanner = new Scanner(System.in);


}
