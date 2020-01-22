package com.github.attemper.alarm;

public class WebHookConfig implements Config {

    protected String url;

    public String getUrl() {
        return url;
    }

    public WebHookConfig setUrl(String url) {
        this.url = url;
        return this;
    }
}
