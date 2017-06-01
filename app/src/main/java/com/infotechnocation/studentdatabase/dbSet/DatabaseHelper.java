package com.infotechnocation.studentdatabase.dbSet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Prajin Bajracharya on 12/19/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_student";
    private static int version = 1;

    public static final String NAME = "student_name";
    public static final String ROLL = "student_roll";
    public static final String ADDRESS = "student_address";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS tbl_student " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT, " +
            ROLL + " TEXT, " +
            ADDRESS + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
