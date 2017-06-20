package com.codeup.svcs;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roxana on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    private List<Post> posts;

    public List<Post> all() {
        return posts;
    }

    public void createPost(Post post) {
        posts.add(post);
    }

    public Post findOne(String title) {

    }
}
