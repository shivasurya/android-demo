package com.shiva.udacity.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import com.shiva.udacity.myapplication.utils.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "com.shiva.udacity.myapplication.action.FOO";
    private static final String ACTION_BAZ = "com.shiva.udacity.myapplication.action.BAZ";


    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                handleActionFoo();
            } else if (ACTION_BAZ.equals(action)) {
                handleActionBaz();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo() {

        try {
            JSONObject stopsObject = utils.getStops();
            if(stopsObject.has("data"))
            {
                // broadcast data to UI and Render it with help of recyclerview
            }
            else
            {
                // broadcast data to UI and share the error message
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
            // broadcast data to UI and share the error message
        }

    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz() {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
