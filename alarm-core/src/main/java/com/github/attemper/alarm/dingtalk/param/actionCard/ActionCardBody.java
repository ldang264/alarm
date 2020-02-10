package com.github.attemper.alarm.dingtalk.param.actionCard;

public class ActionCardBody {

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

    /**
     * 单个按钮的方案。(设置此项和singleURL后btns无效)
     */
    protected String singleTitle;

    /**
     * 点击singleTitle按钮触发的URL
     */
    protected String singleURL;

    /**
     * 按钮的信息
     */
    protected BtnBody[] btns;

    /**
     * 0-按钮竖直排列，1-按钮横向排列
     */
    protected String btnOrientation;

    /**
     * 0-正常发消息者头像，1-隐藏发消息者头像
     */
    protected String hideAvatar;

    public String getTitle() {
        return title;
    }

    public ActionCardBody setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public ActionCardBody setText(String text) {
        this.text = text;
        return this;
    }

    public String getSingleTitle() {
        return singleTitle;
    }

    public ActionCardBody setSingleTitle(String singleTitle) {
        this.singleTitle = singleTitle;
        return this;
    }

    public String getSingleURL() {
        return singleURL;
    }

    public ActionCardBody setSingleURL(String singleURL) {
        this.singleURL = singleURL;
        return this;
    }

    public BtnBody[] getBtns() {
        return btns;
    }

    public ActionCardBody setBtns(BtnBody[] btns) {
        this.btns = btns;
        return this;
    }

    public String getBtnOrientation() {
        return btnOrientation;
    }

    public ActionCardBody setBtnOrientation(String btnOrientation) {
        this.btnOrientation = btnOrientation;
        return this;
    }

    public String getHideAvatar() {
        return hideAvatar;
    }

    public ActionCardBody setHideAvatar(String hideAvatar) {
        this.hideAvatar = hideAvatar;
        return this;
    }
}
