package com.github.attemper.alarm.pojo.enterprisewechat.model.text;

import com.github.attemper.alarm.Msg;
import com.github.attemper.alarm.pojo.enterprisewechat.model.ContentBody;
import com.sun.istack.internal.NotNull;

public class TextMsg extends Msg {

    @NotNull
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
