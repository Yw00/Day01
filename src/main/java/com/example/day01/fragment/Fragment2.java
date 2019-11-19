package com.example.day01.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day01.BaseApp;
import com.example.day01.Myrecycleradapter;
import com.example.day01.R;
import com.example.day01.RecentBean;
import com.example.day01.db.RecentBeanDao;

import java.util.List;

public class Fragment2 extends Fragment {
    private View view;
    private RecyclerView recyclers;
    private RecentBeanDao recentBeanDao;
    private List<RecentBean> recentBeans;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.activity_fragment2, null);
        initView(inflate);
        getdata();
        return inflate;
    }

    public void getdata() {
        recentBeanDao = new BaseApp().getInstance().getDaoSession().getRecentBeanDao();
        recentBeans = recentBeanDao.loadAll();
        recyclers.setLayoutManager(new LinearLayoutManager(getActivity()));
        Myrecycleradapter myrecycleradapter = new Myrecycleradapter(getActivity());
        myrecycleradapter.indata(recentBeans);
        recyclers.setAdapter(myrecycleradapter);
    }

    public void initView(View inflate) {
        recyclers = (RecyclerView) inflate.findViewById(R.id.recyclers);

    }
}
