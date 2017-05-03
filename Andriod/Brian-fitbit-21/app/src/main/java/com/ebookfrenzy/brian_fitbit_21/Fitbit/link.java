package com.ebookfrenzy.brian_fitbit_21.Fitbit;

import android.os.AsyncTask;

/**
 * Created by brian on 12/15/2016.
 */

public class link extends AsyncTask<Activity, Void, Void> {

    @Override
    protected Void doInBackground(Activity... activities) {
        Activity activity = activities[0];
        try{
            activity.Add();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
