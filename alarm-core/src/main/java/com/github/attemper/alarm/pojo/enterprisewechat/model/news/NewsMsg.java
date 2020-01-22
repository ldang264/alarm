package com.github.attemper.alarm.pojo.enterprisewechat.model.news;

import com.github.attemper.alarm.Msg;
import com.sun.istack.internal.NotNull;

public class NewsMsg extends Msg {

    @NotNull
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
