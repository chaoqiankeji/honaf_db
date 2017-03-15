package com.honaf.honaf_db;

/**
 * Created by honaf on 2017/3/14.
 *
 */

public class DBUtil {
    public static String getTable(Class<?> cls) {
        return cls.getSimpleName();
    }
}
