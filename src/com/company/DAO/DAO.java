package com.company.DAO;
import java.util.List;

/**
 * Interface to be the basis of how sql commands are to be made.
 * <p>
 * @version 1.1
 * @since 2020-09-14
 */

/* Version 1.1
 *      - changed create to int
 *      - changed update to int
 *      - changed delete to int
 */

public interface DAO<T>{
    List<T> get(String condition);
    List<T> getAll();
    int update(T t);
    int delete(T t);
    int create(T t);
}
