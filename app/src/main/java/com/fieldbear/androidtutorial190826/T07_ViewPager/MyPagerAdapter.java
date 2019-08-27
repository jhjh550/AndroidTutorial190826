package com.fieldbear.androidtutorial190826.T07_ViewPager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fieldbear.androidtutorial190826.T06_Fragment.BlankFragment;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mData;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        mData = new ArrayList<>();
        mData.add(new MyBlankFragment1());
        mData.add(new MyBlankFragment2());
        mData.add(new MyBlankFragment3());
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
