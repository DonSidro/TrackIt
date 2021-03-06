package com.atidon.trackit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;

import java.util.ArrayList;

/**
 * Created by Atila on 12-Feb-17.
 */

public class DataProvider {

    private DbHelper dbHelper;
    private SQLiteDatabase database;


    public DataProvider(Context context){
        dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase();
    }
    //Inserts a task in sqlite db
    public long insertTask(Task task){
        ContentValues values = new ContentValues();
        values.put(DbHelper.TITLE, task.getTitle());
        values.put(DbHelper.DESCRIPTION, task.getDescription());
        values.put(DbHelper.PRIORITY, task.getType());
        values.put(DbHelper.STATUS, task.getStatus());
        return database.insert(DbHelper.TABLE_TASK, null, values);
    }
    //Select all tasks from sqlite db
    public Cursor selectAllTasks(){
        String[] cols = new String[] {DbHelper.TASK_ID, DbHelper.TITLE, DbHelper.DESCRIPTION, DbHelper.PRIORITY, DbHelper.STATUS};
        Cursor cursor = database.query(true, DbHelper.TABLE_TASK, cols, null, null, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public ArrayList<Task> getListToDo(){
        ArrayList<Task> mArrayList = new ArrayList<Task>();
        Cursor mCursor = selectAllTasks();
        int i = 0;
        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            if(mCursor.getString(4).contains("IN PROGRESS")){
                mCursor.moveToNext();
            }else{
                mArrayList.add(i, new Task(mCursor.getInt(0),mCursor.getString(1), mCursor.getString(2), mCursor.getInt(3), mCursor.getString(4)));
                i++;
                mCursor.moveToNext();
            }
        }
        return  mArrayList;
    }

    public ArrayList<Task> getListInProgress(){
        ArrayList<Task> mArrayList = new ArrayList<Task>();
        Cursor mCursor = selectAllTasks();
        int i = 0;
        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            if(!mCursor.getString(4).contains("IN PROGRESS")){
                mCursor.moveToNext();
            }else{
                mArrayList.add(i, new Task(mCursor.getInt(0),mCursor.getString(1), mCursor.getString(2), mCursor.getInt(3), mCursor.getString(4)));
                i++;
                mCursor.moveToNext();
            }
        }
        return  mArrayList;
    }

    //Inserts a log in sqlite db
    public long insertTimeLog(TimeLog timeLog){
        ContentValues values = new ContentValues();
        values.put(DbHelper.TIME, timeLog.getTime());
        values.put(DbHelper.TIMESTAMP, timeLog.getTimestamp());
        values.put(DbHelper.LOGTEXT, timeLog.getLogtext());
        values.put(DbHelper.TASK_ID, timeLog.getTask_id());
        return database.insert(DbHelper.TABLE_TIMELOG, null, values);
    }
    //Select all time logs in sqlite db
    public Cursor selectAllTimeLogs(){
        String[] cols = new String[] {DbHelper.TIMELOG_ID, DbHelper.TIME, DbHelper.TIMESTAMP, DbHelper.LOGTEXT, DbHelper.TASK_ID};
        Cursor cursor = database.query(true, DbHelper.TABLE_TIMELOG, cols, null, null, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public void updatedb(ContentValues cv, int id){
        database.update(dbHelper.TABLE_TASK, cv, "task_id="+id, null);
    }
}
