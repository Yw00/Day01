package com.example.day01.view;

import com.example.day01.Bean;
import com.example.day01.RecentBean;

import java.util.List;

public interface Mainview {
    void yes(List<RecentBean> recent);
    void no(String str);
}
