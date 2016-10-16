package edu.pnw.nlp_health_care_digital_assistant;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class HomeActivity extends AppCompatActivity {
    Button testButton;
    Button fitbitButton;

    String CLIENT_ID = new String();
    String Response_Type = new String();
    String SCOPE = new String();
    String Redirect_Uri =  new String();
    String FIT_BIT_URL =  new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         CLIENT_ID = getString(R.string.client_id);
         Response_Type = getString(R.string.response_type);
         SCOPE = getString(R.string.scope);
         Redirect_Uri =  getString(R.string.redirect_uri);
         FIT_BIT_URL =  getString(R.string.fitbit_url);
        setContentView(R.layout.activity_home);
        wireTestButton();
        wireFitbitButton();
    }
    private void wireTestButton(){
        testButton = (Button) findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.purple.com/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(HomeActivity.this, Uri.parse(url));
            }
        });
    }

    private void wireFitbitButton(){
        fitbitButton = (Button) findViewById(R.id.fitbit_button);
        fitbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri.Builder uriBuilder = new Uri.Builder();
                //Building URI query statement
                //uriBuilder.appendQueryParameter("client_id", CLIENT_ID);
                //uriBuilder.appendQueryParameter("response_type", Response_Type);
                //uriBuilder.appendQueryParameter("scope", SCOPE);
                //uriBuilder.appendQueryParameter("redirect_uri", Uri.parse(Redirect_Uri).toString());
                uriBuilder.path(FIT_BIT_URL);
                String url = "https://www.fitbit.com/oauth2/authorize?response_type=code&client_id=227ZCX&redirect_uri=https://localhost/test&fitbit_auth&scope=activity%20nutrition%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight";

                //Building chrome custom tab
                //String url = "http://www.purple.com";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                Uri uri = uriBuilder.build();
                customTabsIntent.launchUrl(HomeActivity.this, Uri.parse(url));
            }
        });
    }

}
