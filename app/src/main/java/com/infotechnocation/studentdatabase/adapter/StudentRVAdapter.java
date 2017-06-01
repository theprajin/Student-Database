package com.infotechnocation.studentdatabase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotechnocation.studentdatabase.OnRecyclerViewListener;
import com.infotechnocation.studentdatabase.R;
import com.infotechnocation.studentdatabase.entity.Students;

import java.util.ArrayList;

/**
 * Created by Prajin Bajracharya on 12/19/2016.
 */

public class StudentRVAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Context context;
    private ArrayList<Students> studentsList;
    private OnRecyclerViewListener listener;

    public StudentRVAdapter(Context context, ArrayList<Students> studentsList){
        this.context = context;
        this.studentsList = studentsList;

    }
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.student_layout_item,null);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, final int position) {
        final Students mStudents = studentsList.get(position);
        holder.txtName.setText(mStudents.getName());
        holder.txtRoll.setText(mStudents.getRoll());
        holder.txtAddress.setText(mStudents.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener==null){
                    listener.onRecyclerItemClick(mStudents,position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(listener==null) {
                    listener.onRecyclerViewItemLongClick(mStudents, position);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public void setListener(OnRecyclerViewListener Listener){
        this.listener = listener;
    }

    public void remove(int pos) {
        studentsList.remove(pos);
        notifyDataSetChanged();
    }
}
