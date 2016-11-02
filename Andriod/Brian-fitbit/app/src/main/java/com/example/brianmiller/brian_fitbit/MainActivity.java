package com.example.brianmiller.brian_fitbit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Button fitBitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            Intent intent = getIntent();
            Uri data = intent.getData();
            Toast.makeText(MainActivity.this,"Connected to Fitbit",Toast.LENGTH_SHORT).show();
            runFitBitInteractions(data);
        }catch (Exception e){

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
    }
}
