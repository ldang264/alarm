package com.github.attemper.alarm;

import java.util.List;

public interface Alarming {

    Reply send(Config config, Information information) throws Exception;

    List<Reply> send(Config config, List<Information> informationList) throws Exception;
}
