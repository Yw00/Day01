package com.example.day01.model;

import com.example.day01.Apiservice;
import com.example.day01.Bean;
import com.example.day01.Maincallback;
import com.example.day01.RecentBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel implements Immodel {
    @Override
    public void getdata(final Maincallback maincallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.struel)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Apiservice apiservice = retrofit.create(Apiservice.class);
        Observable<Bean> getdata = apiservice.getdata();
        getdata.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Bean bean) {
                      if (bean!=null&&bean.getRecent().size()>0) {
                          List<RecentBean> recent = bean.getRecent();
                          maincallback.yes(recent);
                      }
                    }

                    @Override
                    public void onError(Throwable e) {
                        maincallback.no(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
