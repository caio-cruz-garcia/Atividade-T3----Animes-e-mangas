package com.company.API;
import java.util.List;

/**
 * <h1>Interface CRUD</h1>
 * Interface to be the basis of how API commands are to be made.
 * <p>
 * @version 1.0
 * @since 2020-09-14
 */

public interface CRUD<T>{
    List<T> get(String condition);
    List<T> getAll();
    void create(T t);
    void read(T t);
    void update(T t);
    void delete(T t);
}
