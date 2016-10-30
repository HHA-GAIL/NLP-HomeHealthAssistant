package edu.pnw.nlp_health_care_digital_assistant;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;

/**
 * Created by brian on 10/15/2016.
 */

public class ChromeCustomTabActivity extends CustomTabsServiceConnection{

    CustomTabsClient mCustomTabsClient;
    CustomTabsSession mCustomTabsSession;
    CustomTabsServiceConnection mCustomTabsServiceConnection;
    CustomTabsIntent mCustomTabsIntent;
    CustomTabsCallback mCustomTabsCallback;

    @Override
    public void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
