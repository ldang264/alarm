package com.github.attemper.alarm.dingtalk;

import com.github.attemper.alarm.*;

/**
 * https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 */
public class DingTalkAlarm extends AlarmAdapter {

    public DingTalkAlarm() {
        this.index = AlarmType.DING_TALK.getValue();
    }

    @Override
    public AppResult send(Config config, Information information) {
        DingTalkConfig dingTalkConfig = (DingTalkConfig) config;
        String result = HttpClientSingleton.getInstance().post(dingTalkConfig.getUrl(), information);
        return BeanUtil.jsonStr2Bean(result, AppResult.class);
    }
}
