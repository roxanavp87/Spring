package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roxana on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    private List<Post> posts;
    private PostsRepository postsRepository;

    @Autowired
    public PostSvc(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
//        this.posts = (List<Post>) postsRepository.findAll();
    }

    public PostSvc() {
        this.posts = new ArrayList<>();
    }

    public List<Post> all() {
        return (List<Post>) postsRepository.findAll();
    }

    public void createPost(Post post) {
        postsRepository.save(post);
    }

    public Post findByTitle(String title) {
        for (Post post: posts) {
            if(post.getTitle().equalsIgnoreCase(title)) {
                return post;
            }
        }
        return null;
    }

    public Post findById(long id) {
        return postsRepository.findOne(id);
    }

    public void update(Post post) {
        posts.set((int)post.getId(), post);
    }
}
