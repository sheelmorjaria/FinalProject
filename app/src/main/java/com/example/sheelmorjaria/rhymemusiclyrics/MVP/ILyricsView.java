package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

import com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics.GetLyricResult;

/**
 * Created by user on 8/2/2017.
 */

public interface ILyricsView extends MVPView{
        void onFetchDataInProgress();
        void onFetchDataSuccess(GetLyricResult searchLyricResult);
        void onFetchDataError(Throwable throwable);
        void onFetchDataCompleted();
    }


