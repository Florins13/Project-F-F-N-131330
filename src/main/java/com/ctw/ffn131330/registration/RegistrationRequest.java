package com.ctw.ffn131330.registration;

public class RegistrationRequest {
    private String name;
    private String username;
    private String password;
    private String email;

    public RegistrationRequest(String userName, String password, String email, String name) {
        this.name = name;
        this.username = userName;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
