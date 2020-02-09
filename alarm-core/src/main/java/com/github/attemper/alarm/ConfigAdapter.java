package com.github.attemper.alarm;

public abstract class ConfigAdapter implements Config {

    protected boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public ConfigAdapter setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
