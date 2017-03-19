package test;

import java.lang.reflect.Field;

/**
 * Created by honaf on 2017/3/15.
 */

public class Test {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("1", "honaf");
        Class<?> cls = programmer.getClass();


//        boolean exitTable = cls.isAnnotationPresent(Table.class);
//        System.out.println(exitTable);
        String tableName = cls.getAnnotation(Table.class).value();
        Field[] fields = cls.getFields();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String column = field.getAnnotation(Column.class).value();
            String type = field.getAnnotation(Column.class).type();
            sb.append(column + " " + type);
            if (i != fields.length - 1) {
                sb.append(",");
            }
        }
        System.out.println("create table if not exists " + tableName + "(" + sb.toString() + ")");
    }
}
