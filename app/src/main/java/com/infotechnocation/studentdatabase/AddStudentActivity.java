package com.infotechnocation.studentdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.infotechnocation.studentdatabase.entity.Students;

/**
 * Created by Prajin Bajracharya on 12/19/2016.
 */

public class AddStudentActivity  extends BaseActivity implements View.OnClickListener {
    EditText etName;
    EditText etRoll;
    EditText etAddress;
    Button btnAdd;
    Students mStudents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_layout);

        mStudents = (Students) getIntent().getSerializableExtra(MainActivity.KEY_STUDENT);

        init();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if(mStudents != null) {
            etName.setText(mStudents.getName());
            etRoll.setText(mStudents.getRoll());
            etAddress.setText(mStudents.getAddress());
            btnAdd.setText("Update");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void init(){
        etName = (EditText)findViewById(R.id.et_name);
        etRoll = (EditText)findViewById(R.id.et_roll);
        etAddress = (EditText)findViewById(R.id.et_address);
        btnAdd = (Button)findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (isFormValid()){
            String name = etName.getText().toString();
            String roll = etRoll.getText().toString();
            String address = etAddress.getText().toString();

            if(mStudents == null) {
                dbManager.insertStudent(name, roll, address);
            } else {
                Toast.makeText(AddStudentActivity.this, "Update Operation", Toast.LENGTH_SHORT).show();
                dbManager.updatestudent(mStudents.getId(),name, roll, address);
            }
            finish();
        }


    }

    public boolean isFormValid(){
        if(etName.getText().toString().trim().length()<1){
            etName.setError("Name cannot be empty");
            return false;
        }

        if(etRoll.getText().toString().trim().length()<1){
            etRoll.setError("Roll number cannot be empty");
            return false;
        }

        if(etAddress.getText().toString().trim().length()<1){
            etAddress.setError("Address cannot be empty");
            return false;
        }

        return true;
    }
}
