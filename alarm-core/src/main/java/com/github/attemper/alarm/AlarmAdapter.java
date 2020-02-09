package com.github.attemper.alarm;

import java.util.List;

public abstract class AlarmAdapter extends Indexed implements Alarming {

    @Override
    public void send(Config config, List<Information> informations) throws Exception {
        if (informations != null && informations.size() > 0) {
            for (Information information : informations) {
                this.send(config, information);
            }
        }
    }

}
