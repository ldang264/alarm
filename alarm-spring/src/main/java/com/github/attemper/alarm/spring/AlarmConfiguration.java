package com.github.attemper.alarm.spring;

import com.github.attemper.alarm.AlarmType;
import com.github.attemper.alarm.Store;
import com.github.attemper.alarm.spring.dingtalk.DingTalkValueInjection;
import com.github.attemper.alarm.spring.mail.MailValueInjection;
import com.github.attemper.alarm.spring.wxwork.WxWorkValueInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Import({
        MailValueInjection.class,
        DingTalkValueInjection.class,
        WxWorkValueInjection.class,
        AlarmHandler.class
})
@Configuration
public class AlarmConfiguration {

    @Autowired
    private MailValueInjection mailValueInjection;

    @Autowired
    private DingTalkValueInjection dingTalkValueInjection;

    @Autowired
    private WxWorkValueInjection wxWorkValueInjection;

    @PostConstruct
    public void initConfig() {
        Store.getConfigMap().put(AlarmType.MAIL.getValue(), mailValueInjection);
        Store.getConfigMap().put(AlarmType.DING_TALK.getValue(), dingTalkValueInjection);
        Store.getConfigMap().put(AlarmType.WX_WORK.getValue(), wxWorkValueInjection);
    }
}
