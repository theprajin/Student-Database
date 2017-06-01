package com.infotechnocation.studentdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Prajin Bajracharya on 12/21/2016.
 */

public class ConfirmDialog extends DialogFragment implements View.OnClickListener {
    private Button btnYes;
    private Button btnNo;
    private ONYesClickListener mListener;
    private int id;
    private int pos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.confirm_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnYes = (Button)view.findViewById(R.id.btnYes);
        btnNo = (Button)view.findViewById(R.id.btnNO);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        id = getArguments().getInt("id");
        pos = getArguments().getInt("pos");
    }

    public void setListener(ONYesClickListener mListener){
        this.mListener = mListener;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnNO){
            dismiss();
        } else{
            if(mListener != null){
                dismiss();
                mListener.onYesClick(id,pos);
            }
        }
    }
}
