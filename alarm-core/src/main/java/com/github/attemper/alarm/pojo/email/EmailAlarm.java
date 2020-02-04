package com.github.attemper.alarm.pojo.email;

import com.github.attemper.alarm.AlarmAdapter;
import com.github.attemper.alarm.Config;
import com.github.attemper.alarm.Information;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

public class EmailAlarm extends AlarmAdapter {

    public EmailAlarm() {
        this.index = 0;
    }

    @Override
    public void send(Config config, Information information) throws Exception {
        final EmailConfig conf = (EmailConfig) config;
        EmailInformation emailInformation = (EmailInformation) information;
        Properties properties = conf.getProperties();
        if (properties == null) {
            properties = new Properties();
        }
        properties.put("mail.smtp.auth","true");
        if (!properties.contains("mail.debug")) {
            properties.put("mail.debug", false);
        }
        if (conf.getHost() != null) {
            properties.put("mail.smtp.host", conf.getHost());
        }
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(conf.getUsername(), conf.getPassword());
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailInformation.getFrom() == null ? conf.getUsername() : emailInformation.getFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailInformation.getTo()));
        message.setSubject(emailInformation.getSubject());
        message.setDataHandler(new DataHandler(new ByteArrayDataSource(emailInformation.getContent(), "text/html")));
        Transport.send(message);
    }

}
