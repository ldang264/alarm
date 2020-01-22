package com.github.attemper.alarm.pojo.dingtalk.model;

public class AtBody {

    /**
     * 被@人的手机号(在content里添加@人的手机号)
     */
    protected String[] atMobiles;

    protected Boolean isAtAll;

    public String[] getAtMobiles() {
        return atMobiles;
    }

    public AtBody setAtMobiles(String[] atMobiles) {
        this.atMobiles = atMobiles;
        return this;
    }

    public Boolean getAtAll() {
        return isAtAll;
    }

    public AtBody setAtAll(Boolean atAll) {
        isAtAll = atAll;
        return this;
    }
}
