package com.example.user.rhymerandlyricsfetcher.Interactor;

import com.example.user.rhymerandlyricsfetcher.model.RhymesModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by user on 8/1/2017.
 */

public interface Interactor {
     Observable<List<RhymesModel>> getRhymeResults(String word);
}
