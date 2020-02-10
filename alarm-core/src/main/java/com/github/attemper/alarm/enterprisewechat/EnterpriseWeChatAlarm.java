package com.github.attemper.alarm.enterprisewechat;

import com.github.attemper.alarm.*;

/**
 * https://work.weixin.qq.com/api/doc/90000/90136/91770
 */
public class EnterpriseWeChatAlarm extends AlarmAdapter {

    public EnterpriseWeChatAlarm() {
        this.index = AlarmType.ENTERPRISE_WE_CHAT.getValue();
    }

    @Override
    public void send(Config config, Information information) {
        EnterpriseWeChatConfig enterpriseWeChatConfig = (EnterpriseWeChatConfig) config;
        HttpClientSingleton.getInstance().post(enterpriseWeChatConfig.getUrl(), information);
    }
}
