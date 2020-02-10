package com.github.attemper.alarm.dingtalk.param.feedCard;

public class FeedCardBody {

    /**
     * 首屏会话透出的展示内容<br>
     * <b>非空</b>
     */
    protected String links;

    public String getLinks() {
        return links;
    }

    public FeedCardBody setLinks(String links) {
        this.links = links;
        return this;
    }
}
