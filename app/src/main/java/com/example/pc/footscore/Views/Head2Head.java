package com.example.pc.footscore.Views;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.pc.footscore.Adapters.headsAdapter;
import com.example.pc.footscore.Models.Head2Head.Fixture_;
import com.example.pc.footscore.Models.Head2Head.Head2head;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Retrofits.ApiClient;
import com.example.pc.footscore.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Head2Head extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView rv;
    private SwipeRefreshLayout spr;
    private ApiInterface cmp;
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head2_head);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.list);
        spr = (SwipeRefreshLayout) findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        getHeads();



    }

    private void getHeads() {
        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<Head2head> call = cmp.getAllHeads();

        call.enqueue(new Callback<Head2head>() {
            @Override
            public void onResponse(Call<Head2head> call, Response<Head2head> response) {

                List<Fixture_> list =  response.body().getFixtures();
                rv.setAdapter(new headsAdapter(list));
            }

            @Override
            public void onFailure(Call<Head2head> call, Throwable t) {
            }

        });
    }

    @Override
    public void onRefresh() {

    }
}
