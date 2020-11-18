package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService <User> {

    @Autowired
    private UserRepository repository;

    @Override
    public BaseRepository<User> getRepository() {
        return repository;
    }

    public User checkUserNameNotNull(User usr) throws Exception {

        if(usr.getName().isEmpty()){
            throw new Exception(usr.getName());
        }
        return usr;
    }
}
