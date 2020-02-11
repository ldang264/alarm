package com.github.attemper.alarm;

import java.util.ArrayList;
import java.util.List;

public abstract class AlarmAdapter implements Alarming, Indexing {

    @Override
    public Reply send(Config config, Information information) throws Exception {
        if (config == null) {
            throw new RuntimeException("config is null");
        } else if (!((ConfigAdapter) config).isEnabled()){
            return null;
        }
        if (information == null) {
            throw new RuntimeException("information is null");
        }
        return sendInternal(config, information);
    }

    protected abstract Reply sendInternal(Config config, Information information) throws Exception;

    @Override
    public List<Reply> send(Config config, List<Information> informationList) throws Exception {
        List<Reply> replys = new ArrayList<Reply>();
        if (informationList != null && informationList.size() > 0) {
            for (Information information : informationList) {
                replys.add(this.send(config, information));
            }
        }
        return replys;
    }

}
