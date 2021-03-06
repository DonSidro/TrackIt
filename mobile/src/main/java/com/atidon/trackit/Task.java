package com.atidon.trackit;

/**
 * Created by Atila on 12-Feb-17.
 */

public class Task {

    private int task_id;
    private String title;
    private String description;
    private int type;
    private String status;


    public Task(int id, String title, String description, int type  , String status){
        this.task_id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
    }
    public Task(String title, String description, int type  , String status){
        this.title = title;
        this.description = description;
        this.type = type;
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

    public int getType(){
        return this.type;
    }

    public String getStatus(){
        return this.status;
    }

}
