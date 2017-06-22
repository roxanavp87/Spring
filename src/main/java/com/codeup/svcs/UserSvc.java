package com.codeup.svcs;

import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by roxana on 6/22/17.
 */
@Service("usersSvc")
public class UserSvc {
    private UsersRepository usersRepository;

    @Autowired
    public UserSvc(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
