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

public class Done_Fragment extends Fragment implements TaskViewController.ItemClickCallBack {


    private RecyclerView recView;
    private TaskViewController Controller;
    DataProvider dataProvider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.done_fragment, container, false);
        dataProvider = new DataProvider(getActivity());

        Controller = new TaskViewController(dataProvider.getListInProgress(), getActivity());
        Controller.setItemClickCallBack(this);


        recView = (RecyclerView) rootView.findViewById(R.id.rec_view);
        recView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recView.setAdapter(Controller);

        return rootView;
    }

    @Override
    public void onItemClick(View v, int p) {

    }
}
