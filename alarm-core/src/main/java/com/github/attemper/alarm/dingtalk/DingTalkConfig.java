package com.github.attemper.alarm.dingtalk;

import com.github.attemper.alarm.AlarmType;
import com.github.attemper.alarm.ConfigAdapter;

public class DingTalkConfig extends ConfigAdapter {

    protected String url;

    protected String secret;

    public String getUrl() {
        return url;
    }

    public DingTalkConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public DingTalkConfig setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    @Override
    public int getIndex() {
        return AlarmType.DING_TALK.getValue();
    }
}
