package com.github.attemper.alarm.pojo.email;

import com.github.attemper.alarm.AlarmAdapter;
import com.github.attemper.alarm.AlarmType;
import com.github.attemper.alarm.Config;
import com.github.attemper.alarm.Information;
import org.apache.commons.lang.StringUtils;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

public class EmailAlarm extends AlarmAdapter {

    public EmailAlarm() {
        this.index = AlarmType.EMAIL.getValue();
    }

    @Override
    public void send(Config config, Information information) throws Exception {
        final EmailConfig conf = (EmailConfig) config;
        EmailInformation emailInformation = (EmailInformation) information;
        Properties properties = new Properties();
        if (conf.getProperties() != null && conf.getProperties().size() > 0) {
            properties.putAll(conf.getProperties());
        }
        if (!properties.contains("mail.debug")) {
            properties.put("mail.debug", false);
        }
        if (conf.getHost() != null) {
            properties.put("mail.smtp.host", conf.getHost());
        }
        Session session = Session.getDefaultInstance(properties, null);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailInformation.getFrom() == null ? conf.getUsername() : emailInformation.getFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailInformation.getTo()));
        message.setSubject(emailInformation.getSubject());
        message.setDataHandler(new DataHandler(new ByteArrayDataSource(emailInformation.getContent(), "text/html")));
        if (StringUtils.isNotBlank(conf.getUsername())) {
            Transport.send(message, conf.getUsername(), conf.getPassword());
        } else {
            Transport.send(message);
        }
    }

}
