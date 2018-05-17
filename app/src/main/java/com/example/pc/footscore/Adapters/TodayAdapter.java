package com.example.pc.footscore.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.SurfaceView;
import android.widget.ViewAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.pc.footscore.Controllers.Fragments.FavoritFragment;
import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.Models.Today;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Views.Head2Head;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.app.PendingIntent.getActivity;
import static android.support.constraint.solver.widgets.ConstraintWidget.GONE;

/**
 * Created by pc on 07/05/2018.
 */

public class TodayAdapter extends RecyclerView.Adapter {
    private List<Fixture> list;
    // private List<Result> listR;
    public TodayAdapter(List<Fixture> list) {
        this.list = list;

        }
        //this.listR=listR;



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.day_cell, parent, false);

        return new TodayAdapter.ViewHolder(view);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture fixture = list.get(position);

        String c = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
if((fixture.getDate().substring(0,Math.min(fixture.getDate().length(),10)).equals(c)   )){
        TodayAdapter.ViewHolder.TvDate.setText(fixture.getDate().substring(11,19));
        TodayAdapter.ViewHolder.TvHome.setText(fixture.getHomeTeamName());
        TodayAdapter.ViewHolder.TvScore.setText( fixture.getStatus());
        TodayAdapter.ViewHolder.TvAway.setText(fixture.getAwayTeamName());}
        else{
        ViewHolder.TvDate.setVisibility(View.GONE);
    ViewHolder.TvHome.setVisibility(View.GONE);
    ViewHolder.TvScore.setVisibility(View.GONE);
    ViewHolder.TvAway.setVisibility(View.GONE);
    ViewHolder.check.setVisibility(View.GONE);
    ViewHolder.devider.setVisibility(GONE);
ViewHolder.msg.setText("there is no matches for today");}




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
        static CheckBox check;
        static View devider;
        static TextView msg;


        public ViewHolder(View v) {
            super(v);
            TvDate = (TextView) v.findViewById(R.id.TvDate);
            TvHome = (TextView) v.findViewById(R.id.TvHome);
            TvScore = (TextView) v.findViewById(R.id.TvScore);
            TvAway = (TextView) v.findViewById(R.id.TvAway);
            check = (CheckBox) v.findViewById(R.id.checkBox);
            devider=(View)v.findViewById(R.id.devider);
            msg=(TextView)v.findViewById(R.id.msg);
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
