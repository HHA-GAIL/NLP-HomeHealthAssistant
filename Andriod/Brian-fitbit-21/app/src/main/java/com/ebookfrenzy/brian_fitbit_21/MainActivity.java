package com.ebookfrenzy.brian_fitbit_21;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.json.jackson2.JacksonFactory;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button fitBitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        try{
            Intent intent = getIntent();
            Uri data = intent.getData();
            Toast.makeText(MainActivity.this,"Connected to Fitbit",Toast.LENGTH_SHORT).show();
            runFitBitInteractions(data);
        }catch (Exception e){
            System.err.println(e.toString());
        }

        wireFitbitButton();
    }
    private void wireFitbitButton(){
        fitBitButton = (Button) findViewById(R.id.fitBitButton);
        fitBitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.fitbit.com/oauth2/authorize?" +
                        "response_type=token" +
                        "&client_id=" + Constants.ClientID +
                        "&expires_in=2592000" +
                        "&scope=activity%20nutrition%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight" +
                        "&redirect_uri=test://fitbit";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }
    private void runFitBitInteractions(Uri fitBitResponse){

        System.out.println(fitBitResponse.toString());
        String access_token = fitBitResponse.toString().substring(fitBitResponse.toString().indexOf('=') + 1,fitBitResponse.toString().indexOf('&'));
        System.out.println(access_token);
        String fitbitCode = fitBitResponse.toString().substring(fitBitResponse.toString().indexOf('&') + 1);
        System.out.println(fitbitCode);
        String user_id = fitbitCode.substring(fitbitCode.indexOf('=') + 1,fitbitCode.indexOf('&'));
        System.out.println(user_id);
        fitbitCode = fitbitCode.substring(fitbitCode.indexOf('&') + 1);
        String scope = fitbitCode.substring(fitbitCode.indexOf('=') + 1,fitbitCode.indexOf('&'));
        System.out.println(scope);
        fitbitCode = fitbitCode.substring(fitbitCode.indexOf('&') + 1);
        String token_type = fitbitCode.substring(fitbitCode.indexOf('=') + 1,fitbitCode.indexOf('&'));
        System.out.println(token_type);
        fitbitCode = fitbitCode.substring(fitbitCode.indexOf('&') + 1);
        String expires_in = fitbitCode.substring(fitbitCode.indexOf('=') + 1);
        System.out.println(expires_in);
        try{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            Date now = cal.getTime();
            SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM0-dd");
            String formatedDate = yyyyMMdd.format(now);
            String requestURL = "https://api.fitbit.com/1/user/" + user_id + "/activities/date"+formatedDate+".json";
            ApacheHttpTransport client = new ApacheHttpTransport();
            HttpRequestFactory requestFactory = client.createRequestFactory();
            HttpRequest getRequest = requestFactory.buildGetRequest(new GenericUrl(requestURL));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAuthorization(new String(token_type + " " + access_token));
            getRequest.setHeaders(httpHeaders);
            HttpResponse response = getRequest.execute();
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(response.getContent(), "UTF-8"));
            StringBuilder responseBuilder = new StringBuilder();
            String inputString;
            while ((inputString = streamReader.readLine()) != null){
                responseBuilder.append(inputString);
            }
            JSONObject jsonObject = new JSONObject(responseBuilder.toString());
            int steps = Integer.parseInt(jsonObject.getJSONObject("summary").getString("steps"));

            System.out.println("Steps: " + jsonObject.getJSONObject("summary").getString("steps"));
            Toast.makeText(this,"You have walked " + jsonObject.getJSONObject("summary").getString("steps"),Toast.LENGTH_LONG).show();
            }catch (Exception e){
            System.err.println(e.toString());
        }


    }
}
