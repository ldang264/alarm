package com.github.attemper.alarm.email;

import com.github.attemper.alarm.Reply;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmailAlarmTest {

    private static EmailAlarm alarm;

    private static EmailConfig config;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        alarm = new EmailAlarm();
        config = new EmailConfig()
                .setHost("smtp.qq.com")
                .setUsername("820704815@qq.com")
                .setPassword("hhhhaiobrrwibeac");

    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSend() throws Exception {
        EmailInformation htmlInfo = new EmailInformation()
                .setTo("2456038733@qq.com,820704815@qq.com")
                .setSubject("你好")
                .setContent("<font color=\"red\">中国</font>");
        Reply reply = alarm.send(config, htmlInfo);
        Assert.assertTrue(reply == null);
    }

}