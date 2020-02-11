package com.github.attemper.alarm.wxwork;

import com.github.attemper.alarm.*;
import com.github.attemper.alarm.wxwork.param.ContentBody;
import com.github.attemper.alarm.wxwork.param.markdown.MarkdownMsg;
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
    public void testTextWithMentionedList() throws Exception {
        ContentBody contentBody = new ContentBody().setMentionedList(TestConstants.MENTIONED);
        contentBody.setContent(TestUtil.getContent(TestConstants.TEXT));
        Information info = new TextMsg().setText(contentBody);
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }

    @Test
    public void testTextWithMentionedMobileList() throws Exception {
        ContentBody contentBody = new ContentBody().setMentionedMobileList(TestConstants.PHONE);
        contentBody.setContent(TestUtil.getContent(TestConstants.TEXT));
        Information info = new TextMsg().setText(contentBody);
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }

    @Test
    public void testMarkdownWithMentionedList() throws Exception {
        Information info = new MarkdownMsg().setMarkdown(new ContentEntity().setContent(TestUtil.getContent(TestConstants.MARKDOWN)));
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }

    @Test
    public void testMarkdownWithMentionedMobileList() throws Exception {
        Information info = new MarkdownMsg().setMarkdown(new ContentEntity().setContent(TestUtil.getContent(TestConstants.MARKDOWN)));
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }
}