package com.example.sheelmorjaria.rhymemusiclyrics.Interactor;

import com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics.GetLyricResult;

import io.reactivex.Observable;

/**
 * Created by user on 8/3/2017.
 */

public interface InteractorThree {
    Observable<GetLyricResult> getLyrics(String lyricId , String lyricChecksum);

}
