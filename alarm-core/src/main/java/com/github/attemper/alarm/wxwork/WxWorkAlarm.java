package com.github.attemper.alarm.wxwork;

import com.github.attemper.alarm.*;

/**
 * https://work.weixin.qq.com/api/doc/90000/90136/91770
 */
public class WxWorkAlarm extends AlarmAdapter {

    public WxWorkAlarm() {
        this.index = AlarmType.WX_WORK.getValue();
    }

    @Override
    public void send(Config config, Information information) {
        WxWorkConfig WxWorkConfig = (WxWorkConfig) config;
        HttpClientSingleton.getInstance().post(WxWorkConfig.getUrl(), information);
    }
}
