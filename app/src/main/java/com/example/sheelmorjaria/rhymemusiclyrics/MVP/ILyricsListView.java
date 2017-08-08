package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.ArrayOfSearchLyricResult;

/**
 * Created by user on 8/2/2017.
 */

public interface ILyricsListView extends MVPView{
    void onFetchDataInProgress();
    void onFetchDataSuccess(ArrayOfSearchLyricResult message);
    void onFetchDataError(Throwable throwable);
    void onFetchDataCompleted();
}
