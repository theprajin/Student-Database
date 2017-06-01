package com.infotechnocation.studentdatabase;

import com.infotechnocation.studentdatabase.entity.Students;

/**
 * Created by Prajin Bajracharya on 12/20/2016.
 */

public interface OnRecyclerViewListener {
    void onRecyclerItemClick(Students mStudents, int pos);
    void onRecyclerViewItemLongClick(Students mStudents, int pos);
}
