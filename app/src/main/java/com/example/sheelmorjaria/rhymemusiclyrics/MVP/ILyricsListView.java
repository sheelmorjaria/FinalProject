package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

import com.example.sheelmorjaria.rhymemusiclyrics.model.LyricsList;

import java.util.List;

/**
 * Created by user on 8/2/2017.
 */

public interface ILyricsListView extends MVPView{
    void onFetchDataInProgress();
    void onFetchDataSuccess(List<LyricsList> results);
    void onFetchDataError(Throwable throwable);
    void onFetchDataCompleted();
}
