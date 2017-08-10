package com.example.sheelmorjaria.rhymemusiclyrics;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sheelmorjaria.rhymemusiclyrics.Interactor.InteractorTwoImpl;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.ILyricsListPresenter;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.ILyricsListView;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.LyricsListPresenterImpl;
import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.ArrayOfSearchLyricResult;
import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.SearchLyricResult;

import java.util.ArrayList;
import java.util.List;

import static com.example.sheelmorjaria.rhymemusiclyrics.MainActivity.fragmentManager;

/**
 * Created by user on 8/2/2017.
 */

public class LyricsFragment extends Fragment implements ILyricsListView
{

    ILyricsListPresenter iLyricsListPresenter;
    InteractorTwoImpl interactor_;

    String lyricText;

    Bundle bundle;


    public LyricsFragment() {
    }

//    @Override
//    public void onFetchDataInProgress() {
//
//    }
//
//    @Override
//    public void onFetchDataSuccess(List<String> lyrics) {
//        adaptor = new LyricsAdaptor(lyrics);
//        myList.setAdapter(adaptor);
//
//    }

    @Override
    public void onFetchDataInProgress() {

    }

    @Override
    public void onFetchDataSuccess(ArrayOfSearchLyricResult message) {
        bundle = new Bundle();
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> lyricalChecksum = new ArrayList<>();
        List<SearchLyricResult> lyricsResults = message.getSearchLyricResult();
        for (SearchLyricResult searchLyricResult : lyricsResults) {
            ids.add(searchLyricResult.getLyricId());
            lyricalChecksum.add(searchLyricResult.getLyricChecksum());
//            lyricId = searchLyricResult.getLyricId();
//            lyricChecksum = searchLyricResult.getLyricChecksum();
//            trax.add(lyricId);
//            checksums.add(lyricChecksum);
        }
        bundle.putStringArrayList("lyricId", ids);
        bundle.putStringArrayList("lyricalChecksum", lyricalChecksum);

//        bundle.putString("lyricId", message.getSearchLyricResult().get(0).getLyricId());
////        bundle.putStringArrayList("lyricId",ids);
////        bundle.putStringArrayList("lyricChecksum",LlricChecksum);
//        bundle.putString("lyricChecksum", message.getSearchLyricResult().get(0).getLyricChecksum());
            LyricsSubFragment lyricsSubFragment = new LyricsSubFragment();
            lyricsSubFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .replace(R.id.lyricsView ,lyricsSubFragment)
                    .commit();
//            lyricsSubFragment.setArguments(bundle);
//            interactorThree.getLyrics(lyricId,lyricChecksum)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribeOn(Schedulers.newThread())
//                    .subscribe(this::onSuccess, this::onError);
//            trax.add(lyricId);
//            checksums.add(lyricChecksum);
//            adaptor = new LyricsAdaptor(trax, getContext());
//            myList.setAdapter(adaptor);

        }


//


//    private void onError(Throwable throwable) {
//       Log.i("error throwable", throwable.getMessage());
//    }
//
//    private void onSuccess(GetLyricResult getLyricResult) {
//
//        lyricalText.add(getLyricResult.getLyric());
////        lyricChecksum.add(getLyricResult.getLyricChecksum());
//        adaptor = new LyricsAdaptor(lyricalText, getContext());
//           myList.setAdapter(adaptor);
//
//    }

//    @Override
//    public void onFetchDataSuccess(String track_ids, String lyricsChecksums) {
//        iLyricsPresenter = new LyricsPresenterImpl();
//
//        iLyricsPresenter.performLyricsDisplay(track_ids,lyricsChecksums);
//
//    }
//    @Override
//    public void onFetchDataSuccess(List<String> track_ids, List<String> lyricsChecksums) {
//
//            adaptor = new LyricsAdaptor(track_ids);
//            myList.setAdapter(adaptor);
//    }

    //        iLyricsPresenter = new LyricsPresenterImpl();
//        iLyricsPresenter.performLyricsDisplay(trackIdList);

    @Override
    public void onFetchDataError(Throwable throwable) {

    }

    @Override
    public void onFetchDataCompleted() {

    }


//    @Override
//    public void onFetchDataError(Throwable throwable) {
//        Log.i("error", throwable.getMessage());
//    }
//
//    @Override
//    public void onFetchDataCompleted() {
//
//    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lyricsview,container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        interactor_ = new InteractorTwoImpl();
        iLyricsListPresenter = new LyricsListPresenterImpl(interactor_);
        iLyricsListPresenter.getTracksWithLyrics(lyricText);
        iLyricsListPresenter.attachView(this);
//        iLyricsPresenter =new LyricsPresenterImpl();
//        iLyricsPresenter.attachView(this);




    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        lyricText = bundle.getString("lyricText");


//        Log.i("lyrics word", word);

    }
}
