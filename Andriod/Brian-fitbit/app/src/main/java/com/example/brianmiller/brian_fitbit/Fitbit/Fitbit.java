package com.example.brianmiller.brian_fitbit.Fitbit;

import android.os.AsyncTask;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;

/**
 * Created by brian.miller on 11/2/2016.
 */

public class Fitbit extends AsyncTask<HttpRequest, Void, HttpResponse>{


    @Override
    protected HttpResponse doInBackground(HttpRequest... params) {
        HttpRequest httpRequest = params[0];
        try{
            return httpRequest.execute();
        }catch (Exception e){
            return null;
        }
    }
}
