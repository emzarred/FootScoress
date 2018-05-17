package com.example.pc.footscore.Controllers.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.footscore.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.support.constraint.solver.widgets.ConstraintWidget.GONE;

public class FavoritFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String KEY_POSITION = "position";
    private static final String KEY_COLOR = "color";
    static TextView TvDate, TvHome, TvAway, TvScore,msg;
    static CheckBox check;
    static View devider;
    private SwipeRefreshLayout spr;


    public FavoritFragment() {
    }


    // 2 - Method that will create a new instance of CompetitionFragment, and add data to its bundle.
    public static FavoritFragment newInstance(int position, int color) {

        // 2.1 Create new fragment
        FavoritFragment frag = new FavoritFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);

        return (frag);

    }


    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 3 - Get layout of CompetitionFragment
        View result = inflater.inflate(R.layout.favorit_fragment, container, false);

        // 4 - Get widgets from layout and serialise it
        LinearLayout rootView = (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        TvDate = (TextView) result.findViewById(R.id.TvDate);
        TvHome = (TextView) result.findViewById(R.id.TvHome);
        TvScore = (TextView) result.findViewById(R.id.TvScore);
        TvAway = (TextView) result.findViewById(R.id.TvAway);
        check = (CheckBox) result.findViewById(R.id.checkBox);
        devider = (View) result.findViewById(R.id.devider);
        msg=(TextView)result.findViewById(R.id.msg);
        msg.setText("");



        spr = (SwipeRefreshLayout) result.findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);

        if (check.isChecked() == false) {
            TvDate.setVisibility(View.GONE);
            TvHome.setVisibility(View.GONE);
            TvScore.setVisibility(View.GONE);
            TvAway.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
            devider.setVisibility(GONE);

            msg.setText("No Matches Selected");
        }

        // String c= String.valueOf(d.getDate());


        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it
        rootView.setBackgroundColor(color);
        // textView.setText("Page numéro "+position);

        //Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onRefresh() {

        Toast.makeText(getContext(), "Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                spr.setRefreshing(false);
            }
        }, 2000);
        if (check.isChecked() == false) {
            TvDate.setVisibility(View.GONE);
            TvHome.setVisibility(View.GONE);
            TvScore.setVisibility(View.GONE);
            TvAway.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
            devider.setVisibility(GONE);
            msg.setText("No Matches Selected");}

    }
}