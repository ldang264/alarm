package com.github.attemper.alarm.wxwork.param.markdown;

import com.github.attemper.alarm.Msg;
import com.github.attemper.alarm.wxwork.param.ContentBody;

public class MarkdownMsg extends Msg {

    protected ContentBody markdown;

    public MarkdownMsg() {
        this.msgtype = "markdown";
    }

    public ContentBody getMarkdown() {
        return markdown;
    }

    public MarkdownMsg setMarkdown(ContentBody markdown) {
        this.markdown = markdown;
        return this;
    }
}
