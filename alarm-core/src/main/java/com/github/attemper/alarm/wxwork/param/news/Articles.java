package com.github.attemper.alarm.wxwork.param.news;

public class Articles {

    /**
     * 图文消息，一个图文消息支持1到8条图文<br>
     * <b>非空</b>
     */
    protected ArticleBody[] articles;

    public ArticleBody[] getArticles() {
        return articles;
    }

    public Articles setArticles(ArticleBody[] articles) {
        this.articles = articles;
        return this;
    }
}
