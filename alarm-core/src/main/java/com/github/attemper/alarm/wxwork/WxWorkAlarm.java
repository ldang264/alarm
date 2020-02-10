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
    public AppResult send(Config config, Information information) {
        WxWorkConfig WxWorkConfig = (WxWorkConfig) config;
        String result = HttpClientSingleton.getInstance().post(WxWorkConfig.getUrl(), information);
        return BeanUtil.jsonStr2Bean(result, AppResult.class);
    }
}
