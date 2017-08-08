package com.example.sheelmorjaria.rhymemusiclyrics;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sheelmorjaria.rhymemusiclyrics.Interactor.InteractorThreeImpl;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.ILyricsView;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.LyricsPresenterImpl;
import com.example.sheelmorjaria.rhymemusiclyrics.adaptor.LyricsAdaptor;
import com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics.GetLyricResult;

/**
 * Created by user on 8/7/2017.
 */

public class LyricsSubFragment extends Fragment implements ILyricsView
{
    RecyclerView myList;
    LyricsPresenterImpl iLyricsPresenter;
    String lyricId;
    String lyricChecksum ;
    LyricsAdaptor adapter;
    InteractorThreeImpl interactorThree;

    @Override
    public void onFetchDataInProgress() {

    }

    @Override
    public void onFetchDataSuccess(GetLyricResult getLyricResult) {
//      String lyricResult =  getLyricResult.getLyric();
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        adapter = new LyricsAdaptor(getLyricResult.getLyric() ,getContext());
        myList.setLayoutManager(llm);
           myList.setAdapter(adapter);
    }

    @Override
    public void onFetchDataError(Throwable throwable) {
    }

    @Override
    public void onFetchDataCompleted() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        lyricId = bundle.getString("lyricId");
        lyricChecksum = bundle.getString("lyricChecksum");

//        adapter = new LyricsAdaptor(lyricId, getContext());
//        myList.setAdapter(adapter);

//        iLyricsPresenter = new LyricsPresenterImpl(interactorThree);
//        iLyricsPresenter.attachView(this);
////        for(String trackid: trax) {
////            for (String checksum : checksums) {
//        iLyricsPresenter.performLyricsDisplay(lyricId, lyricChecksum);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lyricssubview,container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       interactorThree =new InteractorThreeImpl();
        myList = (RecyclerView) view.findViewById(R.id.recyclerview2);

                iLyricsPresenter = new LyricsPresenterImpl(interactorThree);
        iLyricsPresenter.attachView(this);
//        for(String trackid: trax) {
//            for (String checksum : checksums) {
        iLyricsPresenter.performLyricsDisplay(lyricId, lyricChecksum);


        }
    }

