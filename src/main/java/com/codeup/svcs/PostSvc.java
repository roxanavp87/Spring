package com.codeup.svcs;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roxana on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    private List<Post> posts;

    public PostSvc() {
        this.posts = new ArrayList<>();
    }

    public List<Post> all() {
        return posts;
    }

    public void createPost(String title, String body) {
        posts.add(new Post(title, body));
    }

    public Post findByTitle(String title) {
        for (Post post: posts) {
            if(post.getTitle().equalsIgnoreCase(title)) {
                return post;
            }
        }
        return null;
    }
}
