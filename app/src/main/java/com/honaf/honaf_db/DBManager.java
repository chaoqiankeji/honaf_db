package com.honaf.honaf_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by honaf on 2017/3/14.
 */

public class DBManager {
    private static DBManager dbManager;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public static DBManager getInstance(Context context) {
        if (dbManager == null) {
            dbManager = new DBManager(context);
        }
        return dbManager;
    }

    public void release() {
        db.close();
        dbManager = null;
    }


    public long newOrUpdate(Developer developer) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Developer.ID, developer.getId());
        contentValues.put(Developer.NAME, developer.getName());
        contentValues.put(Developer.AGE, developer.getAge());
        contentValues.put(Developer.COMPANY, developer.getCompany().getId());
        //// TODO: 2017/3/14  系列化Skill对象
//        contentValues.put(Developer.SKILLS,developer.getSkills());
        return db.replace(DBUtil.getTable(developer.getClass()), null, contentValues);

    }

    public int delete(Developer developer) {
        return db.delete(DBUtil.getTable(developer.getClass()), Developer.ID + "=?", new String[]{developer.getId()});
    }

    public Developer queryById(String id) {
        Cursor cursor = db.rawQuery("select * from " + DBUtil.getTable(Developer.class) + " where " + Developer.ID + " =?", new String[]{id});
        Developer developer = null;
        if (cursor.moveToNext()) {
            developer = new Developer();
            developer.setId(cursor.getString(cursor.getColumnIndex(Developer.ID)));
            developer.setName(cursor.getInt(cursor.getColumnIndex(Developer.NAME))+"");
            developer.setAge(cursor.getInt(cursor.getColumnIndex(Developer.AGE)));
            // TODO: 2017/3/14  序列化
//            developer.setCompany(cursor.getString(cursor.getColumnIndex(Developer.COMPANY)));
//            developer.setSkills(cursor.getString(cursor.getColumnIndex(Developer.SKILLS)));

        }
        return developer;
    }

    private class DBHelper extends SQLiteOpenHelper {
        private static final int DB_VERSION = 1;
        private static final String DB_NAME = "honaf.db";

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        /**
         * Create a helper object to create, open, and/or manage a database.
         * This method always returns very quickly.  The database is not actually
         * created or opened until one of {@link #getWritableDatabase} or
         * {@link #getReadableDatabase} is called.
         *
         * @param context to use to open or create the database
         * @param name    of the database file, or null for an in-memory database
         * @param factory to use for creating cursor objects, or null for the default
         * @param version number of the database (starting at 1); if the database is older,
         *                {@link #onUpgrade} will be used to upgrade the database; if the database is
         *                newer, {@link #onDowngrade} will be used to downgrade the database
         */
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        /**
         * Called when the database is created for the first time. This is where the
         * creation of tables and the initial population of the tables should happen.
         *
         * @param db The database.
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table if not exists developer (id honaf primary key not null,name INTEGER,age text,company text,skills text)");
        }


        /**
         * Called when the database needs to be upgraded. The implementation
         * should use this method to drop tables, add tables, or do anything else it
         * needs to upgrade to the new schema version.
         * <p>
         * <p>
         * The SQLite ALTER TABLE documentation can be found
         * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
         * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
         * you can use ALTER TABLE to rename the old table, then create the new table and then
         * populate the new table with the contents of the old table.
         * </p><p>
         * This method executes within a transaction.  If an exception is thrown, all changes
         * will automatically be rolled back.
         * </p>
         *
         * @param db         The database.
         * @param oldVersion The old database version.
         * @param newVersion The new database version.
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

}
