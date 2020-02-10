package com.github.attemper.alarm.dingtalk.param.actionCard;

public class BtnBody {

    /**
     * 按钮方案<br>
     * <b>非空</b>
     */
    protected String title;

    /**
     * 点击按钮触发的URL<br>
     * <b>非空</b>
     */
    protected String actionURL;

    public String getTitle() {
        return title;
    }

    public BtnBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getActionURL() {
        return actionURL;
    }

    public BtnBody setActionURL(String actionURL) {
        this.actionURL = actionURL;
        return this;
    }
}
