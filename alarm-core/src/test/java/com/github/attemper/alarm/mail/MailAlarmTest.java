package com.github.attemper.alarm.mail;

import com.github.attemper.alarm.Reply;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MailAlarmTest {

    private static MailAlarm alarm;

    private static MailConfig config;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        alarm = new MailAlarm();
        config = new MailConfig()
                .setHost("smtp.qq.com")
                .setUsername("820704815@qq.com")
                .setPassword("hhhhaiobrrwibeac");

    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSend() throws Exception {
        MailInformation htmlInfo = new MailInformation()
                .setTo("2456038733@qq.com,820704815@qq.com")
                .setSubject("你好")
                .setContent("<font color=\"red\">中国</font>");
        Reply reply = alarm.send(config, htmlInfo);
        Assert.assertEquals(reply, null);
    }

}