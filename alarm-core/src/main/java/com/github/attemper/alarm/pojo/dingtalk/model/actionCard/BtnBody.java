package com.github.attemper.alarm.pojo.dingtalk.model.actionCard;

import com.sun.istack.internal.NotNull;

public class BtnBody {

    /**
     * 按钮方案
     */
    @NotNull
    protected String title;

    /**
     * 点击按钮触发的URL
     */
    @NotNull
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
