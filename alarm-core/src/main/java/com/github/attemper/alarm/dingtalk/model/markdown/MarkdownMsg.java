package com.github.attemper.alarm.dingtalk.model.markdown;

import com.github.attemper.alarm.Msg;
import com.github.attemper.alarm.dingtalk.model.AtBody;

public class MarkdownMsg extends Msg {

    protected MarkdownBody markdown;

    protected AtBody at;

    public MarkdownMsg() {
        this.msgtype = "markdown";
    }

    public MarkdownBody getMarkdown() {
        return markdown;
    }

    public MarkdownMsg setMarkdown(MarkdownBody markdown) {
        this.markdown = markdown;
        return this;
    }

    public AtBody getAt() {
        return at;
    }

    public MarkdownMsg setAt(AtBody at) {
        this.at = at;
        return this;
    }
}
