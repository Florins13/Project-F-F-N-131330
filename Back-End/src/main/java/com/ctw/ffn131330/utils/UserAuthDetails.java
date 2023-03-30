package com.ctw.ffn131330.utils;

import com.ctw.ffn131330.user.User;
import com.ctw.ffn131330.user.UserRole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserAuthDetails {
    private String name;
    private String username;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean isAuthenticated;
    private Boolean isEnabled;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserAuthDetails(String name, String username, UserRole userRole, Boolean isAuthenticated, Boolean isEnabled) {
        this.name = name;
        this.username = username;
        this.userRole = userRole;
        this.isAuthenticated = isAuthenticated;
        this.isEnabled = isEnabled;

    }

    public UserAuthDetails(User user, Boolean isAuthenticated, String token) {
        this(user.getName(), user.getUsername(), user.getUserRole(), isAuthenticated, user.isEnabled());
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

}
