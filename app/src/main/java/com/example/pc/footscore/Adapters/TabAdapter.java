package com.example.pc.footscore.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Models.Standing;
import com.example.pc.footscore.R;

import java.util.List;

/**
 * Created by pc on 30/04/2018.
 */

public class TabAdapter extends RecyclerView.Adapter {
    private List<Standing> list;

    public TabAdapter(List<Standing> list)
    {
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tab_cell, parent, false);
        return new TabAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Standing standing = list.get(position);

        TabAdapter.ViewHolder.pos.setText(String.valueOf(standing.getPosition()));
        TabAdapter.ViewHolder.caption.setText(standing.getTeamName());
        TabAdapter.ViewHolder.mp.setText(String.valueOf(standing.getPlayedGames()));
        TabAdapter.ViewHolder.goals.setText(String.valueOf(standing.getGoals() + "/" + String.valueOf(standing.getGoalsAgainst())));
        TabAdapter.ViewHolder.points.setText(String.valueOf(standing.getPoints()));


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

        static TextView caption,pos,mp,goals,points;


        public ViewHolder(View v) {
            super(v);

            caption = (TextView) v.findViewById(R.id.caption);
            pos=(TextView) v.findViewById(R.id.pos);
            mp=(TextView)v.findViewById(R.id.mp);
            goals=(TextView)v.findViewById(R.id.goals);
            points=(TextView)v.findViewById(R.id.points);




        }

    }
}
