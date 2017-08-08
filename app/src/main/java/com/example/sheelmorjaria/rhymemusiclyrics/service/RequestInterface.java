package com.example.sheelmorjaria.rhymemusiclyrics.service;

import com.example.sheelmorjaria.rhymemusiclyrics.model.Constants;
import com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics.GetLyricResult;
import com.example.sheelmorjaria.rhymemusiclyrics.model.rhymes.RhymesModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 8/2/2017.
 */

public interface RequestInterface {
    @GET(Constants.RHYMELIST_API)
    Observable<List<RhymesModel>> getRhymeResults(@Query("word") String word);

    @GET(Constants.LYRICS_API)
    Observable<GetLyricResult> getLyrics(@Query("lyricId")String lyricId, @Query("lyricChecksum")String lyricChecksum);
}
