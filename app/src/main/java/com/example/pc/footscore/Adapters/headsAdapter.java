package com.example.pc.footscore.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Models.Head2Head.Fixture_;
import com.example.pc.footscore.R;

import java.util.List;

/**
 * Created by pc on 17/05/2018.
 */

public class headsAdapter extends RecyclerView.Adapter {
    private List<Fixture_> list;
    public headsAdapter(List<Fixture_> list) {
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.fix_cell,parent,false);
        return new headsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture_ fixture = list.get(position);

        headsAdapter.ViewHolder.TvDate.setText(fixture.getDate()/*.substring(0, Math.min(fixture.getDate().length(), 10))*/);
        headsAdapter.ViewHolder.TvHome.setText(fixture.getHomeTeamName());
        headsAdapter.ViewHolder.TvScore.setText(fixture.getResult().getGoalsHomeTeam() + " - " + fixture.getResult().getGoalsAwayTeam());
        headsAdapter.ViewHolder.TvAway.setText(fixture.getAwayTeamName());
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


            }
        }
}
