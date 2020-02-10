package com.github.attemper.alarm.wxwork;

import com.github.attemper.alarm.Information;
import com.github.attemper.alarm.AppResult;
import com.github.attemper.alarm.wxwork.param.ContentBody;
import com.github.attemper.alarm.wxwork.param.text.TextMsg;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WxWorkAlarmTest {

    private static WxWorkAlarm alarm;

    private static WxWorkConfig config;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        alarm = new WxWorkAlarm();
        config = new WxWorkConfig().setUrl("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=30a8f590-8250-47e8-bd15-9d37c8a37de8");
    }

    @Test
    public void testSend() throws Exception {
        ContentBody contentBody = new ContentBody();
        contentBody.setContent("任务报错了");
        Information info = new TextMsg().setText(contentBody);
        AppResult appResult = alarm.send(config, info);
        Assert.assertTrue(appResult.getErrCode() == 0);
    }
}