package com.github.attemper.alarm.dingtalk.param.text;

import com.github.attemper.alarm.ContentEntity;
import com.github.attemper.alarm.Msg;
import com.github.attemper.alarm.dingtalk.param.AtBody;

public class TextMsg extends Msg {

    protected ContentEntity text;

    protected AtBody at;

    public TextMsg() {
        this.msgtype = "text";
    }

    public ContentEntity getText() {
        return text;
    }

    public TextMsg setText(ContentEntity text) {
        this.text = text;
        return this;
    }

    public AtBody getAt() {
        return at;
    }

    public TextMsg setAt(AtBody at) {
        this.at = at;
        return this;
    }
}
