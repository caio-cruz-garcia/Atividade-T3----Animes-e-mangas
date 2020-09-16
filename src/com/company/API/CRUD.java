package com.company.API;
import java.util.List;

/**
 * <h1>Interface CRUD</h1>
 * Interface to be the basis of how API commands are to be made.
 * <p>
 * @version 1.3
 * @since 2020-09-14
 *
 * Version 1.1
 *      - method create changed to String
 *      - method read changed to String
 *      - method update changed to String
 *      - method delete changed to String
 *
 * Version 1.2
 *      - method getAll commented out - Unused
 *      - method create commented out - Unused
 *      - method read commented out - Unused
 *      - method update commented out - Unused
 *      - method delete commented out - Unused
 *
 * Version 1.3
 *      - Converted get() to return only what it gets
 */

public interface CRUD{
    String get(String condition) throws Exception;
//    List<T> getAll();
//    String create(T t);
//    String read(T t);
//    String update(T t);
//    String delete(T t);
}
