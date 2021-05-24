package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.exceptions.GenericException;
import com.ctw.ffn131330.match.Match;
import com.ctw.ffn131330.scoreStats.ScoreStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService extends BaseService <User> {

    @Autowired
    private UserRepository repository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public BaseRepository<User> getRepository() {
        return repository;
    }

/*    public User checkUserNameNotNull(User usr) throws Exception {

        if(usr.getName().isEmpty()){
            throw new Exception(usr.getName());
        }
        return usr;
    }*/

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
        a.setUserName("fatihM");
        a.setUserActive(true);
        User b = new User();
        b.setName("nuno");
        b.setUserName("nunoR");
        b.setUserActive(true);
        User c = new User();
        c.setName("johny");
        c.setUserName("johnyB");
        c.setUserActive(true);
        User d = new User();
        d.setName("florin");
        d.setUserName("florinS");
        d.setUserActive(true);

        repository.saveAll(Arrays.asList(a,b,c,d));
    }

    public List<Match> getMatchByUsrId(Long userId){
        CriteriaBuilder cb = em.getCriteriaBuilder(); // this instantiate the tool to allow us to query -- builder
        CriteriaQuery<Match> queryMatches = cb.createQuery(Match.class); // we use tool to query by passing the type, so this selects from score stats
        Root<ScoreStats> c = queryMatches.from(ScoreStats.class);
        Predicate user = cb.equal(c.get("user"),userId);
        queryMatches.select(c.get("match")).where(user);
        return em.createQuery(queryMatches).getResultList();

        // create querybuilder
        // fetch scoreStats where userid = x;
        // 2 options, create a list in java or create a query that will get scoreStats from the respective match
        // homework, querybuilder,

        // Basically the predicate means the condition after where, like in our case we check where user = "our argument"
        // then we use the criteriaQuery to select (c.get(this will return our match) where (our predicate, CONDITION)
    };

    public User getUserByUserName(String username) {
        return repository.findByUserName(username);
    };

}
