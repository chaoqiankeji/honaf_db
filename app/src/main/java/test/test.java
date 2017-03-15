package test;

import java.lang.reflect.Field;

/**
 * Created by honaf on 2017/3/15.
 */

public class test {
    public static void main(String[] args){
        Programmer programmer = new Programmer("1","honaf");
        Class<?> cls = programmer.getClass();
        boolean exitTable = cls.isAnnotationPresent(Table.class);

        String tableName = cls.getAnnotation(Table.class).value();
        Field[] fields = cls.getFields();
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            String column = field.getAnnotation(Column.class).value();
            sb.append(column+"-");
        }
        System.out.println("honaf==>"+tableName+"=="+sb.toString());
    }
}
