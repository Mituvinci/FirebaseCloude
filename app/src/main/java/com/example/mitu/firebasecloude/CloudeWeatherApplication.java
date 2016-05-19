package com.example.mitu.firebasecloude;

import com.firebase.client.Firebase;

/**
 * Created by mitu on 5/19/16.
 */
public class CloudeWeatherApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
