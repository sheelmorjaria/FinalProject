package com.example.user.rhymerandlyricsfetcher.Interactor;

import com.example.user.rhymerandlyricsfetcher.model.Track;

import io.reactivex.Observable;

/**
 * Created by user on 8/1/2017.
 */

public interface InteractorTwo {

        Observable<Track> getTracksWithLyrics(String word);
    }


