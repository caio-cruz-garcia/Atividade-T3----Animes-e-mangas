package com.company.DAO;
import java.util.List;

/**
 * <h1>Interface DAO</h1>
 * Interface to be the basis of how sql commands are to be made.
 * <p>
 * @version 1.0
 * @since 2020-09-14
 */

public interface DAO<T>{
    List<T> get(String condition);
    List<T> getAll();
    void update(T t);
    void delete(T t);
    void create(T t);
}
