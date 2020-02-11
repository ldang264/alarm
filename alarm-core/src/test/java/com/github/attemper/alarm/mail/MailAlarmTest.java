package com.github.attemper.alarm.mail;

import com.github.attemper.alarm.Reply;
import com.github.attemper.alarm.TestConstants;
import com.github.attemper.alarm.TestUtil;
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
    public void testHtml() throws Exception {
        MailInformation htmlInfo = new MailInformation()
                .setTo("2456038733@qq.com")
                .setSubject(TestConstants.SUBJECT)
                .setContent(TestUtil.getContent(TestConstants.HTML));
        Reply reply = alarm.send(config, htmlInfo);
        Assert.assertEquals(reply, null);
    }

    @Test
    public void testHtmlToMultiRecipients() throws Exception {
        MailInformation htmlInfo = new MailInformation()
                .setTo("2456038733@qq.com,820704815@qq.com")
                .setSubject(TestConstants.SUBJECT)
                .setContent(TestUtil.getContent(TestConstants.HTML));
        Reply reply = alarm.send(config, htmlInfo);
        Assert.assertEquals(reply, null);
    }
}