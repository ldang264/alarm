package com.github.attemper.alarm.pojo.dingtalk.model.link;

import com.sun.istack.internal.NotNull;

public class LinkBody {

    /**
     * 消息内容。如果太长只会部分展示
     */
    @NotNull
    protected String text;

    /**
     * 消息标题
     */
    @NotNull
    protected String title;

    /**
     * 图片URL
     */
    protected String picUrl;

    /**
     * 点击消息跳转的URL
     */
    @NotNull
    protected String messageUrl;

    public String getText() {
        return text;
    }

    public LinkBody setText(String text) {
        this.text = text;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LinkBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public LinkBody setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public LinkBody setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
        return this;
    }
}
