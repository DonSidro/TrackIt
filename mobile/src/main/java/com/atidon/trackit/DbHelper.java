package com.atidon.trackit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Atila on 12-Feb-17.
 */

public class DbHelper extends SQLiteOpenHelper {

    //Log tag
    private static final String LOG = "DbHelper alive";
    //DB name
    private static final String DB_NAME = "trackit_db";
    //DB version
    private static final int DB_VERSION = 1;
    //Tables names
    public static final String TABLE_TASK = "tbltask";
    public static final String TABLE_TIMELOG = "tbltimelog";

    //tbltask column names
    public static final String TASK_ID = "task_id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String PRIORITY = "priority";
    public static final String STATUS = "status";

    //tbltimelog column names
    public static final String TIMELOG_ID = "timelog_id";
    public static final String TIME = "time";
    public static final String TIMESTAMP = "timestamp";
    public static final String LOGTEXT = "logtext";

    //create tbltask statement
    private static final String CREATE_TABLE_TASK = "CREATE TABLE "
            + TABLE_TASK + "(" + TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + TITLE + " TEXT,"
            + DESCRIPTION + " TEXT," + PRIORITY + " INTEGER," + STATUS + " TEXT)";
    //create tbltimelog statement
    private static final String CREATE_TABLE_TIMELOG = "CREATE TABLE "
            + TABLE_TIMELOG + "(" + TIMELOG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + TIME + " REAL,"
            + TIMESTAMP + " TEXT,"
            + LOGTEXT + " TEXT," + TASK_ID + " INTEGER, FOREIGN KEY (" + TASK_ID + ") REFERENCES "
            + TABLE_TASK + "(" + TASK_ID + "));";

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create tables
        db.execSQL(CREATE_TABLE_TASK);
        db.execSQL(CREATE_TABLE_TIMELOG);
        Log.d("tables created","tables created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIMELOG);
        //create the new tables
        onCreate(db);
    }

}
