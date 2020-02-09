package com.github.attemper.alarm.spring.enterprisewechat;

import com.github.attemper.alarm.ConfigAdapter;
import com.github.attemper.alarm.pojo.enterprisewechat.EnterpriseWeChatConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnterpriseWeChatValueInjection extends EnterpriseWeChatConfig {

    @Value("${alarm.channel.enterprise-we-chat.enabled:true}")
    @Override
    public ConfigAdapter setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    @Value("${alarm.channel.enterprise-we-chat.url}")
    @Override
    public EnterpriseWeChatConfig setUrl(String url) {
        return super.setUrl(url);
    }
}
