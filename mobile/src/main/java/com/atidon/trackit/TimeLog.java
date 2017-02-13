package com.atidon.trackit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Atila on 12-Feb-17.
 */

public class TimeLog {

    private int timelog_id;
    private Double time;
    private String timestamp;
    private String logtext;
    private int task_id;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public TimeLog(Double time, String logtext, int task_id){
        this.time = time;
        Date today = new Date();
        this.timestamp = dateFormat.format(today);
        this.logtext = logtext;
        this.task_id = task_id;
    }

    //getters
    public int getTimelog_id(){
        return this.timelog_id;
    }

    public Double getTime(){
        return this.time;
    }

    public String getTimestamp(){
        return this.timestamp;
    }

    public String getLogtext(){
        return this.logtext;
    }

    public int getTask_id(){
        return this.task_id;
    }


}
