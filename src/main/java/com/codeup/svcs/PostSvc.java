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
    private PostsRepository postsRepository;

    @Autowired
    public PostSvc(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public List<Post> all() {
        return (List<Post>) postsRepository.findAll();
    }

    public void createPost(Post post) {
        postsRepository.save(post);
    }

    public Post findByTitle(String title) {
        return postsRepository.findByTitle(title);
    }

    public Post findById(long id) {
        return postsRepository.findOne(id);
    }

    public void update(Post post) {
        //To Do: update post
        String title = post.getTitle();
        long id = post.getId();
//        Post fpost = postsRepository.findOne(post.getId());
        postsRepository.save(post);
    }
}
