package com.example.pc.footscore.Controllers.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
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

import com.example.pc.footscore.Adapters.CompAdapter;
import com.example.pc.footscore.Adapters.TeamAdapter;
import com.example.pc.footscore.Models.Team;
import com.example.pc.footscore.Models.Teams;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Retrofits.ApiClient;
import com.example.pc.footscore.Retrofits.ApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.pc.footscore.Adapters.TeamAdapter.context;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link } interface
 * to handle interaction events.
 * Use the {@link TeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();
    List<Team> list;

    private ApiInterface cmp;
    private RecyclerView rv;
    private SwipeRefreshLayout spr;
    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";


    public TeamFragment() {
    }



    // 2 - Method that will create a new instance of CompetitionFragment, and add data to its bundle.
    public static  TeamFragment newInstance(int position, int color) {

        // 2.1 Create new fragment
        TeamFragment frag = new TeamFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);



        return(frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 3 - Get layout of CompetitionFragment
        View result = inflater.inflate(R.layout.fragment_page, container, false);

        // 4 - Get widgets from layout and serialise it
        LinearLayout rootView= (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        rv = (RecyclerView) result.findViewById(R.id.list);


        spr = (SwipeRefreshLayout) result.findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
          

        getTeams();


        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it

        rootView.setBackgroundColor(color);
        // textView.setText("Page numéro "+position);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }

    private void getTeams() {



        final ApiInterface cmp = retrofit.create(ApiInterface.class);

        Call<Teams> call = cmp.getAllTeams(404);
        Log.d("TeamView", "onResponse: "+call);
        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                
                List<Team> list =response.body().getTeams();
                rv.setAdapter(new TeamAdapter(list,getContext(),getActivity()));
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {
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
        getTeams();

    }

}
