package com.github.attemper.alarm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {

    public static Map<String, Object> bean2Map(Object obj) {
        if (obj == null) {
            return new HashMap<String, Object>();
        }
        try {
            return new ObjectMapper().readValue(bean2JsonStr(obj), Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T map2Bean (Class<T> t, Map<String, Object> map) {
        try {
            return new ObjectMapper().readValue(bean2JsonStr(map), t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String bean2JsonStr(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
