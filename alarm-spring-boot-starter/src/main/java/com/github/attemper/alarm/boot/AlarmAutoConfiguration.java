package com.github.attemper.alarm.boot;

import com.github.attemper.alarm.ConfigAdapter;
import com.github.attemper.alarm.Store;
import com.github.attemper.alarm.spring.AlarmHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;

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
        Class<? extends AlarmProperties.ChannelConfig> channelClass = channel.getClass();
        Field[] declaredFields = channelClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean accessible = declaredField.isAccessible();
            declaredField.setAccessible(true);
            try {
                ConfigAdapter config = (ConfigAdapter) declaredField.get(channel);
                if (Store.getConfigMap().containsKey(config.getIndex())) {
                    throw new RuntimeException("The index " + config.getIndex() + " of alarm's config is duplicated");
                }
                Store.getConfigMap().put(config.getIndex(), config);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } finally {
                declaredField.setAccessible(accessible);
            }
        }
    }
}
