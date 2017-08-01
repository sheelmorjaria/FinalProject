package com.example.user.rhymerandlyricsfetcher.MVP;

import com.example.user.rhymerandlyricsfetcher.model.LyricsList;

import java.util.List;

/**
 * Created by user on 8/1/2017.
 */

public interface ILyricsListView extends MVPView{
    void onFetchDataInProgress();
    void onFetchDataSuccess(List<LyricsList> results);
    void onFetchDataError(Throwable throwable);
    void onFetchDataCompleted();
}
