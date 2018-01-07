package com.example.ddircz.sandbox;

/**
 * Created by acer-pc on 4/12/2017.
 */

/*API Key:
* AIzaSyCD56GGiJW4_JVAGon36BLOPuBVbCfl2s8*/

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;


public class TabActivity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        setupActionBar();
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //Adding icons to the tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.greyheart);
        tabLayout.getTabAt(1).setIcon(R.drawable.wishlist);
        tabLayout.getTabAt(2).setIcon(R.drawable.x_grey);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){
                mViewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     public class SectionsPagerAdapter extends FragmentPagerAdapter {
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private String[] titles = {"Favorites", "Wish List", "Blocked"};
        public SectionsPagerAdapter(FragmentManager fm) {super(fm);}

        @Override
        public Fragment getItem(int position) {
            //NEW
            // Uses a switch statement to figure out which class to return
            //Originally used the placeholder fragment, but now uses the classes
            switch (position) {
                case 0:
                    return new FavoriteTab();
                case 1:
                    return new WishListTab();
                case 2:
                    return new BlockedTab();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return titles[0];
                case 1:
                    return titles[1];
                case 2:
                    return titles[2];
            }
            return null;
        }
    }
}
