package com.example.user.rhymerandlyricsfetcher;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;


/**
 * Created by user on 7/25/2017.
 */

public class BaseActivity extends Activity {
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
                            .commit();
                    return true;
                case R.id.lyrics:
                    LyricsFragment lyricsFragment= new LyricsFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container , lyricsFragment)
                            .commit();
                    return true;
                case R.id.lyricspad:
                    LyricsPadFragment lyricsPadFragment = new LyricsPadFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container , lyricsPadFragment)
                            .commit();
                    return true;
            }
            return false;
        }

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

//    public static void gotoList(ArrayList<String> rhymes) {
//        RhymesView rhymeView = new RhymesView();
//        Bundle bundle =new Bundle();
//        bundle.putStringArrayList("rhymes", rhymes);
//        rhymeView.setArguments(bundle);
//        fragmentManager.beginTransaction()
//                .replace(R.id.fragment_container ,rhymeView)
//                .commit();
//
//    }
}