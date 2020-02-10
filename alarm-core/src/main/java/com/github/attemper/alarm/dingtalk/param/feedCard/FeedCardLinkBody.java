package com.github.attemper.alarm.dingtalk.param.feedCard;

public class FeedCardLinkBody {

    /**
     * 单条信息文本<br>
     * <b>非空</b>
     */
    protected String title;

    /**
     * 单条信息后面图片的URL<br>
     * <b>非空</b>
     */
    protected String picURL;

    /**
     * 点击单条信息到跳转链接<br>
     * <b>非空</b>
     */
    protected String messageURL;

    public String getTitle() {
        return title;
    }

    public FeedCardLinkBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPicURL() {
        return picURL;
    }

    public FeedCardLinkBody setPicURL(String picURL) {
        this.picURL = picURL;
        return this;
    }

    public String getMessageURL() {
        return messageURL;
    }

    public FeedCardLinkBody setMessageURL(String messageURL) {
        this.messageURL = messageURL;
        return this;
    }
}
