package com.example.kapil.hackteam.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kapil.hackteam.fragments.SubscriptionFragment2;
import com.example.kapil.hackteam.fragments.SubscriptionFragment1;
import com.example.kapil.hackteam.fragments.SubscriptionFragment3;


/**
 * Created by KAPIL on 16-04-2018.
 */

public class SectionPagerAdapter extends FragmentPagerAdapter {
    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SubscriptionFragment2 subFragment1 = new SubscriptionFragment2();
                return subFragment1;
            case 1:
                SubscriptionFragment1 subFragment2 = new SubscriptionFragment1();
                return subFragment2;
            case 2:SubscriptionFragment3 subFragment3 = new SubscriptionFragment3();
                return subFragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
