package com.example.pc.footscore.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.ahmadrosid.svgloader.SvgLoader;
import com.bumptech.glide.Glide;
import com.example.pc.footscore.Models.Team;
import com.example.pc.footscore.R;

import com.example.pc.footscore.Views.TeamDetail;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pc on 26/04/2018.
 */

public class TeamAdapter extends RecyclerView.Adapter {

    private List<Team>list;
public static Context context;
private ImageView flag;
private Activity activity;
    public TeamAdapter(List<Team> list, Context context, Activity activity) {
        this.list=list;
        this.context=context;
        this.activity=activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.team_cell,parent,false);
        return new TeamAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Team team = list.get(position);
        Log.d("TeamAdapter", "onBindViewHolder: "+team.getCrestUrl());
        /*Picasso.with(context).load(team.getCrestUrl())
                .fit().centerCrop()
                .placeholder(R.drawable.ic_date_range_white_48dp)
                .into( ViewHolder.flag);*/

        SvgLoader.pluck()
                .with(activity)
                .setPlaceHolder(R.drawable.notfound,R.drawable.notfound)
                .load(team.getCrestUrl(), ViewHolder.flag);
        ViewHolder.caption.setText(team.getName() + "("+team.getShortName()+")");

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

        static TextView caption;
        static ImageView flag;

        public ViewHolder(View v) {
            super(v);
            flag=(ImageView)v.findViewById(R.id.flag);
            caption = (TextView) v.findViewById(R.id.TvCap);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(itemView.getContext(),TeamDetail.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

}




