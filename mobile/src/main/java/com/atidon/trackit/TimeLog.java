package com.atidon.trackit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Atila on 12-Feb-17.
 */

public class TimeLog {

    private int timelog_id;
    private Float time;
    private String timestamp;
    private String logtext;
    private int task_id;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public TimeLog(Float time, String logtext, int task_id){
        //this.timelog_id = ; generate id
        this.time = time;
        Date today = new Date();
        this.timestamp = dateFormat.format(today);
        this.logtext = logtext;
        this.task_id = task_id;
    }

    //create getters


}
