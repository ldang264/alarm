package com.github.attemper.alarm.email;

import com.github.attemper.alarm.ConfigAdapter;

import java.util.Map;

public class EmailConfig extends ConfigAdapter {

    protected String host;

    protected String username;

    protected String password;

    protected Map<String, String> properties;

    public String getHost() {
        return host;
    }

    public EmailConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public EmailConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EmailConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public EmailConfig setProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

}
