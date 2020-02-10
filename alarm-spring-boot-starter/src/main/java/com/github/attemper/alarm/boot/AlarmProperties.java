package com.github.attemper.alarm.boot;

import com.github.attemper.alarm.dingtalk.DingTalkConfig;
import com.github.attemper.alarm.mail.MailConfig;
import com.github.attemper.alarm.wxwork.WxWorkConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "alarm")
public class AlarmProperties {

    private boolean enabled = true;

    @NestedConfigurationProperty
    private final ChannelConfig channel = new ChannelConfig();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ChannelConfig getChannel() {
        return channel;
    }

    public static class ChannelConfig {
        private MailConfig mail;

        private DingTalkConfig dingTalk;

        private WxWorkConfig wxWork;

        public MailConfig getMail() {
            return mail;
        }

        public void setMail(MailConfig mail) {
            this.mail = mail;
        }

        public DingTalkConfig getDingTalk() {
            return dingTalk;
        }

        public void setDingTalk(DingTalkConfig dingTalk) {
            this.dingTalk = dingTalk;
        }

        public WxWorkConfig getWxWork() {
            return wxWork;
        }

        public void setWxWork(WxWorkConfig wxWork) {
            this.wxWork = wxWork;
        }
    }

}
