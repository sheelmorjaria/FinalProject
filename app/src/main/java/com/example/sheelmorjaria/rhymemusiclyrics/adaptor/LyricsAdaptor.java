package com.example.sheelmorjaria.rhymemusiclyrics.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sheelmorjaria.rhymemusiclyrics.R;

import java.util.List;

/**
 * Created by user on 8/2/2017.
 */

public class LyricsAdaptor extends RecyclerView.Adapter<LyricsAdaptor.MyViewHolder> {
    String lyric;
    Context context;
    @Override
    public void onBindViewHolder(LyricsAdaptor.MyViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public LyricsAdaptor(String lyric, Context applicationContext) {
        this.lyric = lyric;
//        this.lyric= " world";
        this.context = applicationContext;
    }


    public int getItemCount() {
        return 1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lyricscardview, parent, false);
        return new MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView lyrics;


        public MyViewHolder(View itemView) {
            super(itemView);
            lyrics = (TextView) itemView.findViewById(R.id.lyric);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.lyrics.setText(lyric);
    }


}
