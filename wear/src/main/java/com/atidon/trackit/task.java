package com.atidon.trackit;

/**
 * Created by SidonKK on 12/04/2017.
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
    public Task(int id, String title, String description, int priority  , String status){
        this.task_id = id;
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
