package com.github.attemper.alarm.spring.dingtalk;

import com.github.attemper.alarm.ConfigAdapter;
import com.github.attemper.alarm.pojo.dingtalk.DingTalkConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DingTalkValueInjection extends DingTalkConfig {

    @Value("${alarm.channel.ding-talk.enabled:true}")
    @Override
    public ConfigAdapter setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    @Value("${alarm.channel.ding-talk.url}")
    @Override
    public DingTalkConfig setUrl(String url) {
        return super.setUrl(url);
    }

    @Value("${alarm.channel.ding-talk.secret}")
    @Override
    public DingTalkConfig setSecret(String secret) {
        return super.setSecret(secret);
    }
}
