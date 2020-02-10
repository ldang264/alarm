package com.github.attemper.alarm.email;

import com.github.attemper.alarm.Information;

public class EmailInformation implements Information {
    protected String from;

    protected String to;

    protected String subject;

    protected String content;

    public String getFrom() {
        return from;
    }

    public EmailInformation setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public EmailInformation setTo(String to) {
        this.to = to;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailInformation setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getContent() {
        return content;
    }

    public EmailInformation setContent(String content) {
        this.content = content;
        return this;
    }
}
