package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

/**
 * Created by user on 8/2/2017.
 */

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.sheelmorjaria.rhymemusiclyrics.Interactor.Interactor_Impl;
import com.example.sheelmorjaria.rhymemusiclyrics.model.RhymesModel;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 8/1/2017.
 */

public class RhymesListPresenterImpl implements IRhymesListPresenter {
    Interactor_Impl interactorImpl_;
    IRhymesListView iRhymesListView;
    @Override
    public void attachView(IRhymesListView mvpView) {
        this.iRhymesListView = mvpView;
    }

    public RhymesListPresenterImpl(Interactor_Impl interactorImpl_) {
        this.interactorImpl_ = interactorImpl_;
    }

    @Override
    public void performRhymesListDisplay(String word) {
        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean isConnectedToInternet) {
                        if (isConnectedToInternet) {
                            // do something with isConnectedToInternet value
                            interactorImpl_.getRhymeResults(word)
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(this::onSuccess, this::onError);
                        }
                    }

                    private void onSuccess(List<RhymesModel> rhymesModels) {
                        iRhymesListView.onFetchDataSuccess(rhymesModels);
                    }
                    private void onError(Throwable throwable) {
                        Log.i("Log",throwable.getMessage());
                    }
                });
    }

    @Override
    public void detachView() {

    }
}