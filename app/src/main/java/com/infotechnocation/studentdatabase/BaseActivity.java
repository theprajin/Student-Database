package com.infotechnocation.studentdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.infotechnocation.studentdatabase.dbSet.DBManager;

/**
 * Created by Prajin Bajracharya on 12/19/2016.
 */

public class BaseActivity extends AppCompatActivity {
    DBManager dbManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = DBManager.newInstance(this);
    }
}
