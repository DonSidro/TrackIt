package com.atidon.trackit;

/**
 * Created by Atila on 12-Feb-17.
 */

public class Task {

    private int task_id;
    private String title;
    private String description;
    private String priority;
    private String status;

    public Task(int task_id, String title, String description, String priority, String status){
        this.task_id = task_id;
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

    public String getPriority(){
        return this.priority;
    }

    public String getStatus(){
        return this.status;
    }

}