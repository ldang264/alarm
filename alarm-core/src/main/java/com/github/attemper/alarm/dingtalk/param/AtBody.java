package com.github.attemper.alarm.dingtalk.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtBody {

    /**
     * 被@人的手机号(在content里添加@人的手机号)
     */
    protected String[] atMobiles;

    @JsonProperty("isAtAll")
    protected Boolean atAll;

    public String[] getAtMobiles() {
        return atMobiles;
    }

    public AtBody setAtMobiles(String... atMobiles) {
        this.atMobiles = atMobiles;
        return this;
    }

    public Boolean getAtAll() {
        return atAll;
    }

    public AtBody setAtAll(Boolean atAll) {
        this.atAll = atAll;
        return this;
    }
}
