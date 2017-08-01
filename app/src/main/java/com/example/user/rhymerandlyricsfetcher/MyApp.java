package com.example.user.rhymerandlyricsfetcher;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Base64;

import java.security.SecureRandom;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by user on 7/25/2017.
 */

public class MyApp extends Application {
    public static final String PREFS_NAME = "MyPref";
    public static final String KEY = "KEY";
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());
        byte[] key;
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if(!settings.contains(KEY)){
            key = new byte[64];
            new SecureRandom().nextBytes(key);
            String saveThis = Base64.encodeToString(key, Base64.DEFAULT);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(KEY,saveThis);
            editor.commit();
        } else{
            String stringFromSharedPrefs = settings.getString(KEY,"");
            key = Base64.decode(stringFromSharedPrefs, Base64.DEFAULT);
        }
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()

                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .encryptionKey(key)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }
}

