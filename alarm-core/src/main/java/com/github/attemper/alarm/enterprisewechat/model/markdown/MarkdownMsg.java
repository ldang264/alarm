package com.github.attemper.alarm.enterprisewechat.model.markdown;

import com.github.attemper.alarm.Msg;
import com.github.attemper.alarm.enterprisewechat.model.ContentBody;

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
