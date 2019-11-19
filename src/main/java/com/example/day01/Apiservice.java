package com.example.day01;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiservice {
    String struel="http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<Bean> getdata();

}
