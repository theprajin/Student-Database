package com.infotechnocation.studentdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.infotechnocation.studentdatabase.adapter.StudentRVAdapter;
import com.infotechnocation.studentdatabase.entity.Students;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements OnRecyclerViewListener,ONYesClickListener,Serializable{
    RecyclerView mRecyclerView;
    public static final String KEY_STUDENT = "student";
    StudentRVAdapter mStudentRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onResume() {
        super.onResume();
        if(dbManager!=null){
            ArrayList<Students> students = dbManager.fetchStudent();
            mStudentRVAdapter = new StudentRVAdapter(this,students);
            mRecyclerView.setAdapter(mStudentRVAdapter);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.addStudents){
            Intent mIntent = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onYesClick(int id, int pos) {
        dbManager.deleteEmployee(id);
        mStudentRVAdapter.remove(pos);
    }

    @Override
    public void onRecyclerItemClick(Students mStudents, int position) {
        Intent mIntent = new Intent(this, AddStudentActivity.class);
        mIntent.putExtra(KEY_STUDENT, (Serializable) mStudents);
        startActivity(mIntent);
    }

    @Override
    public void onRecyclerViewItemLongClick(Students mStudents, int position) {

        ConfirmDialog mConfirmDialog = new ConfirmDialog();
        Bundle mBundle = new Bundle();
        mBundle.putInt("id", mStudents.getId());
        mBundle.putInt("pos",position);
        mConfirmDialog.setArguments(mBundle);

        mConfirmDialog.setListener(this);
        mConfirmDialog.show(getSupportFragmentManager(),"Confirm Dialog");
    }
}
