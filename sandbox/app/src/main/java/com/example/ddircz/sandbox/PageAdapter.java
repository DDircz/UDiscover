package com.example.ddircz.sandbox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by jerrynguyen on 4/12/17.
 */

public class PageAdapter extends FragmentStatePagerAdapter{

    int mNumOfTabs;

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FavoritesFragment tab1 = new FavoritesFragment();
                return tab1;
            case 1:
                WishlistFragment tab2 = new WishlistFragment();
                return tab2;
            case 2:
                BlockedFragment tab3 = new BlockedFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
