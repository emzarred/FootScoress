package com.example.pc.footscore.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pc.footscore.Controllers.Fragments.FavoritFragment;
import com.example.pc.footscore.Controllers.Fragments.CompetitionFragment;
import com.example.pc.footscore.Controllers.Fragments.TodayFragment;

/**
 * Created by pc on 22/03/2018.
 */

public class PageAdapter extends FragmentPagerAdapter {


    private int[] colors;


    public PageAdapter(FragmentManager mgr, int[] colors) {
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
                return (CompetitionFragment.newInstance(position));
            case 1:
                return (TodayFragment.newInstance(position, this.colors[position]));
            case 2:
                return (FavoritFragment.newInstance(position, this.colors[position]));
        }
        return null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ("Compétitions");
            case 1:
                return ("Aujourd'hui");
            case 2:
                return ("Favoris");
        }
        return null;


    }
}
