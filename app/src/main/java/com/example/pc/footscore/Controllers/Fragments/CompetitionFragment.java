package com.example.pc.footscore.Controllers.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.footscore.Adapters.CompAdapter;
import com.example.pc.footscore.Models.Competition;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Retrofits.ApiClient;
import com.example.pc.footscore.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompetitionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();
    private  TextView Tv7,Tv8;

    List<Competition> list;
    private ApiInterface cmp;
    private RecyclerView rv7, rv8;
    private SwipeRefreshLayout spr;
    private static final String KEY_POSITION = "position";
    private static final String KEY_COLOR = "color";


    public CompetitionFragment() {
    }


    // 2 - Method that will create a new instance of CompetitionFragment, and add data to its bundle.
    public static CompetitionFragment newInstance(int position) {

        // 2.1 Create new fragment
        CompetitionFragment frag = new CompetitionFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);

        frag.setArguments(args);

        return (frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 3 - Get layout of CompetitionFragment
        View result = inflater.inflate(R.layout.fragment_head2_head, container, false);

        // 4 - Get widgets from layout and serialise it
        LinearLayout rootView = (LinearLayout) result.findViewById(R.id.fragment_page_rootview);

        rv7 = (RecyclerView) result.findViewById(R.id.list);

        rv8 = (RecyclerView) result.findViewById(R.id.list1);
        Tv7= (TextView)result.findViewById(R.id.Tv7);
        Tv8= (TextView)result.findViewById(R.id.Tv8);


        spr = (SwipeRefreshLayout) result.findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv7.setLayoutManager(new LinearLayoutManager(getContext()));
        rv8.setLayoutManager(new LinearLayoutManager(getContext()));
        getCompetitions_7();
         getCompetitions_8();


        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it

        rootView.setBackgroundColor(color);
        // textView.setText("Page numéro "+position);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number " + position);

        return result;
    }

    private void getCompetitions_7() {
        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<List<Competition>> call = cmp.getAllCompetitions(2017);
        call.enqueue(new Callback<List<Competition>>() {
            @Override
            public void onResponse(Call<List<Competition>> call, Response<List<Competition>> response) {

                List<Competition> list = (List<Competition>) response.body();
                rv7.setAdapter(new CompAdapter(list));


            }

            @Override
            public void onFailure(Call<List<Competition>> call, Throwable t) {
                Tv7.setVisibility(View.GONE);
                Tv8.setVisibility(View.GONE);
Toast.makeText(getContext(),"connection faild try again!",Toast.LENGTH_SHORT).show();
            }


        });

    }

     private void getCompetitions_8() {
          final ApiInterface cmp = retrofit.create(ApiInterface.class);
          Call<List<Competition>> call = cmp.getAllCompetitions(2018);
          call.enqueue(new Callback<List<Competition>>() {
              @Override
              public void onResponse(Call<List<Competition>> call, Response<List<Competition>> response) {

                  List<Competition> list = (List<Competition>) response.body();
                  rv8.setAdapter(new CompAdapter(list));


              }

              @Override
              public void onFailure(Call<List<Competition>> call, Throwable t) {



              }


          });

      }
    @Override
    public void onRefresh() {
        Toast.makeText(getContext(), "Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                spr.setRefreshing(false);
            }
        }, 2000);
        getCompetitions_7();
        getCompetitions_8();

    }
}
