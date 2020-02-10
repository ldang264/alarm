package com.github.attemper.alarm.enterprisewechat.model.news;

import com.sun.istack.internal.NotNull;

public class Articles {

    /**
     * 图文消息，一个图文消息支持1到8条图文
     */
    @NotNull
    protected ArticleBody[] articles;

    public ArticleBody[] getArticles() {
        return articles;
    }

    public Articles setArticles(ArticleBody[] articles) {
        this.articles = articles;
        return this;
    }
}
