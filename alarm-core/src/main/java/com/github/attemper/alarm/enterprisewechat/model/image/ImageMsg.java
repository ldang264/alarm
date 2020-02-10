package com.github.attemper.alarm.enterprisewechat.model.image;

import com.github.attemper.alarm.Msg;

public class ImageMsg extends Msg {

    protected ImageBody image;

    public ImageMsg() {
        this.msgtype = "image";
    }

    public ImageBody getImage() {
        return image;
    }

    public ImageMsg setImage(ImageBody image) {
        this.image = image;
        return this;
    }
}
