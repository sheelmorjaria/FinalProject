package com.example.user.rhymerandlyricsfetcher.MVP;

/**
 * Created by user on 8/1/2017.
 */

public interface IRhymesListPresenter extends MVPPresenter<IRhymesListView>
{
    void performRhymesListDisplay(String word);

}

