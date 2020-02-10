package com.github.attemper.alarm.spring;

import com.github.attemper.alarm.AlarmType;
import com.github.attemper.alarm.ContentEntity;
import com.github.attemper.alarm.Information;
import com.github.attemper.alarm.dingtalk.param.text.TextMsg;
import com.github.attemper.alarm.email.EmailInformation;
import com.github.attemper.alarm.wxwork.param.ContentBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {
        "alarm.channel.email.host=smtp.qq.com",
        "alarm.channel.email.username=820704815@qq.com",
        "alarm.channel.email.password=hhhhaiobrrwibeac",
        "alarm.channel.ding-talk.url=https://oapi.dingtalk.com/robot/send?access_token=8d3265518af6dcf99de4b8d6f8a927f75a8f972e98b6dafec0d56e1642531020",
        "alarm.channel.wx-work.url=https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=30a8f590-8250-47e8-bd15-9d37c8a37de8"
})
@ContextConfiguration(classes = {
        AlarmConfiguration.class
})
public class AlarmHandlerTest {

    @Autowired
    private AlarmHandler alarmHandler;

    @Test
    public void sendEmail() throws Exception {
        EmailInformation htmlInfo = new EmailInformation()
                .setTo("2456038733@qq.com,820704815@qq.com")
                .setSubject("你好")
                .setContent("<font color=\"red\">中国</font>");
        alarmHandler.send(AlarmType.EMAIL.getValue(), htmlInfo);
    }

    @Test
    public void sendDingTalk() throws Exception {
        Information info = new TextMsg().setText(new ContentEntity().setContent("任务报错了"));
        alarmHandler.send(AlarmType.DING_TALK.getValue(), info);
    }

    @Test
    public void sendWxWork() throws Exception {
        ContentBody contentBody = new ContentBody();
        contentBody.setContent("任务报错了");
        Information info = new com.github.attemper.alarm.wxwork.param.text.TextMsg().setText(contentBody);
        alarmHandler.send(AlarmType.WX_WORK.getValue(), info);
    }
}
