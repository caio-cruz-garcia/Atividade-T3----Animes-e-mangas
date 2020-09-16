package com.company.DAO;
import com.company.model.Anime;
import com.company.model.AnimeList;
import com.sun.source.tree.BreakTree;

import java.sql.*;
import java.util.List;

/**
 * DAO for Anime. Contains a variety of methods made to make usage easier
 * @version 1.2
 * @since 2020-09-15
 *
 */

/* Version 1.0
 *     - Implemented DAO<Anime> and DAOFields
 *     - Added Constructor
 *     - Updated method getSelectConditionalString()
 *     - Updated method getSelectAllString()
 *     - Updated method getTableName()
 *
 * Version 1.1
 *     - Updated method get()
 *     - Updated method getAll()
 *     - Updated method update()
 *     - Updated method delete()
 *     - Updated method create()
 *     - Updated method getDeleteString()
 *     - Updated method getUpdateString()
 *     - Updated method getInsertString()
 *
 * Version 1.2
 *     - Changed location of AnimeManga.db
 *     - updated get()'s catch output
 *
 */
public class AnimeDAO implements DAO<Anime>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:AnimeManga.db";

    /**
     * Constructor. Attempts to establish a connection to the database. Since it's a local one, it shouldn't have much issue.
     */
    public AnimeDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Gets specific animes based on the condition given
     * @param condition Condition to look for
     */
    @Override
    public List<Anime> get(String condition) {
        AnimeList animeList = new AnimeList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                animeList.addAnime(new Anime(
                        result.getString("name"),
                        result.getString("url"),
                        result.getString("synopsis"),
                        result.getInt("episodes"),
                        result.getFloat("score")));
            }
            result.close();
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println("Error - Either wrong syntax or not in database");
        }
        return animeList.getAnimes();
    }

    /**
     * Gets all anime in the table and returns it as a list(Anime)
     */
    @Override
    public List<Anime> getAll() {
        AnimeList animeList = new AnimeList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                animeList.addAnime(new Anime(
                        result.getString("name"),
                        result.getString("url"),
                        result.getString("synopsis"),
                        result.getInt("episodes"),
                        result.getFloat("score")));
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return animeList.getAnimes();
    }

    /**
     * Due to how the exercise works, it is not a requirement. Yet it'll be implemented for the tests
     * @param anime Anime to update
     * @return retorno as a boolean, 0 if failed, 1 if successful
     */
    @Override
    public int update(Anime anime) {
        int retorno;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, anime.getName());
            preparedStatement.setString(2, anime.getUrl());
            preparedStatement.setString(3, anime.getSynopsis());
            preparedStatement.setInt(4, anime.getEpisodes());
            preparedStatement.setFloat(5, anime.getScore());
            preparedStatement.setString(6, anime.getName());

            retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            retorno = 0;
        }
        return retorno;
    }

    /**
     * Due to how the exercise works, it is not a requirement. Yet it'll be implemented for the tests
     * @param anime Anime to delete
     */
    @Override
    public int delete(Anime anime) {
        int retorno;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, anime.getName());

            retorno = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            retorno = 0;
        }
        return retorno;
    }

    /**
     * Create a new entry in the local database for the chosen anime
     * @param anime Anime to create
     */
    @Override
    public int create(Anime anime) {
        int retorno;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, anime.getName());
            preparedStatement.setString(2, anime.getUrl());
            preparedStatement.setString(3, anime.getSynopsis());
            preparedStatement.setInt(4, anime.getEpisodes());
            preparedStatement.setFloat(5, anime.getScore());

            retorno = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            retorno = 0;
        }
        return retorno;
    }

    /**
     * Stores the table name
     * @return String
     */
    @Override
    public String getTableName() {
        return "anime";
    }

    /**
     * Returns the string for deletion query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE name = ?;";
    }

    /**
     * Returns the string for update query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET name = ?, url = ?, synopsis = ?, episodes = ?, score = ? WHERE name = ?;";
    }

    /**
     * Returns the string for inserting, query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (name, url, synopsis, episodes, score) VALUES (?, ?, ?, ?, ?);";
    }

    /**
     * Returns string to get all entries in the table.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * Returns string for conditional search.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
