package com.github.attemper.alarm.spring;

import com.github.attemper.alarm.*;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AlarmHandler {

    @Value("${alarm.enabled:true}")
    private boolean enabled;

    private static Logger log = LoggerFactory.getLogger(AlarmHandler.class);

    private static Map<Integer, Class<? extends AlarmAdapter>> alarms = new HashMap<>();

    static {
        Reflections reflections = new Reflections(Alarming.class.getPackage().getName());
        Set<Class<? extends AlarmAdapter>> subTypes = reflections.getSubTypesOf(AlarmAdapter.class);
        if (log.isDebugEnabled()) {
            log.debug("Find {} alarm type(s)", subTypes.size());
        }
        for (Class<? extends AlarmAdapter> subType : subTypes) {
            AlarmAdapter alarmAdapter = newInstance(subType);
            if (alarms.containsKey(alarmAdapter.getIndex())) {
                throw new RuntimeException("The index " + alarmAdapter.getIndex() + " of alarm is duplicated");
            }
            alarms.put(alarmAdapter.getIndex(), subType);
        }
    }

    /**
     * send information via channel
     * @param index the channel order
     * @param information the information
     * @return
     * @throws Exception
     */
    public Reply send(Information information, int index) throws Exception {
        if (!enabled) {
            if (log.isDebugEnabled()) {
                log.debug("The switch isn't enabled, ignore to alarm");
            }
            return null;
        }
        validateIndex(index);
        Class<? extends AlarmAdapter> alarmClazz = alarms.get(index);
        AlarmAdapter alarmAdapter = newInstance(alarmClazz);
        return alarmAdapter.send(Store.getConfigMap().get(index), information);
    }

    private void validateIndex(int... indexes) {
        if (indexes == null || indexes.length == 0) {
            throw new RuntimeException("The indexes can't be null or empty");
        }
        for (int index : indexes) {
            if (!alarms.containsKey(index)) {
                throw new RuntimeException("The alarm " + index + " is non-existent");
            } else if (!Store.getConfigMap().containsKey(index)) {
                throw new RuntimeException("The config " + index + " is non-existent");
            }
        }
    }

    private static AlarmAdapter newInstance(Class<? extends AlarmAdapter> alarmClazz) {
        try {
            return alarmClazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Instantiating alarm occurs error", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Accessing alarm is illegal", e);
        }
    }

}
