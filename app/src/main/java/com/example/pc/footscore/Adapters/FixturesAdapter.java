package com.example.pc.footscore.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.Models.Result;
import com.example.pc.footscore.Models.Team;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Views.DetailActivity;
import com.example.pc.footscore.Views.Head2Head;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by pc on 01/05/2018.
 */

public class FixturesAdapter extends RecyclerView.Adapter {
    private List<Fixture> list;



    public FixturesAdapter(List<Fixture> list) {
        this.list = list;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fix_cell, parent, false);
        return new FixturesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture fixture = list.get(position);
        String c = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        //if(fixture.getDate()==c){
        ViewHolder.TvDate.setText(fixture.getDate().substring(0,Math.min(fixture.getDate().length(),10)));
        ViewHolder.TvHome.setText(fixture.getHomeTeamName());
        ViewHolder.TvScore.setText(fixture.getResult().getGoalsHomeTeam() + " - " + fixture.getResult().getGoalsAwayTeam());
        ViewHolder.TvAway.setText(fixture.getAwayTeamName());
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

        static TextView TvDate, TvHome, TvAway, TvScore;


        public ViewHolder(View v) {
            super(v);

            TvDate = (TextView) v.findViewById(R.id.TvDate);
            TvHome = (TextView) v.findViewById(R.id.TvHome);
            TvScore = (TextView) v.findViewById(R.id.TvScore);
            TvAway = (TextView) v.findViewById(R.id.TvAway);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(itemView.getContext(),Head2Head.class);

                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

}
