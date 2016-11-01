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

    }
}
