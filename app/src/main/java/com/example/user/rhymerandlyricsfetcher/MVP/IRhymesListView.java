package com.example.user.rhymerandlyricsfetcher.MVP;

import com.example.user.rhymerandlyricsfetcher.model.RhymesModel;

import java.util.List;

/**
 * Created by user on 8/1/2017.
 */

public interface IRhymesListView extends MVPView {
    void onFetchDataInProgress();
    void onFetchDataSuccess(List<RhymesModel> results);
    void onFetchDataError(Throwable throwable);
    void onFetchDataCompleted();

}