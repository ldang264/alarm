package com.github.attemper.alarm;

import java.util.ArrayList;
import java.util.List;

public abstract class AlarmAdapter implements Alarming, Indexing {

    @Override
    public List<Reply> send(Config config, List<Information> informations) throws Exception {
        List<Reply> replys = new ArrayList<Reply>();
        if (informations != null && informations.size() > 0) {
            for (Information information : informations) {
                replys.add(this.send(config, information));
            }
        }
        return replys;
    }

}
