package com.example.day01;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RecentBean {
    /**
     * news_id : 9717396
     * url : http://news-at.zhihu.com/api/2/news/9717396
     * thumbnail : https://pic1.zhimg.com/v2-ec1ab0e758baeb18884795c8a4825ca4.jpg
     * title : 瞎扯 · 如何正确地吐槽
     */

    private int news_id;
    private String url;
    private String thumbnail;
    @Id
    private String title;
    @Generated(hash = 985766309)
    public RecentBean(int news_id, String url, String thumbnail, String title) {
        this.news_id = news_id;
        this.url = url;
        this.thumbnail = thumbnail;
        this.title = title;
    }
    @Generated(hash = 1697461393)
    public RecentBean() {
    }
    public int getNews_id() {
        return this.news_id;
    }
    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "RecentBean{" +
                "news_id=" + news_id +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
