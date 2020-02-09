package com.github.attemper.alarm.spring;

import com.github.attemper.alarm.AlarmAdapter;
import com.github.attemper.alarm.Alarming;
import com.github.attemper.alarm.Information;
import com.github.attemper.alarm.Store;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class AlarmHandler {

    private static Logger log = LoggerFactory.getLogger(AlarmHandler.class);

    private static Map<Integer, Class<? extends AlarmAdapter>> alarms
            = new HashMap<Integer, Class<? extends AlarmAdapter>>();

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

    public void send(int index, Information information) throws Exception {
        if (!alarms.containsKey(index)) {
            throw new RuntimeException("The alarm " + index + " is non-existent");
        } else if (!Store.getConfigMap().containsKey(index)) {
            throw new RuntimeException("The config " + index + " is non-existent");
        }
        Class<? extends AlarmAdapter> alarmClazz = alarms.get(index);
        AlarmAdapter alarmAdapter = newInstance(alarmClazz);
        alarmAdapter.send(Store.getConfigMap().get(index), information);
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
