package com.codeup.models;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 * Created by roxana on 6/19/17.
 */

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column()
    private String body;

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImg> images;

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
