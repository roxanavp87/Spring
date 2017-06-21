package com.codeup.models;

/**
 * Created by roxana on 6/19/17.
 */
public class Post {
    private long id;
    private String title;
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() { }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
