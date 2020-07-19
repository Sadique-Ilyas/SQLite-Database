package com.example.sqlitedatabaseexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button BtnADD, BtnView, BtnUpdate, BtnDelete;
    private OnDbOpListener dbOpListener;

    public HomeFragment() {}

    public interface OnDbOpListener
    {
        public void dBOpPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BtnADD = view.findViewById(R.id.btn_add_contact);
        BtnADD.setOnClickListener(this);
        BtnView = view.findViewById(R.id.btn_view_contact);
        BtnView.setOnClickListener(this);
        BtnUpdate = view.findViewById(R.id.btn_update_contact);
        BtnUpdate.setOnClickListener(this);
        BtnDelete = view.findViewById(R.id.btn_delete_contact);
        BtnDelete.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_add_contact:
                dbOpListener.dBOpPerformed(0);
                break;
            case R.id.btn_view_contact:
                dbOpListener.dBOpPerformed(1);
                break;
            case R.id.btn_update_contact:
                dbOpListener.dBOpPerformed(2);
                break;
            case R.id.btn_delete_contact:
                dbOpListener.dBOpPerformed(3);
                break;
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            dbOpListener = (OnDbOpListener) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+"must implement the interface method...");
        }
    }
}
