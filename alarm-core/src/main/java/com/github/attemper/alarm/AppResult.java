package com.github.attemper.alarm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppResult implements Reply {
    //SEC805400b8286d70b29e1e55cbdfc9f44f6da67cf835305a18ed72af07df5c6602
    @JsonProperty("errcode")
    protected int errCode;

    @JsonProperty("errmsg")
    protected String errMsg;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
