package com.example.sheelmorjaria.rhymemusiclyrics;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sheelmorjaria.rhymemusiclyrics.Interactor.InteractorThreeImpl;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.LyricsPresenterImpl;
import com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics.GetLyricResult;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 8/7/2017.
 */

public class LyricsSubFragment extends Fragment {
    RecyclerView myList;
    LyricsPresenterImpl iLyricsPresenter;
    List<String> lyricId;
    List<String> lyricalChecksum;
    InteractorThreeImpl interactorThree;
    TextView lyricsView;

//    @Override
//    public void onFetchDataInProgress() {
//
//    }
//
//    @Override
//    public void onFetchDataSuccess(GetLyricResult getLyricResult) {
////      String lyricResult =  getLyricResult.getLyric();
//        LinearLayoutManager llm = new LinearLayoutManager(getContext());
//
//        adapter = new LyricsAdaptor(getLyricResult.getLyric(), getContext());
//        myList.setLayoutManager(llm);
//        myList.setAdapter(adapter);
//    }
//
//    @Override
//    public void onFetchDataError(Throwable throwable) {
//    }
//
//    @Override
//    public void onFetchDataCompleted() {
//
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        lyricId = bundle.getStringArrayList("lyricId");
        lyricalChecksum = bundle.getStringArrayList("lyricalChecksum");


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
        View v = inflater.inflate(R.layout.lyricssubview, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        interactorThree = new InteractorThreeImpl();
        lyricsView = (TextView) view.findViewById(R.id.lyricsView);
        iLyricsPresenter = new LyricsPresenterImpl(interactorThree);
//        iLyricsPresenter.attachView(this);

        List<Observable<GetLyricResult>> observables =
                new ArrayList<Observable<GetLyricResult>>();

        if (lyricId.size() == lyricalChecksum.size())
        {
            for (int i = 0; i < lyricId.size(); i++) {

                observables.add(interactorThree.getLyrics(lyricId.get(i), lyricalChecksum.get(i)));

            }
        }


        Observable<GetLyricResult> getLyricResultObservable = Observable.concat(observables);
        getLyricResultObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(getObserver());


    }
    private Observer<GetLyricResult> getObserver(){
        return new Observer<GetLyricResult>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull GetLyricResult getLyricResult) {
//               String lyric=  getLyricResult.getLyric();
                lyricsView.append(getLyricResult.getLyric());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

//    private void onError(Throwable throwable) {
//        Log.i("throwable", throwable.getMessage());
//    }
//
//    private void onSuccess(GetLyricResult getLyricResult) {
//        getLyricResult.getLyric();
//
//    }

}







