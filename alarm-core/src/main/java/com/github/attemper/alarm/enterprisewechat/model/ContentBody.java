package com.github.attemper.alarm.enterprisewechat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.attemper.alarm.ContentEntity;

public class ContentBody extends ContentEntity {

    @JsonProperty("mentionedList")
    protected String[] mentionedList;

    @JsonProperty("mentionedMobileList")
    protected String[] mentionedMobileList;

    public String[] getMentionedList() {
        return mentionedList;
    }

    public ContentBody setMentionedList(String[] mentionedList) {
        this.mentionedList = mentionedList;
        return this;
    }

    public String[] getMentionedMobileList() {
        return mentionedMobileList;
    }

    public ContentBody setMentionedMobileList(String[] mentionedMobileList) {
        this.mentionedMobileList = mentionedMobileList;
        return this;
    }
}
