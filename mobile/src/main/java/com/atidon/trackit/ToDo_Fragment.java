package com.atidon.trackit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by SidonKK on 30/03/2017.
 */

public class ToDo_Fragment extends Fragment implements TaskViewController.ItemClickCallBack {

    private RecyclerView recView;
    private TaskViewController Controller;

    private ArrayList taskdatalist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.todo_fragment, container, false);

        recView = (RecyclerView) rootView.findViewById(R.id.rec_view);
        recView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));


        Controller = new TaskViewController(DummyData.getListData(), rootView.getContext());
        recView.setAdapter(Controller);
        Controller.setItemClickCallBack(this);


        return rootView;
    }

    @Override
    public void onItemClick(View v, int p) {

    }
}
