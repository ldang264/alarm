package com.github.attemper.alarm.dingtalk;

import com.github.attemper.alarm.*;
import com.github.attemper.alarm.dingtalk.param.AtBody;
import com.github.attemper.alarm.dingtalk.param.markdown.MarkdownBody;
import com.github.attemper.alarm.dingtalk.param.markdown.MarkdownMsg;
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
    public void testTextWithAtMobiles() throws Exception {
        Information info = new TextMsg()
                .setText(new ContentEntity().setContent(TestUtil.getContent(TestConstants.TEXT)))
                .setAt(new AtBody().setAtMobiles(TestConstants.PHONE));
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }

    @Test
    public void testTextWithAtAll() throws Exception {
        Information info = new TextMsg()
                .setText(new ContentEntity().setContent(TestUtil.getContent(TestConstants.TEXT)))
                .setAt(new AtBody().setAtAll(true));
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }

    @Test
    public void testMarkdownWithAtMobiles() throws Exception {
        Information info = new MarkdownMsg()
                .setMarkdown(new MarkdownBody().setTitle(TestConstants.SUBJECT).setText(TestUtil.getContent(TestConstants.MARKDOWN)))
                .setAt(new AtBody().setAtMobiles(TestConstants.PHONE).setAtAll(false));
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }

    @Test
    public void testMarkdownWithAtAll() throws Exception {
        Information info = new MarkdownMsg()
                .setMarkdown(new MarkdownBody().setTitle(TestConstants.SUBJECT).setText(TestUtil.getContent(TestConstants.MARKDOWN)))
                .setAt(new AtBody().setAtAll(true));
        AppReply appReply = (AppReply) alarm.send(config, info);
        Assert.assertEquals(appReply.getErrCode(), 0);
    }
}