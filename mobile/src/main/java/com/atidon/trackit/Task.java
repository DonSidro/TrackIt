package com.atidon.trackit;

/**
 * Created by Atila on 12-Feb-17.
 */

public class Task {

    private int task_id;
    private String title;
    private String description;
    private int priority;
    private String status;


    public Task(String title, String description, int priority  , String status){
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    //Getters
    public int getTask_id(){
        return this.task_id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPriority(){
        return this.priority;
    }

    public String getStatus(){
        return this.status;
    }

}
