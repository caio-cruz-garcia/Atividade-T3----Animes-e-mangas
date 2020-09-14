package com.company.DAO;

/**
 * <h1>Interface DAOFields</h1>
 * Like interface DAO, it contains the established method names for each class.
 * <p>
 * @version 1.0
 * @since 2020-09-14
 */

public interface DAOFields {
    String getTableName();
    String getDeleteString(String table);
    String getUpdateString(String table);
    String getInsertString(String table);
    String getSelectAllString(String table);
    String getSelectConditionalString(String table);
}