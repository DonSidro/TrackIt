package com.atidon.trackit;

import java.util.ArrayList;

/**
 * Created by SidonKK on 30/03/2017.
 */

public class DummyData {

    private static final String[] titles = {"Task 1", "Task 2", "Task 3", "Task 4"};

    private static final String[] subTitles = {"Kill the dog and the cat", "eat shit", "Task 3", "Task 4"};

    private static final  int priority = 0;
    private static final  String status = "TO DO";


    public static ArrayList<Task> getListData() {
        ArrayList<Task> listData = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < titles.length && j < subTitles.length; j++) {
                Task item = new Task(titles[i], subTitles[i], priority, status );
                listData.add(item);
            }
        }

        return listData;

    }
}
