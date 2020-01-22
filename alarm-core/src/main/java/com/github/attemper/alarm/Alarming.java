package com.github.attemper.alarm;

import java.util.List;

public interface Alarming {

    void send(Config config, Information information) throws Exception;

    void send(Config config, List<Information> information) throws Exception;
}
