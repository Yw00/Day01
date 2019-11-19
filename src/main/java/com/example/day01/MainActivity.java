package com.example.day01;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day01.fragment.Fragment1;
import com.example.day01.fragment.Fragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);

        //创建fragment
        ArrayList<Fragment> list = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        final Fragment2 fragment2 = new Fragment2();
        list.add(fragment1);
        list.add(fragment2);
        //创建适配器
        Myviewpager myviewpager = new Myviewpager(getSupportFragmentManager(), list);
        viewpager.setAdapter(myviewpager);

        tablayout.addTab(tablayout.newTab().setText("我的"));
        tablayout.addTab(tablayout.newTab().setText("收藏"));

        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setText("我的");
        tablayout.getTabAt(1).setText("收藏");

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==1){
                  fragment2.getdata();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
