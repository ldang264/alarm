package com.github.attemper.alarm.pojo.enterprisewechat;

import com.github.attemper.alarm.*;

/**
 * https://work.weixin.qq.com/api/doc/90000/90136/91770
 */
public class EnterpriseWeChatAlarm extends AlarmAdapter {

    public EnterpriseWeChatAlarm() {
        this.index = 2;
    }

    @Override
    public void send(Config config, Information information) {
        WebHookConfig webHookConfig = (WebHookConfig) config;
        HttpClientSingleton.getInstance().post(webHookConfig.getUrl(), information);
    }
}
