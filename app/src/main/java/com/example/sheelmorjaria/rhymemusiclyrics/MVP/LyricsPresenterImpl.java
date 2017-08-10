package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sheelmorjaria.rhymemusiclyrics.Interactor.InteractorThree;
import com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics.GetLyricResult;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 8/3/2017.
 */

public class LyricsPresenterImpl implements ILyricsPresenter {
    ILyricsView iLyricsView;
    InteractorThree interactorImpl_;

    List<String> lyrics = new ArrayList<>();
    public LyricsPresenterImpl( InteractorThree interactorImpl_){
        this.interactorImpl_= interactorImpl_;

    }
    @Override
    public void attachView(ILyricsView mvpView) {
        this.iLyricsView = mvpView;
    }

    @Override
    public void detachView() {

    }

    public void performLyricsDisplay(String lyricId,String lyricChecksum) {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean isConnectedToInternet) {
                        if (isConnectedToInternet) {
                            interactorImpl_.getLyrics(lyricId,lyricChecksum)
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);

                        }
                    }








                    private void onError(Throwable throwable) {
                        Log.i("Log",throwable.getMessage());

                    }


                    private void onSuccess(GetLyricResult getLyricResult) {

                        iLyricsView.onFetchDataSuccess(getLyricResult);
                    }

                });
    }
}
