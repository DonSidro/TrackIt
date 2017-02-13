package com.atidon.trackit;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //TEST!
        Task newTask = new Task("microsft2","test2",2,"inprogress");
        TimeLog newTimeLog = new TimeLog(2.5,"finished this task!",12);
        DataProvider dataProvider = new DataProvider(this);
        dataProvider.insertTask(newTask);
        dataProvider.insertTimeLog(newTimeLog);
        Cursor cursor = dataProvider.selectAllTasks();
        Cursor cursor2 = dataProvider.selectAllTimeLogs();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            System.out.println(cursor.getColumnName(0)+": "+cursor.getInt(0)+ " | "+ cursor.getColumnName(1)+ ": "+ cursor.getString(1)+" | "+cursor.getColumnName(2)+
                    ": "+cursor.getString(2)+ " | "+cursor.getColumnName(3)+": "+cursor.getInt(3)+" | "+cursor.getColumnName(4)+": "+cursor.getString(4));
            cursor.moveToNext();
        }

        cursor2.moveToFirst();
        while (!cursor2.isAfterLast()) {
            System.out.println(cursor2.getColumnName(0)+": "+cursor2.getInt(0)+ " | "+ cursor2.getColumnName(1)+ ": "+ cursor2.getDouble(1)+" | "+cursor2.getColumnName(2)+
                    ": "+cursor2.getString(2)+ " | "+cursor2.getColumnName(3)+": "+cursor2.getString(3)+" | "+cursor2.getColumnName(4)+": "+cursor2.getInt(4));
            cursor2.moveToNext();
        }
        //TEST!
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
