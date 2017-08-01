package com.example.user.rhymerandlyricsfetcher.MVP;

/**
 * Created by user on 8/1/2017.
 */

public interface ILyricsListPresenter extends MVPPresenter<ILyricsListView>
{
    void performLyricsListDisplay(String word);

}
