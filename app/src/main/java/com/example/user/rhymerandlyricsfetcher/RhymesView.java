package com.example.user.rhymerandlyricsfetcher;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 7/25/2017.
 */

public class RhymesView extends Fragment{
    RecyclerView myList;
    public RhymesView() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview , container ,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myList = (RecyclerView) view.findViewById(R.id.recyclerview);
        myList.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
