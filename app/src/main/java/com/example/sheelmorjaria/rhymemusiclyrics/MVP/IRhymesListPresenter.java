package com.example.sheelmorjaria.rhymemusiclyrics.MVP;

/**
 * Created by user on 8/2/2017.
 */

public interface IRhymesListPresenter extends MVPPresenter<IRhymesListView>
{
    void performRhymesListDisplay(String word);

}