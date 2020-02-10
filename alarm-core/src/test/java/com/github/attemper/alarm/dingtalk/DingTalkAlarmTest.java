package com.github.attemper.alarm.dingtalk;

import com.github.attemper.alarm.ContentEntity;
import com.github.attemper.alarm.Information;
import com.github.attemper.alarm.AppResult;
import com.github.attemper.alarm.dingtalk.param.text.TextMsg;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DingTalkAlarmTest {

    private static DingTalkAlarm alarm;

    private static DingTalkConfig config;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        alarm = new DingTalkAlarm();
        config = new DingTalkConfig()
                .setUrl("https://oapi.dingtalk.com/robot/send?access_token=8d3265518af6dcf99de4b8d6f8a927f75a8f972e98b6dafec0d56e1642531020")
                .setSecret("SECcfa804c064bd5c82c38ac6a18162bba6c0158d045668373e6e59b4f72f17836c");
    }

    @Test
    public void testSend() throws Exception {
        Information info = new TextMsg().setText(new ContentEntity().setContent("任务报错了"));
        AppResult appResult = alarm.send(config, info);
        Assert.assertEquals(appResult.getErrCode(), 0);
    }
}