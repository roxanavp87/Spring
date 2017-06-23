package com.codeup.svcs;

import com.codeup.models.PostImg;
import com.codeup.repositories.PostsImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roxana on 6/23/17.
 */

@Service("postImgSvc")
public class PostImgSvc  {
    private PostsImgRepository postsImgRepository;

    @Autowired
    public PostImgSvc(PostsImgRepository postsImgRepository) {
        this.postsImgRepository = postsImgRepository;
    }

    public PostImg findOne(long post_id) {
        return postsImgRepository.findOne(post_id);
    }


}
