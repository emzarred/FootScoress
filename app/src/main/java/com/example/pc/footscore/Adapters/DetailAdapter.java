package com.example.pc.footscore.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pc.footscore.Controllers.Fragments.FixturesFragment;
import com.example.pc.footscore.Controllers.Fragments.LeagueTabFragment;
import com.example.pc.footscore.Controllers.Fragments.TeamFragment;

/**
 * Created by pc on 30/04/2018.
 */

public class DetailAdapter extends FragmentPagerAdapter {
    private int[] colors;


    public DetailAdapter(FragmentManager mgr, int[] colors) {
        super(mgr);
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return (3);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return (TeamFragment.newInstance(position, this.colors[position]));
            case 1:
                return (LeagueTabFragment.newInstance(position, this.colors[position]));
            case 2:
                return (FixturesFragment.newInstance(position, this.colors[position]));
        }
        return null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ("Equipes");
            case 1:
                return ("Classement");
            case 2:
                return ("Fixtures");
        }
        return null;


    }

}
