package com.company.DAO;

import com.company.Parser.MangaTypesParser;
import com.company.model.Manga;
import com.company.model.MangaList;
import org.json.JSONObject;

import java.sql.*;
import java.util.List;

/**
 * <h1> class MangaDAO </h1>
 * DAO for Manga. Contains a variety of methods made to make usage easier
 * <p>
 * <br>
 *     Version 1.0
 *     - Implemented DAO<Manga> and DAOFields
 *     - Added Constructor
 *     - Updated method getSelectConditionalString()
 *     - Updated method getSelectAllString()
 *     - Updated method getTableName()
 *     - Updated method get()
 *     - Updated method getAll()
 *     - Updated method update()
 *     - Updated method delete()
 *     - Updated method create()
 *     - Updated method getDeleteString()
 *     - Updated method getUpdateString()
 *     - Updated method getInsertString()
 *
 *
 *
 * @version 1.0
 * @since 2020-09-15
 */

public class MangaDAO implements DAO<Manga>, DAOFields{
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:AnimeManga.db";

    public MangaDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * method get()
     * Gets specific mangas based on the condition given
     * @param condition Condition to look for
     */
    @Override
    public List<Manga> get(String condition) {
        MangaList mangaList = new MangaList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                mangaList.addManga(new Manga(
                        result.getString("name"),
                        result.getString("url"),
                        result.getString("synopsis"),
                        result.getInt("chapters"),
                        result.getInt("volumes"),
                        MangaTypesParser.toTypes(result.getString("types")),
                        result.getFloat("score")
                ));
            }
            result.close();
        }catch (Exception e){
//            e.printStackTrace();
            System.out.println("Error - Either wrong syntax or not in database");
        }
        return mangaList.getMangas();
    }

    /**
     * method getAll()
     * Gets all manga in the table and returns it as a list\<manga\>
     */
    @Override
    public List<Manga> getAll() {
        MangaList mangaList = new MangaList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                mangaList.addManga(new Manga(
                        result.getString("name"),
                        result.getString("url"),
                        result.getString("synopsis"),
                        result.getInt("chapters"),
                        result.getInt("volumes"),
                        MangaTypesParser.toTypes(result.getString("types")),
                        result.getFloat("score")
                ));
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mangaList.getMangas();
    }

    /**
     * method update()
     * Due to how the exercise works, it is not a requirement. Yet it'll be implemented for the tests
     * @param manga Manga to update
     * @return retorno as a boolean, 0 if failed, 1 if successful
     */

    @Override
    public int update(Manga manga) {
        int retorno;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, manga.getName());
            preparedStatement.setString(2, manga.getUrl());
            preparedStatement.setString(3, manga.getSynopsis());
            preparedStatement.setInt(4, manga.getChapters());
            preparedStatement.setInt(5, manga.getVolumes());
            preparedStatement.setString(6, manga.getTypesString());
            preparedStatement.setFloat(7, manga.getScore());
            preparedStatement.setString(8, manga.getName());

            retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            retorno = 0;
        }
        return retorno;
    }

    /**
     * method delete()
     * Due to how the exercise works, it is not a requirement. Yet it'll be implemented for the tests
     * @param manga manga to delete
     */
    @Override
    public int delete(Manga manga) {
        int retorno;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, manga.getName());

            retorno = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            retorno = 0;
        }
        return retorno;
    }

    /**
     * method create()
     * Create a new entry in the local database for the chosen anime
     * @param manga Manga to create
     */
    @Override
    public int create(Manga manga) {
        int retorno;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, manga.getName());
            preparedStatement.setString(2, manga.getUrl());
            preparedStatement.setString(3, manga.getSynopsis());
            preparedStatement.setInt(4, manga.getChapters());
            preparedStatement.setInt(5, manga.getVolumes());
            preparedStatement.setString(6, manga.getTypesString());
            preparedStatement.setFloat(7, manga.getScore());

            retorno = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            retorno = 0;
        }
        return retorno;
    }

    /**
     * method getTableName()
     * Stores the table name
     * @return String
     */
    @Override
    public String getTableName() {
        return "manga";
    }

    /**
     * method getDeleteString
     * Returns the string for deletion query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE name = ?;";
    }

    /**
     * method getUpdateString
     * Returns the string for update query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET name = ?, url = ?, synopsis = ?, chapters = ?, volumes = ?, types = ?, score = ? WHERE name = ?;";
    }

    /**
     * method getInsertString
     * Returns the string for inserting, query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (name, url, synopsis, chapters, volumes, types, score) VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    /**
     * method getSelectAllString
     * Returns string to get all entries in the table.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * method getSelectConditionalString
     * Returns string for conditional search.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
