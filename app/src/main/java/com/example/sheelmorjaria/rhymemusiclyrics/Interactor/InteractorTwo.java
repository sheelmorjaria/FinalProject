package com.example.sheelmorjaria.rhymemusiclyrics.Interactor;

import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.ArrayOfSearchLyricResult;

import io.reactivex.Observable;

/**
 * Created by user on 8/2/2017.
 */

public interface InteractorTwo {

    Observable<ArrayOfSearchLyricResult> getTracksWithLyrics(String word);

}