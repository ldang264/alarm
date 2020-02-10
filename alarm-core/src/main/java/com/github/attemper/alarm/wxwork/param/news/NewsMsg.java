package com.github.attemper.alarm.wxwork.param.news;

import com.github.attemper.alarm.Msg;

public class NewsMsg extends Msg {

    protected Articles news;

    public NewsMsg() {
        this.msgtype = "news";
    }

    public Articles getNews() {
        return news;
    }

    public NewsMsg setNews(Articles news) {
        this.news = news;
        return this;
    }
}
