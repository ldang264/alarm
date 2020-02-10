package com.github.attemper.alarm.boot;

import com.github.attemper.alarm.dingtalk.DingTalkConfig;
import com.github.attemper.alarm.email.EmailConfig;
import com.github.attemper.alarm.enterprisewechat.EnterpriseWeChatConfig;
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
        private EmailConfig email;

        private DingTalkConfig dingTalk;

        private EnterpriseWeChatConfig enterpriseWeChat;

        public EmailConfig getEmail() {
            return email;
        }

        public void setEmail(EmailConfig email) {
            this.email = email;
        }

        public DingTalkConfig getDingTalk() {
            return dingTalk;
        }

        public void setDingTalk(DingTalkConfig dingTalk) {
            this.dingTalk = dingTalk;
        }

        public EnterpriseWeChatConfig getEnterpriseWeChat() {
            return enterpriseWeChat;
        }

        public void setEnterpriseWeChat(EnterpriseWeChatConfig enterpriseWeChat) {
            this.enterpriseWeChat = enterpriseWeChat;
        }
    }

}
