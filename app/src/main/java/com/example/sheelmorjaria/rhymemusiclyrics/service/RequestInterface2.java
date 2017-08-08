package com.example.sheelmorjaria.rhymemusiclyrics.service;

import com.example.sheelmorjaria.rhymemusiclyrics.model.Constants;
import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.ArrayOfSearchLyricResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 8/2/2017.
 */

public interface RequestInterface2 {

    @GET(Constants.LYRICSLIST_API)
    Observable<ArrayOfSearchLyricResult> getTracksWithLyrics(@Query("lyricText") String lyricText);

}
