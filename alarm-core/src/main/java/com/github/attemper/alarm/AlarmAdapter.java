package com.github.attemper.alarm;

import java.util.List;

public abstract class AlarmAdapter implements Alarming {

    protected int index;

    @Override
    public void send(Config config, List<Information> informations) throws Exception {
        if (informations != null && informations.size() > 0) {
            for (Information information : informations) {
                this.send(config, information);
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public AlarmAdapter setIndex(int index) {
        this.index = index;
        return this;
    }
}
