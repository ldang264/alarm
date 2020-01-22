package com.github.attemper.alarm;

import com.github.attemper.alarm.pojo.email.EmailAlarm;
import com.github.attemper.alarm.pojo.email.EmailConfig;
import com.github.attemper.alarm.pojo.email.EmailInformation;
import org.junit.Test;

public class AlarmTest {

    @Test
    public void testEmail() {
        EmailAlarm emailAlarm = new EmailAlarm();
        EmailConfig emailConfig = new EmailConfig().setHost("smtp.qq.com").setUsername("820704815@qq.com").setPassword("dnlhkluwhkdfbcde");
        EmailInformation emailInformation = new EmailInformation().setTo("2456038733@qq.com").setSubject("Hello").setContent("<b>你好</b>");
        try {
            emailAlarm.send(emailConfig, emailInformation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
