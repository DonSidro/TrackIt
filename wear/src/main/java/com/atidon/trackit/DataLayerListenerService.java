package com.atidon.trackit;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by SidonKK on 29/04/2017.
 */

public class DataLayerListenerService extends WearableListenerService {


    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        if (messageEvent.getPath().equals("/request-network")) {
            final String message = new String(messageEvent.getData());


            // do what you want with the json-string
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor edit = pref.edit();
            edit.putString("tasks_json", message).apply();

        } else {
            super.onMessageReceived(messageEvent);
        }
    }
}
