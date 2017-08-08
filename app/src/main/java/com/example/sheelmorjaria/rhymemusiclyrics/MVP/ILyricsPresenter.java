package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

/**
 * Created by user on 8/3/2017.
 */

public interface ILyricsPresenter extends MVPPresenter<ILyricsView>{
    void performLyricsDisplay(String track_ids, String lyricsChecksums);

}
