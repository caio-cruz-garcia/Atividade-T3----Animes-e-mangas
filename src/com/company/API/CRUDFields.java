package com.company.API;

import java.util.List;

/**
 * <h1>Interface CRUD</h1>
 * Interface to be the basis of how sql commands are to be made.
 * <p>
 * @version 1.1
 * @since 2020-09-14
 *
 * Version 1.1
 *      - Changed getByName from String to List<T>
 *      - Changed getByGenre from String to List<T>
 *      - Changed getByType from String to List<T>
 *      - Modified interface to be <T>
 */

public interface CRUDFields<T> {
    String getLink();
    List<T> getByName(String name);
    List<T> getByGenre(String name, String genre);
    List<T> getByType(String name, String type);
}
