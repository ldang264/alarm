package com.github.attemper.alarm.enterprisewechat.model.image;

public class ImageBody {

    protected String base64;

    protected String md5;

    public String getBase64() {
        return base64;
    }

    public ImageBody setBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public ImageBody setMd5(String md5) {
        this.md5 = md5;
        return this;
    }
}
