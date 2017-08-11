package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sheelmorjaria.rhymemusiclyrics.Interactor.InteractorTwo;
import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.ArrayOfSearchLyricResult;
import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.SearchLyricResult;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 8/2/2017.
 */

public class LyricsListPresenterImpl implements ILyricsListPresenter {
    InteractorTwo interactorImpl_;
    ILyricsListView iLyricsListView;
    List<SearchLyricResult> searchLyric;

    @Override
    public void attachView(ILyricsListView mvpView) {
        this.iLyricsListView = mvpView;
    }

    public LyricsListPresenterImpl(InteractorTwo interactorImpl) {
        this.interactorImpl_ = interactorImpl;
    }

    @Override
    public void getTracksWithLyrics(String q_lyrics) {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean isConnectedToInternet) {
                        if (isConnectedToInternet) {
                            // do something with isConnectedToInternet value

                            interactorImpl_.getTracksWithLyrics(q_lyrics)


                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);
                        }
                    }


                    private void onError(Throwable throwable) {
                        Log.i("log", throwable.getMessage());
                    }

                    private void onSuccess(ArrayOfSearchLyricResult message) {


                        iLyricsListView.onFetchDataSuccess(message);

                    }
                });
    }


    @Override
    public void detachView() {

    }

}
