package com.example.sheelmorjaria.rhymemusiclyrics;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sheelmorjaria.rhymemusiclyrics.Interactor.Interactor_Impl;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.IRhymesListPresenter;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.IRhymesListView;
import com.example.sheelmorjaria.rhymemusiclyrics.MVP.RhymesListPresenterImpl;
import com.example.sheelmorjaria.rhymemusiclyrics.adaptor.RhymesAdaptor;
import com.example.sheelmorjaria.rhymemusiclyrics.model.rhymes.RhymesModel;

import java.util.List;

/**
 * Created by user on 8/2/2017.
 */

public class RhymeFragment extends Fragment implements IRhymesListView {

    EditText word;
    String toRhyme;
    RecyclerView myList;
    RhymesAdaptor adapter;
    Interactor_Impl interactor_;

    IRhymesListPresenter iRhymesListPresenter;
    public RhymeFragment() {
    }





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main,container, false);

        return v;
    }


    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        word = (EditText) v.findViewById(R.id.word);
        interactor_ = new Interactor_Impl();


        myList = (RecyclerView) v.findViewById(R.id.recyclerview);
        myList.setLayoutManager(new LinearLayoutManager(getContext()));
        iRhymesListPresenter = new RhymesListPresenterImpl(interactor_);
        iRhymesListPresenter.attachView(this);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toRhyme = word.getText().toString();

                iRhymesListPresenter.performRhymesListDisplay(toRhyme);





            // MainActivity.gotoList(wordList);


            }
        });
    }

    @Override
    public void onFetchDataInProgress() {

    }

    @Override
    public void onFetchDataSuccess(List<RhymesModel> results) {


        adapter = new RhymesAdaptor(results, getContext());
        myList.setAdapter(adapter);
    }

    @Override
    public void onFetchDataError(Throwable throwable) {

    }

    @Override
    public void onFetchDataCompleted() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}