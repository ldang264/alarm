package com.github.attemper.alarm.mail;

import com.github.attemper.alarm.ConfigAdapter;

import java.util.Map;

public class MailConfig extends ConfigAdapter {

    protected String host;

    protected String username;

    protected String password;

    protected Map<String, String> properties;

    public String getHost() {
        return host;
    }

    public MailConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public MailConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MailConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public MailConfig setProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

}
