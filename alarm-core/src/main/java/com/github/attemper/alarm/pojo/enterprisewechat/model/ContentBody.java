package com.github.attemper.alarm.pojo.enterprisewechat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.attemper.alarm.ContentEntity;

public class ContentBody extends ContentEntity {

    /**
     * userid的列表，提醒群中的指定成员(@某个成员)，@all表示提醒所有人，如果开发者获取不到userid，可以使用mentioned_mobile_list
     */
    @JsonProperty("mentionedList")
    protected String[] mentionedList;

    /**
     * 手机号列表，提醒手机号对应的群成员(@某个成员)，@all表示提醒所有人
     */
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
