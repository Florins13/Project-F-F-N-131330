package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseEntity;
import com.ctw.ffn131330.scoreStats.ScoreStats;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class User extends BaseEntity  implements UserDetails {

    @NonNull
    private String name;

    @NonNull
    private String userName;

    private String password;
    private Boolean locked = false;
    private Boolean enabled = false;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<ScoreStats> scoresStats;

    public User() {
    }

    public User(@NonNull String name, @NonNull String userName, String password, Boolean locked, Boolean enabled, UserRole userRole) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.locked = locked;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
