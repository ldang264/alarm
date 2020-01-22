package com.github.attemper.alarm.pojo.dingtalk;

import com.github.attemper.alarm.AlarmAdapter;
import com.github.attemper.alarm.Config;
import com.github.attemper.alarm.HttpClientSingleton;
import com.github.attemper.alarm.Information;
import com.github.attemper.alarm.WebHookConfig;

/**
 * https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 */
public class DingTalkAlarm extends AlarmAdapter {

    public DingTalkAlarm() {
        this.index = 1;
    }

    @Override
    public void send(Config config, Information information) {
        WebHookConfig webHookConfig = (WebHookConfig) config;
        HttpClientSingleton.getInstance().post(webHookConfig.getUrl(), information);
    }
}
