package com.example.user.rhymerandlyricsfetcher;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.rhymerandlyricsfetcher.model.RhymesModel;

import java.util.List;

/**
 * Created by user on 7/24/2017.
 */

public class RhymesAdapter  extends RecyclerView.Adapter<RhymesAdapter.MyViewHolder>
    {
        List<RhymesModel> rhymes;
        Context context;
        @Override
        public void onBindViewHolder(RhymesAdapter.MyViewHolder holder, int position, List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);
        }

        public RhymesAdapter(List<RhymesModel> rhymes, Context applicationContext) {
            this.rhymes = rhymes;
            this.context=applicationContext;
        }
        public int getItemCount(){return rhymes.size();}

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
            return new MyViewHolder(v);
        }
        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView rhyme;


            public MyViewHolder(View itemView) {
                super(itemView);
                rhyme = (TextView) itemView.findViewById(R.id.rhyme);

            }
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.rhyme.setText(rhymes.get(position).getWord());

        }
    }



