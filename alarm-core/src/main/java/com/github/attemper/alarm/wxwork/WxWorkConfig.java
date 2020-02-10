package com.github.attemper.alarm.wxwork;

import com.github.attemper.alarm.ConfigAdapter;

public class WxWorkConfig extends ConfigAdapter {

    protected String url;

    public String getUrl() {
        return url;
    }

    public WxWorkConfig setUrl(String url) {
        this.url = url;
        return this;
    }
}
