package com.company.API;

/**
 * <h1>Interface CRUD</h1>
 * Interface to be the basis of how sql commands are to be made.
 * <p>
 * @version 1.0
 * @since 2020-09-14
 */

public interface CRUDFields {
    String getLink();
    String getByName(String request);
    String getByGenre(String request);
    String getByType(String request);
}
