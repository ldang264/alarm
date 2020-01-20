package com.github.attemper.alarm;

import com.sun.istack.internal.NotNull;

public class ContentEntity {

    /**
     * 消息内容
     */
    @NotNull
    protected String content;

    public String getContent() {
        return content;
    }

    public ContentEntity setContent(String content) {
        this.content = content;
        return this;
    }
}
