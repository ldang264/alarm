package com.github.attemper.alarm.spring.wxwork;

import com.github.attemper.alarm.ConfigAdapter;
import com.github.attemper.alarm.wxwork.WxWorkConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxWorkValueInjection extends WxWorkConfig {

    @Value("${alarm.channel.wx-work.enabled:true}")
    @Override
    public ConfigAdapter setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    @Value("${alarm.channel.wx-work.url}")
    @Override
    public WxWorkConfig setUrl(String url) {
        return super.setUrl(url);
    }
}
