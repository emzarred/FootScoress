package com.example.pc.footscore.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Views.Head2Head;

import java.util.List;

/**
 * Created by pc on 08/05/2018.
 */

public class TeamFixAdapter extends RecyclerView.Adapter {
    private List<Fixture> list;
    // private List<Result> listR;

    public TeamFixAdapter(List<Fixture> list) {this.list=list;
        //this.listR=listR;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.fix_cell,parent,false);
        return new TeamFixAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture fixture = list.get(position);
        //Result result = listR.get(position);

        TeamFixAdapter.ViewHolder.TvDate.setText(fixture.getDate()  );
        TeamFixAdapter.ViewHolder.TvHome.setText(fixture.getHomeTeamName());
         TeamFixAdapter.ViewHolder.TvScore.setText(fixture.getStatus() );
        TeamFixAdapter.ViewHolder.TvAway.setText(fixture.getAwayTeamName());
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

        static TextView TvDate,TvHome, TvAway,TvScore;




        public ViewHolder(View v) {
            super(v);

            TvDate= (TextView)v.findViewById(R.id.TvDate);
            TvHome=(TextView)v.findViewById(R.id.TvHome);
            TvScore=(TextView)v.findViewById(R.id.TvScore);
            TvAway=(TextView)v.findViewById(R.id.TvAway);
            TvHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(TvHome.getContext(),Head2Head.class);

                    TvHome.getContext().startActivity(intent);
                }
            });


        }
    }
}
