package com.github.attemper.alarm.wxwork.param.markdown;

import com.github.attemper.alarm.ContentEntity;
import com.github.attemper.alarm.Msg;

public class MarkdownMsg extends Msg {

    protected ContentEntity markdown;

    public MarkdownMsg() {
        this.msgtype = "markdown";
    }

    public ContentEntity getMarkdown() {
        return markdown;
    }

    public MarkdownMsg setMarkdown(ContentEntity markdown) {
        this.markdown = markdown;
        return this;
    }
}
