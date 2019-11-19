package com.example.day01.pserenter;

import com.example.day01.Bean;
import com.example.day01.Maincallback;
import com.example.day01.RecentBean;
import com.example.day01.model.MainModel;
import com.example.day01.view.Mainview;

import java.util.List;

public class MainPserenter implements Impserenter, Maincallback {
    private Mainview mainview;
    private MainModel mainModel;

    public MainPserenter(Mainview mainview) {
        this.mainview = mainview;
        this.mainModel=new MainModel();
    }

    @Override
    public void getdata() {
        if (mainModel!=null){
            mainModel.getdata(this);
        }

    }


    @Override
    public void yes(List<RecentBean> recent) {
        mainview.yes(recent);
    }

    @Override
    public void no(String str) {
        mainview.no(str);
    }
}
