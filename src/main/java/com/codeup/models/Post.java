package com.codeup.models;

/**
 * Created by roxana on 6/19/17.
 */
public class Post {
    private static long id = 0;
    private String title;
    private String body;

    public Post(String title, String body) {
        id ++;
        this.title = title;
        this.body = body;
    }

    public Post() {
        this.title = "";
        this.body = "";
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
