package com.example.sheelmorjaria.rhymemusiclyrics;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends Activity {
    static FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.dictionary:
                    RhymeFragment rhymeFragment = new RhymeFragment();
                    fragmentManager.beginTransaction()
                            .add(R.id.fragment_container , rhymeFragment)
                            .disallowAddToBackStack()
                            .commit();
                    return true;
//                case R.id.lyrics:
//                    LyricsFragment lyricsFragment= new LyricsFragment();
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.fragment_container , lyricsFragment)
//                            .commit();
//                    return true;
                case R.id.lyricspad:
                    LyricsPadFragment lyricsPadFragment = new LyricsPadFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container , lyricsPadFragment)
                            .disallowAddToBackStack()
                            .commit();
                    return true;
            }
            return false;
        }

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_base);
        fragmentManager = getFragmentManager();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        if (savedInstanceState == null) {
//
//            fragmentManager.beginTransaction()
//                    .add(R.id.fragment_container, rhymeFragment)
//                    .commit();
//        }
    }

    public static void gotoList(String lyricText) {
        LyricsFragment lyricsFragment = new LyricsFragment();
        Bundle bundle =new Bundle();
        bundle.putString("lyricText", lyricText);
        lyricsFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container ,lyricsFragment)
                .commit();
    }
}
