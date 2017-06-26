package com.codeup.models;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "Post must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    private String title;

    @Column()
    @NotBlank(message = "Post must have a body")
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

    public List<PostImg> getImages() {
        return images;
    }

    public void setImages(List<PostImg> images) {
        this.images = images;
    }
}
