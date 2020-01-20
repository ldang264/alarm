package com.github.attemper.alarm;

public abstract class Msg {

    protected String msgtype;

    public String getMsgtype() {
        return msgtype;
    }

    public Msg setMsgtype(String msgtype) {
        this.msgtype = msgtype;
        return this;
    }
}
