package com.github.attemper.alarm;

import com.github.attemper.alarm.pojo.dingtalk.DingTalkAlarm;
import com.github.attemper.alarm.pojo.dingtalk.model.text.TextMsg;
import com.github.attemper.alarm.pojo.email.EmailAlarm;
import com.github.attemper.alarm.pojo.email.EmailConfig;
import com.github.attemper.alarm.pojo.email.EmailInformation;
import com.github.attemper.alarm.pojo.enterprisewechat.EnterpriseWeChatAlarm;
import org.junit.Test;

public class AlarmTest {

    @Test
    public void testEmail() {
        EmailAlarm alarm = new EmailAlarm();
        EmailConfig config = new EmailConfig().setHost("smtp.qq.com").setUsername("820704815@qq.com").setPassword("dnlhkluwhkdfbcde");
        EmailInformation emailInformation = new EmailInformation().setTo("2456038733@qq.com").setSubject("Hello").setContent("<b>你好</b>");
        try {
            alarm.send(config, emailInformation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDingTalk() {
        DingTalkAlarm alarm = new DingTalkAlarm();
        WebHookConfig config = new WebHookConfig().setUrl("https://oapi.dingtalk.com/robot/send?access_token=8d3265518af6dcf99de4b8d6f8a927f75a8f972e98b6dafec0d56e1642531020");
        TextMsg information = new TextMsg().setText(new ContentEntity().setContent("任务报错了"));
        try {
            alarm.send(config, information);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEnterpriseWeChat() {
        EnterpriseWeChatAlarm alarm = new EnterpriseWeChatAlarm();
        WebHookConfig config = new WebHookConfig().setUrl("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=30a8f590-8250-47e8-bd15-9d37c8a37de8");
        TextMsg information = new TextMsg().setText(new ContentEntity().setContent("任务报错了"));
        try {
            alarm.send(config, information);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
