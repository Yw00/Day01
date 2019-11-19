package com.example.day01;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Myviewpager extends FragmentPagerAdapter {
    ArrayList<Fragment> list=new ArrayList<>();

    public Myviewpager(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        this.list.addAll(list);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
