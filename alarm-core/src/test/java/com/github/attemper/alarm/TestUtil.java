package com.github.attemper.alarm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil {

    public static String getContent(String content) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + content;
    }

}
