package com.example.sheelmorjaria.rhymemusiclyrics.adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sheelmorjaria.rhymemusiclyrics.MainActivity;
import com.example.sheelmorjaria.rhymemusiclyrics.R;
import com.example.sheelmorjaria.rhymemusiclyrics.model.rhymes.RhymesModel;

import java.util.List;

/**
 * Created by user on 8/2/2017.
 */

public class RhymesAdaptor extends RecyclerView.Adapter<RhymesAdaptor.MyViewHolder> {
    List<RhymesModel> rhymes;
    Context context;

    @Override
    public void onBindViewHolder(RhymesAdaptor.MyViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public RhymesAdaptor(List<RhymesModel> rhymes, Context applicationContext) {
        this.rhymes = rhymes;
        this.context = applicationContext;
    }

    public int getItemCount() {
        return rhymes.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView rhyme;
        View view;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            rhyme = (TextView) itemView.findViewById(R.id.rhyme);

        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.rhyme.setText(rhymes.get(position).getWord());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.gotoList(rhymes.get(position).getWord());

            }
        });
    }
}
