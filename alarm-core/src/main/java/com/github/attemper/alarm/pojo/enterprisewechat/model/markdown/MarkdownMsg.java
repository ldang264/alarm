package com.github.attemper.alarm.pojo.enterprisewechat.model.markdown;

import com.github.attemper.alarm.Msg;
import com.github.attemper.alarm.pojo.enterprisewechat.model.ContentBody;
import com.sun.istack.internal.NotNull;

public class MarkdownMsg extends Msg {

    @NotNull
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
