package com.github.attemper.alarm.enterprisewechat;

import com.github.attemper.alarm.Information;
import com.github.attemper.alarm.enterprisewechat.model.ContentBody;
import com.github.attemper.alarm.enterprisewechat.model.text.TextMsg;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnterpriseWeChatAlarmTest {

    private static EnterpriseWeChatAlarm alarm;

    private static EnterpriseWeChatConfig config;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        alarm = new EnterpriseWeChatAlarm();
        config = new EnterpriseWeChatConfig().setUrl("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=30a8f590-8250-47e8-bd15-9d37c8a37de8");
    }

    @Test
    public void testSend() throws Exception {
        ContentBody contentBody = new ContentBody();
        contentBody.setContent("任务报错了");
        Information info = new TextMsg().setText(contentBody);
        alarm.send(config, info);
    }
}