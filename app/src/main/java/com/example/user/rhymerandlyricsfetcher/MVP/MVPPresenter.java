package com.example.user.rhymerandlyricsfetcher.MVP;

/**
 * Created by user on 8/1/2017.
 */

public interface MVPPresenter <V extends MVPView>{
    void attachView(V mvpView);
    void detachView();
}
