package com.github.attemper.alarm.pojo.enterprisewechat.model.news;

import com.sun.istack.internal.NotNull;

public class ArticleBody {

    /**
     * 标题，不超过128个字节，超过会自动截断
     */
    @NotNull
    protected String title;

    /**
     * 描述，不超过512个字节，超过会自动截断
     */
    protected String description;

    /**
     * 点击后跳转的链接
     */
    @NotNull
    protected String url;

    /**
     * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150
     */
    @NotNull
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
