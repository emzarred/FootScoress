package com.example.pc.footscore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Models.Competition;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Views.DetailActivity;


import java.util.List;

/**
 * Created by pc on 25/04/2018.
 */


public class CompAdapter extends RecyclerView.Adapter {
    private List<Competition> list;


    public CompAdapter(List<Competition> list) {
        this.list = list;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.comp_cell, parent, false);
        return new CompAdapter.ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Competition competition = list.get(position);

        CompAdapter.ViewHolder.caption.setText(competition.getCaption() + "(" + String.valueOf(competition.getCurrentMatchday()) + "/" + String.valueOf(competition.getNumberOfMatchdays()) + ")");
        ViewHolder.Id = competition.getId();

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        static TextView caption;
        public static int Id;

        public ViewHolder(View v) {
            super(v);

            caption = (TextView) v.findViewById(R.id.TvCap);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);

                    itemView.getContext().startActivity(intent);
                }
            });


        }

    }


}
