package com.example.pc.footscore.Views;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.pc.footscore.Adapters.DetailAdapter;
import com.example.pc.footscore.R;
public class DetailActivity extends AppCompatActivity{
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.configureViewPager();
        this.configureViewPagerAndTabs();

        }




private void configureViewPager(){

        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);

        pager.setAdapter(new DetailAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)) {
        });
        }
private void configureViewPagerAndTabs(){

        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new DetailAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)));


        TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);

        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        }
        }