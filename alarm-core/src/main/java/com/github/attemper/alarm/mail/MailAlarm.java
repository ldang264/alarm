package com.github.attemper.alarm.mail;

import com.github.attemper.alarm.*;
import org.apache.commons.lang.StringUtils;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

public class MailAlarm extends AlarmAdapter {

    @Override
    public Reply sendInternal(Config config, Information information) throws Exception {
        final MailConfig conf = (MailConfig) config;
        MailInformation mailInformation = (MailInformation) information;
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
        message.setFrom(new InternetAddress(mailInformation.getFrom() == null ? conf.getUsername() : mailInformation.getFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailInformation.getTo()));
        message.setSubject(mailInformation.getSubject());
        message.setDataHandler(new DataHandler(new ByteArrayDataSource(mailInformation.getContent(), "text/html")));
        if (StringUtils.isNotBlank(conf.getUsername())) {
            Transport.send(message, conf.getUsername(), conf.getPassword());
        } else {
            Transport.send(message);
        }
        return null;
    }

    @Override
    public int getIndex() {
        return AlarmType.MAIL.getValue();
    }
}
