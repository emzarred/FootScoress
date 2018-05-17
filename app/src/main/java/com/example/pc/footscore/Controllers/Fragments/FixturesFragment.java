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
import android.widget.Toast;

import com.example.pc.footscore.Adapters.FixturesAdapter;
import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.Models.Fixtures;
import com.example.pc.footscore.Models.Result;
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
 * Activities that contain this fragment must implement the
 * {@l
 * interface
 * to handle interaction events.
 * Use the {@link FixturesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FixturesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();
    public final static String TAG = FixturesFragment.class.getSimpleName();
    List<Fixture> list;
    List<Result> list1;

    private ApiInterface cmp;
    private RecyclerView rv;
    private SwipeRefreshLayout spr;
    private static final String KEY_POSITION = "position";
    private static final String KEY_COLOR = "color";


    public FixturesFragment() {
    }


    // 2 - Method that will create a new instance of CompetitionFragment, and add data to its bundle.
    public static FixturesFragment newInstance(int position, int color) {

        // 2.1 Create new fragment
        FixturesFragment frag = new FixturesFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);

        return (frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 3 - Get layout of CompetitionFragment
        View result = inflater.inflate(R.layout.fragment_page, container, false);

        // 4 - Get widgets from layout and serialise it
        LinearLayout rootView = (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        rv = (RecyclerView) result.findViewById(R.id.list);


        spr = (SwipeRefreshLayout) result.findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        getFixturess();


        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it

        rootView.setBackgroundColor(color);
        // textView.setText("Page numéro "+position);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number " + position);

        return result;
    }

    private void getFixturess() {


        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<Fixtures> call = cmp.getAllFixtures();


        call.enqueue(new Callback<Fixtures>() {
            @Override
            public void onResponse(Call<Fixtures> call, Response<Fixtures> response) {

                Log.d(TAG, "onResponse: " + response.body().getFixtures().get(0).getResult().getGoalsAwayTeam());
                List<Fixture> list = response.body().getFixtures();
                rv.setAdapter(new FixturesAdapter(list));
            }

            @Override
            public void onFailure(Call<Fixtures> call, Throwable t) {
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
        getFixturess();

    }

}