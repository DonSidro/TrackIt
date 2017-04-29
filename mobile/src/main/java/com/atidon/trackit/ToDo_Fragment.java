package com.atidon.trackit;

import android.content.ContentValues;
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
    DataProvider dataProvider;

    private ArrayList<Task> taskdatalist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.todo_fragment, container, false);
        dataProvider = new DataProvider(getActivity());
        taskdatalist = dataProvider.getListToDo();
        Controller = new TaskViewController(taskdatalist, getActivity());
        Controller.setItemClickCallBack(this);


        recView = (RecyclerView) rootView.findViewById(R.id.rec_view);
        recView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recView.setAdapter(Controller);

        return rootView;
    }

    @Override
    public void onItemClick(View v, int p) {
        ContentValues cv = new ContentValues();
        cv.put("status","IN PROGRESS");
        Task task = taskdatalist.get(p);
        dataProvider.updatedb(cv,task.getTask_id());
        TaskOverview.mSectionsPagerAdapter.notifyDataSetChanged();

    }
}
