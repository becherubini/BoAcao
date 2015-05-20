package com.example.rafaelkrentz.androidparse;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by cherubiniNB on 18/05/2015.
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {
    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                return new ActivityListTab();
            case 1:
                return new ActivityMapTab();
            case 2:
                return new ActivityItensTab();
            default:
                break;
        }
        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }
}