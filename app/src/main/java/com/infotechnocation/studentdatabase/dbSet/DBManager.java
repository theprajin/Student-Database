package com.infotechnocation.studentdatabase.dbSet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.infotechnocation.studentdatabase.entity.Students;

import java.util.ArrayList;

/**
 * Created by Prajin Bajracharya on 12/19/2016.
 */

public class DBManager  {
    private static DBManager DB_MANAGER;
    private Context context;
    private SQLiteDatabase mSqLiteDatabase;

    private DBManager(Context context){
        this.context = context;
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(context);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
    }

    public static DBManager newInstance(Context context){
        if (DB_MANAGER==null){
            DB_MANAGER = new DBManager(context);
        }

        return DB_MANAGER;
    }

    public void insertStudent(String name, String roll, String address){
        ContentValues cv = new ContentValues();
        cv.put("DatabaseHelper.NAME", name);
        cv.put("DatabaseHelper.ROLL", roll);
        cv.put("DatabaseHelper.ADDRESS", address);

        mSqLiteDatabase.insert("tbl_student", null, cv);
    }

    public ArrayList<Students> fetchStudent(){
        ArrayList<Students> mStudentsArrayList = new ArrayList<Students>();
        String query = "SELECT * FROM tbl_student";
        Cursor mCursor = mSqLiteDatabase.rawQuery(query,null);

        while(mCursor.moveToNext()){
            int id = mCursor.getInt(mCursor.getColumnIndex("id"));
            String name = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.NAME));
            String roll = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROLL));
            String address = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ADDRESS));

            Students mStudents = new Students(name, roll, address);
            mStudents.setId(id);
            mStudentsArrayList.add(mStudents);
        }

        return mStudentsArrayList;
    }

    public void updatestudent(int id, String name, String roll, String address){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.NAME,name);
        cv.put(DatabaseHelper.ROLL,roll);
        cv.put(DatabaseHelper.ADDRESS,roll);

        String where = "id = ?";
        mSqLiteDatabase.update("tbl_student",cv,where,new String[]{id +""});
    }

    public void deleteEmployee(int id){
        String where = "id = ?";
        mSqLiteDatabase.delete("tbl_student",where, new String[]{id + ""});
    }
}
