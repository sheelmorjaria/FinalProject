package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

import com.example.sheelmorjaria.rhymemusiclyrics.model.RhymesModel;

import java.util.List;

/**
 * Created by user on 8/2/2017.
 */

public interface IRhymesListView extends MVPView {
    void onFetchDataInProgress();
    void onFetchDataSuccess(List<RhymesModel> results);
    void onFetchDataError(Throwable throwable);
    void onFetchDataCompleted();

}