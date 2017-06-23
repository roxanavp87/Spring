package com.codeup.repositories;

import com.codeup.models.PostImg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by roxana on 6/23/17.
 */

@Repository
public interface PostsImgRepository extends CrudRepository<PostImg, Long> {
//    public List<String> findAllByPost(long post_id);

    public List<String> getAllUrlByPost(long post_id);

    public List<PostImg> findAllByPost(long post_id);
}
