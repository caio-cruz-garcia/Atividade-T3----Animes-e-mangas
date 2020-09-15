package com.company.DAO;
import com.company.model.Anime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * <h1>Class AnimeDAO</h1>
 * DAO for Anime. Contains a variety of methods made to make usage easier
 * <p>
 * <br>
 *     Version 1.0
 *     - Implemented DAO<Anime> and DAOFields
 *     - Added Constructor
 *     - Not sure, however, about the tables.
 *     - Updated method getSelectConditionalString()
 *     - Updated method getSelectAllString()
 *     - Updated method getTableName()
 *
 * @version 1.0
 * @since 2020-09-15
 */
public class AnimeDAO implements DAO<Anime>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:localdb/AnimeManga.db";

    public AnimeDAO() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * method get()
     * Gets specific animes based on the condition given
     * @param condition Condition to look for
     */
    @Override
    public List<Anime> get(String condition) {
        return null;
    }

    /**
     * method getAll()
     * Gets all anime in the table and returns it as a list<Anime>
     */
    @Override
    public List<Anime> getAll() {
        return null;
    }

    /**
     * method update()
     * Due to how the exercise works, it is not a requirement. Yet it'll be implemented for the tests
     * @param anime Anime to update
     */
    @Override
    public void update(Anime anime) {

    }

    /**
     * method delete()
     * Due to how the exercise works, it is not a requirement. Yet it'll be implemented for the tests
     * @param anime Anime to delete
     */
    @Override
    public void delete(Anime anime) {

    }

    /**
     * method create()
     * Create a new entry in the local database for the chosen anime
     * @param anime Anime to create
     */
    @Override
    public void create(Anime anime) {

    }

    /**
     * method getTableName()
     * Stores the table name
     * @return String
     */
    @Override
    public String getTableName() {
        return "anime";
    }

    /**
     * method getDeleteString
     * Returns the string for deletion query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getDeleteString(String table) {
        return null;
    }

    /**
     * method getUpdateString
     * Returns the string for update query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getUpdateString(String table) {
        return null;
    }

    /**
     * method getInsertString
     * Returns the string for inserting, query.
     * @param table Takes table to write the string
     * @return Query string
     */
    @Override
    public String getInsertString(String table) {
        return null;
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
