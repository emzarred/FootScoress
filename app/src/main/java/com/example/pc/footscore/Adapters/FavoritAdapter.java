package com.example.pc.footscore.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.R;

import java.util.List;

import static android.support.constraint.solver.widgets.ConstraintWidget.GONE;

/**
 * Created by pc on 22/05/2018.
 */

public class FavoritAdapter extends RecyclerView.Adapter {
    private List<Fixture> list;


    public static String date, home, score, away;

    public FavoritAdapter(List<Fixture> list)

    {
        this.list = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        SharedPreferences pref = parent.getContext().getSharedPreferences("DataList", Context.MODE_PRIVATE);
        String value = pref.getString("MyDataList", null);
        date = pref.getString("date", "");
        home = pref.getString("home", "");
        score = pref.getString("score", "");
        away = pref.getString("away", "");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorit_fragment, null);
        return new FavoritAdapter.ViewHolder(view);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder.TvDate.setText(date);
        ViewHolder.TvHome.setText(home);
        ViewHolder.TvScore.setText(score);
        ViewHolder.TvAway.setText(away);
        if (ViewHolder.check.isChecked() == false) {
            ViewHolder.TvDate.setVisibility(View.GONE);
            ViewHolder.TvHome.setVisibility(View.GONE);
            ViewHolder.TvScore.setVisibility(View.GONE);
            ViewHolder.TvAway.setVisibility(View.GONE);
            ViewHolder.check.setVisibility(View.GONE);
            ViewHolder.devider.setVisibility(GONE);

            ViewHolder.msg.setText("No Matches Selected");
        }

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
            devider = (View) v.findViewById(R.id.devider);
            msg = (TextView) v.findViewById(R.id.msg);
        }
    }
}