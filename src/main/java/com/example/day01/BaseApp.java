package com.example.day01;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.day01.db.DaoMaster;
import com.example.day01.db.DaoSession;

public class BaseApp  extends Application {
    private static BaseApp sInstance;
    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        setDatabase();
    }
    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "MyDb", null);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        //Android 9 使用了wal模式,关闭wal模式
        db.disableWriteAheadLogging();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public  BaseApp getInstance(){
        return sInstance;
    }
    public DaoSession getDaoSession(){
        return mDaoSession;
    }
}
