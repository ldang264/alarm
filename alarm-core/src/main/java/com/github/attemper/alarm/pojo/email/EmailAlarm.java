package com.github.attemper.alarm.pojo.email;

import com.github.attemper.alarm.AlarmAdapter;
import com.github.attemper.alarm.Config;
import com.github.attemper.alarm.Information;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailAlarm extends AlarmAdapter {

    /** The default protocol: 'smtp'. */
    private static final String DEFAULT_PROTOCOL = "smtp";

    public EmailAlarm() {
        this.index = 0;
    }

    @Override
    public void send(Config config, Information information) throws Exception {
        final EmailConfig conf = (EmailConfig) config;
        EmailInformation emailInformation = (EmailInformation) information;
        Session session = Session.getInstance(conf.getProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(conf.getUsername(), conf.getPassword());
            }
        });

        String protocol = session.getProperty("mail.transport.protocol");
        if (protocol == null) {
            protocol = DEFAULT_PROTOCOL;
        }
        //Transport transport = session.getTransport(protocol);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailInformation.getFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailInformation.getTo()));
        message.setSubject(emailInformation.getSubject());
        message.setText(emailInformation.getContent());
        Transport.send(message);
    }

}
