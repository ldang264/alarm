package com.github.attemper.alarm.boot;

import com.github.attemper.alarm.AlarmType;
import com.github.attemper.alarm.Store;
import com.github.attemper.alarm.spring.AlarmHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@EnableConfigurationProperties(value = {
        AlarmProperties.class
})
@Import({
        AlarmHandler.class
})
@Configuration
public class AlarmAutoConfiguration {

    @Autowired
    private AlarmProperties alarmProperties;

    @PostConstruct
    public void initConfig() {
        AlarmProperties.ChannelConfig channel = alarmProperties.getChannel();
        Store.getConfigMap().put(AlarmType.EMAIL.getValue(), channel.getEmail());
        Store.getConfigMap().put(AlarmType.DING_TALK.getValue(), channel.getDingTalk());
        Store.getConfigMap().put(AlarmType.WX_WORK.getValue(), channel.getWxWork());
    }
}
