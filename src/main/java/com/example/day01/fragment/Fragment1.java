package com.example.day01.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day01.BActivity;
import com.example.day01.BaseApp;
import com.example.day01.Bean;
import com.example.day01.Myrecycleradapter;
import com.example.day01.R;
import com.example.day01.RecentBean;
import com.example.day01.db.RecentBeanDao;
import com.example.day01.pserenter.MainPserenter;
import com.example.day01.view.Mainview;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements Mainview {
    private View view;
    private RecyclerView recycler;
    private Myrecycleradapter myrecycleradapter;
    private ArrayList<RecentBean> recentBeans;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_fragment1, null);
        initView(inflate);
        indata();
        return inflate;
    }

    private void indata() {
        MainPserenter mainPserenter = new MainPserenter(this);
        mainPserenter.getdata();
    }

    private void initView(final View inflate) {
        recycler = (RecyclerView) inflate.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleradapter = new Myrecycleradapter(getActivity());
        recycler.setAdapter(myrecycleradapter);
        myrecycleradapter.setOnclickener(new Myrecycleradapter.Onclickener() {
            @Override
            public void indatadj(int i) {
                Intent intent = new Intent(getActivity(), BActivity.class);
                String url = recentBeans.get(i).getUrl();
                intent.putExtra("data",url);
                startActivity(intent);
            }

            @Override
            public void indatadjlong(int i) {
                RecentBean recentBean = recentBeans.get(i);
                RecentBeanDao recentBeanDao = new BaseApp().getInstance().getDaoSession().getRecentBeanDao();
                recentBeanDao.insertOrReplace(new RecentBean(recentBean.getNews_id(),recentBean.getUrl(),recentBean.getThumbnail(),recentBean.getTitle()));
                Toast.makeText(getActivity(), "插入成功！", Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public void yes(List<RecentBean> recent) {
        recentBeans = new ArrayList<>();
        recentBeans.addAll(recent);
        myrecycleradapter.indata(recentBeans);
        Log.i("TAG","成功！！");
    }

    @Override
    public void no(String str) {
        Log.i("TAG","失败！");
    }
}
