package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseRepository;
import com.ctw.ffn131330.base.BaseService;
import com.ctw.ffn131330.exceptions.GenericException;
import com.ctw.ffn131330.login.Login;
import com.ctw.ffn131330.match.Match;
import com.ctw.ffn131330.scoreStats.ScoreStats;
import com.ctw.ffn131330.utils.UserAuthDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserService extends BaseService<User> implements UserDetailsService {

    private final static String USER_NOT_FOUND = "username %s not found!";
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public BaseRepository<User> getRepository() {
        return userRepository;
    }

    public User check5chars(User usr) {
        if (usr.getName().length() < 5) {
            return userRepository.save(usr);
        } else if (usr.getName().length() < 6) {
            throw new GenericException.UserExceptions("USer lower then 5 char");
        } else if (usr.getName().length() == 7) {
            throw new RuntimeException("This is runtime");
        } else throw new GenericException.TestException("Test exception message");
    }

    public void saveDefault() {
        User a = new User();
        a.setName("fatih");
        a.setUserName("fatihM");
        User b = new User();
        b.setName("nuno");
        b.setUserName("nunoR");
        User c = new User();
        c.setName("johny");
        c.setUserName("johnyB");
        c.setPassword(passwordEncoder.encode("randomPassword"));
        c.setUserRole(UserRole.ADMIN);
        User d = new User();
        d.setName("florin");
        d.setUserName("florinS");

        userRepository.saveAll(Arrays.asList(a, b, c, d));
    }

    public List<Match> getMatchByUsrId(Long userId) {
        CriteriaBuilder cb = em.getCriteriaBuilder(); // this instantiate the tool to allow us to query -- builder
        CriteriaQuery<Match> queryMatches = cb.createQuery(Match.class); // we use tool to query by passing the type, so this selects from score stats
        Root<ScoreStats> c = queryMatches.from(ScoreStats.class);
        Predicate user = cb.equal(c.get("user"), userId);
        queryMatches.select(c.get("match")).where(user);
        return em.createQuery(queryMatches).getResultList();

        // create querybuilder
        // fetch scoreStats where userid = x;
        // 2 options, create a list in java or create a query that will get scoreStats from the respective match
        // homework, querybuilder,

        // Basically the predicate means the condition after where, like in our case we check where user = "our argument"
        // then we use the criteriaQuery to select (c.get(this will return our match) where (our predicate, CONDITION)
    }

    ;

    public User getUserByUserName(String username) {
        return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
    }


    public User checkPassword(String username, String password) throws Exception {
        if (passwordEncoder.matches(password, userRepository.findByUserName(username).get().getPassword())) {
            return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
        } else {
            throw new GenericException.UserExceptions("password not correct");
        }
    }

    public UserAuthDetails getAuthenticatedUser(Login loginCredentials) throws Exception {
        User user = checkPassword(loginCredentials.getUsername(), loginCredentials.getPassword());
        UserAuthDetails userAuthDetails = new UserAuthDetails(
                user,
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        return userAuthDetails;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
    }

    public void singUpUser(User user) {
        boolean userEmailExists = userRepository.findByEmail(user.getEmail()).isPresent();
        boolean userNameExists = userRepository.findByUserName(user.getUsername()).isPresent();
        if (userEmailExists || userNameExists) throw new IllegalStateException("Username or email already exists.");
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userRepository.save(user);
    }
}
