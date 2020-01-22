package com.github.attemper.alarm;

import com.sun.istack.internal.NotNull;

public class ContentEntity {

    /**
     * 文本内容，最长不超过2048个字节，必须是utf8编码
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
