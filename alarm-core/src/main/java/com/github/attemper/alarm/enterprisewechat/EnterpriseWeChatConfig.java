package com.github.attemper.alarm.enterprisewechat;

import com.github.attemper.alarm.ConfigAdapter;

public class EnterpriseWeChatConfig extends ConfigAdapter {

    protected String url;

    public String getUrl() {
        return url;
    }

    public EnterpriseWeChatConfig setUrl(String url) {
        this.url = url;
        return this;
    }
}
