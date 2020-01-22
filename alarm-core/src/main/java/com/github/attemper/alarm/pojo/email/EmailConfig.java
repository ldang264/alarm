package com.github.attemper.alarm.pojo.email;

import com.github.attemper.alarm.Config;

import java.util.Properties;

public class EmailConfig implements Config {

    protected Properties properties;

    protected String username;

    protected String password;

    public Properties getProperties() {
        return properties;
    }

    public EmailConfig setProperties(Properties properties) {
        this.properties = properties;
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
}
