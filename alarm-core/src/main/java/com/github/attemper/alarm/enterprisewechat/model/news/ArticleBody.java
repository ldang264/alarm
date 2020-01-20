package com.github.attemper.alarm.enterprisewechat.model.news;

public class ArticleBody {

    protected String title;

    protected String description;

    protected String url;

    protected String picurl;

    public String getTitle() {
        return title;
    }

    public ArticleBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleBody setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ArticleBody setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPicurl() {
        return picurl;
    }

    public ArticleBody setPicurl(String picurl) {
        this.picurl = picurl;
        return this;
    }
}
