package com.github.attemper.alarm.spring.email;

import com.github.attemper.alarm.ConfigAdapter;
import com.github.attemper.alarm.email.EmailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class EmailValueInjection extends EmailConfig {

    @Value("${alarm.channel.email.enabled:true}")
    @Override
    public ConfigAdapter setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    @Override
    @Value("${alarm.channel.email.host}")
    public EmailConfig setHost(String host) {
        return super.setHost(host);
    }

    @Override
    @Value("${alarm.channel.email.username}")
    public EmailConfig setUsername(String username) {
        return super.setUsername(username);
    }

    @Override
    @Value("${alarm.channel.email.password}")
    public EmailConfig setPassword(String password) {
        return super.setPassword(password);
    }

    @Value("#{${alarm.channel.email.properties:null}}")
    @Override
    public EmailConfig setProperties(Map<String, String> properties) {
        return super.setProperties(properties);
    }
}
