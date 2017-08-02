package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

/**
 * Created by user on 8/2/2017.
 */

public interface MVPPresenter <V extends MVPView>{
    void attachView(V mvpView);
    void detachView();
}
