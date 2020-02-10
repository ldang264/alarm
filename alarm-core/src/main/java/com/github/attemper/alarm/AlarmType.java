package com.github.attemper.alarm;

public enum AlarmType {
    EMAIL(0),

    DING_TALK(1),

    WX_WORK(2);

    private int value;

    AlarmType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
