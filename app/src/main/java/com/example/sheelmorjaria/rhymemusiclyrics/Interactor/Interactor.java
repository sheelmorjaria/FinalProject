package com.example.sheelmorjaria.rhymemusiclyrics.Interactor;

import com.example.sheelmorjaria.rhymemusiclyrics.model.RhymesModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by user on 8/2/2017.
 */

public interface Interactor {
    Observable<List<RhymesModel>> getRhymeResults(String word);
}


