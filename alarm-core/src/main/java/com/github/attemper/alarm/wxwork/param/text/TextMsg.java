package com.github.attemper.alarm.wxwork.param.text;

import com.github.attemper.alarm.Msg;
import com.github.attemper.alarm.wxwork.param.ContentBody;

public class TextMsg extends Msg {

    protected ContentBody text;

    public TextMsg() {
        this.msgtype = "text";
    }

    public ContentBody getText() {
        return text;
    }

    public TextMsg setText(ContentBody text) {
        this.text = text;
        return this;
    }
}
