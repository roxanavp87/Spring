package com.codeup.models;

import javax.persistence.*;

/**
 * Created by roxana on 6/23/17.
 */
@Entity
@Table(name = "posts_img")
public class PostImg {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 1000)
    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public PostImg() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
