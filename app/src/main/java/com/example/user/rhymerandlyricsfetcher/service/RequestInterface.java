package com.example.user.rhymerandlyricsfetcher.service;

import com.example.user.rhymerandlyricsfetcher.model.Constants;
import com.example.user.rhymerandlyricsfetcher.model.RhymesModel;
import com.example.user.rhymerandlyricsfetcher.model.Track;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 8/1/2017.
 */

public interface RequestInterface {
    @GET(Constants.RHYMELIST_API)
    Observable<List<RhymesModel>> getRhymeResults(@Query("word") String word);

    @GET(Constants.LYRICSLIST_API)
    Observable<Track> getTracksWithLyrics(@Query("q_lyrics")String q_lyrics);

}
