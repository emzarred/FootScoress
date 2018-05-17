package com.example.pc.footscore.Controllers.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.pc.footscore.Adapters.PageAdapter;
import com.example.pc.footscore.Adapters.TodayAdapter;
import com.example.pc.footscore.Controllers.Fragments.FavoritFragment;
import com.example.pc.footscore.Controllers.Fragments.TodayFragment;
import com.example.pc.footscore.R;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.configureViewPager();
        this.configureViewPagerAndTabs();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.calendar);
            final CalendarView cv = dialog.findViewById(R.id.calendarView);
            final Button btn = dialog.findViewById(R.id.button);
            dialog.setCancelable(true);
            dialog.show();
            cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month,
                                                int dayOfMonth) {

                    final String date = ("Date is : " + dayOfMonth + " / " + (month + 1) + " / " + year);
                    Toast.makeText(MainActivity.this, date, Toast.LENGTH_LONG).show();
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(MainActivity.this, TodayFragment.class);
                            i.putExtra("date", date);
                            startActivity(i);

                        }
                    });

                }
            });

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void configureViewPager() {

        ViewPager pager = (ViewPager) findViewById(R.id.activity_main_viewpager);

        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)) {
        });
    }

    private void configureViewPagerAndTabs() {

        ViewPager pager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), getResources().getIntArray(R.array.colorPagesViewPager)));


        TabLayout tabs = (TabLayout) findViewById(R.id.activity_main_tabs);

        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

}



