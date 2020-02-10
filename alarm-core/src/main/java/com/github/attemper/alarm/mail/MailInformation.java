package com.github.attemper.alarm.mail;

import com.github.attemper.alarm.Information;

public class MailInformation implements Information {
    protected String from;

    protected String to;

    protected String subject;

    protected String content;

    public String getFrom() {
        return from;
    }

    public MailInformation setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public MailInformation setTo(String to) {
        this.to = to;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public MailInformation setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MailInformation setContent(String content) {
        this.content = content;
        return this;
    }
}
