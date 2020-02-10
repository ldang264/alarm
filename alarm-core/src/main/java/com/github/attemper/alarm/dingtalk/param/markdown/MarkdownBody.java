package com.github.attemper.alarm.dingtalk.param.markdown;

public class MarkdownBody {

    /**
     * 首屏会话透出的展示内容<br>
     * <b>非空</b>
     */
    protected String title;

    /**
     * markdown格式的消息<br>
     * <b>非空</b>
     */
    protected String text;

    public String getTitle() {
        return title;
    }

    public MarkdownBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public MarkdownBody setText(String text) {
        this.text = text;
        return this;
    }
}
