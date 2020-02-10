package com.github.attemper.alarm.spring.mail;

import com.github.attemper.alarm.ConfigAdapter;
import com.github.attemper.alarm.mail.MailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class MailValueInjection extends MailConfig {

    @Value("${alarm.channel.mail.enabled:true}")
    @Override
    public ConfigAdapter setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    @Override
    @Value("${alarm.channel.mail.host}")
    public MailConfig setHost(String host) {
        return super.setHost(host);
    }

    @Override
    @Value("${alarm.channel.mail.username}")
    public MailConfig setUsername(String username) {
        return super.setUsername(username);
    }

    @Override
    @Value("${alarm.channel.mail.password}")
    public MailConfig setPassword(String password) {
        return super.setPassword(password);
    }

    @Value("#{${alarm.channel.mail.properties:null}}")
    @Override
    public MailConfig setProperties(Map<String, String> properties) {
        return super.setProperties(properties);
    }
}
