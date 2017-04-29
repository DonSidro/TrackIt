package com.atidon.trackit;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SidonKK on 29/04/2017.
 */

public class DatabaseToJSON {

    DataProvider dataProvider;

    public DatabaseToJSON(Context context) {
        dataProvider = new DataProvider(context);
    }

    public JSONObject getJSON() throws JSONException {
        ArrayList<Task> tasks = null;
        JSONObject pl = new JSONObject();
        tasks = dataProvider.getListToDo();
        JSONArray jsonArray = new JSONArray();

        for(int i = 0; i<tasks.size(); i++){
            JSONObject val = new JSONObject();
            try {
                val.put("id", tasks.get(i).getTask_id());
                val.put("title", tasks.get(i).getTitle());
                val.put("description", tasks.get(i).getDescription());
                val.put("status", tasks.get(i).getStatus());
                jsonArray.put(val);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pl.put(String.valueOf(i), jsonArray);
        }

    JSONObject result = new JSONObject();
    result.put("data",pl);
    return result;
}
}
