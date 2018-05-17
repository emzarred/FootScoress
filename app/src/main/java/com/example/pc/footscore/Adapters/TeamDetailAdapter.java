package com.example.pc.footscore.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pc.footscore.Controllers.Fragments.AwayPlayedFragment;
import com.example.pc.footscore.Controllers.Fragments.HomePlayedFragment;
import com.example.pc.footscore.Controllers.Fragments.PlayerFragment;

/**
 * Created by pc on 08/05/2018.
 */

public class TeamDetailAdapter extends FragmentPagerAdapter {
    private int[] colors;


    public TeamDetailAdapter(FragmentManager mgr, int[] colors) {
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
                return (PlayerFragment.newInstance(position, this.colors[position]));
            case 1:
                return (HomePlayedFragment.newInstance(position, this.colors[position]));
            case 2:
                return (AwayPlayedFragment.newInstance(position, this.colors[position]));
        }
        return null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ("Joueurs");
            case 1:
                return ("MatchesAvenir");
            case 2:
                return ("TeteAtete");
        }
        return null;


    }

}
