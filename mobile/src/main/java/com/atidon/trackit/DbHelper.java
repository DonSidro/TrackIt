package com.atidon.trackit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    private static final String TABLE_TASK = "tbltask";
    private static final String TABLE_TIMELOG = "tbltimelog";

    //tbltask column names
    private static final String TASK_ID = "task_id";

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
