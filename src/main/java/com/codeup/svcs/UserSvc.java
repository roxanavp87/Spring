package com.codeup.svcs;

import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by roxana on 6/22/17.
 */
@Service("userSvc")
public class UserSvc {
    private UsersRepository usersRepository;

    @Autowired
    public UserSvc(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll() {
        return (List<User>) usersRepository.findAll();
    }

    public void save(User user) {
        usersRepository.save(user);
    }

    public User findOne(long id) {
       return usersRepository.findOne(id);
    }
}
