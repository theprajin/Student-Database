package com.infotechnocation.studentdatabase.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.infotechnocation.studentdatabase.R;

/**
 * Created by Prajin Bajracharya on 12/19/2016.
 */

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView txtName;
    TextView txtRoll;
    TextView txtAddress;

    public StudentViewHolder(View itemView) {
        super(itemView);

        txtName = (TextView)itemView.findViewById(R.id.student_name);
        txtRoll = (TextView)itemView.findViewById(R.id.student_roll);
        txtAddress = (TextView)itemView.findViewById(R.id.student_address);
    }
}
