package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.exceptions.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    public User check5chars(User usr) {
        if(usr.getName().length() < 5){
            return repository.save(usr);
        }
        else if (usr.getName().length() < 6){
            throw new GenericException.UserExceptions("USer lower then 5 char");
        }
        else if (usr.getName().length() == 7){
            throw new RuntimeException("This is runtime");
        }
        else throw new GenericException.TestException("Test exception message");
    }

    public void saveDefault() {
        User a = new User();
        a.setName("fatih");
        a.setUserActive(true);
        User b = new User();
        b.setName("nuno");
        b.setUserActive(true);
        User c = new User();
        c.setName("johny");
        c.setUserActive(true);
        User d = new User();
        d.setName("florin");
        d.setUserActive(true);

        repository.saveAll(Arrays.asList(a,b,c,d));
    }
}
