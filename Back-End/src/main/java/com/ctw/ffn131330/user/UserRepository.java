package com.ctw.ffn131330.user;

import com.ctw.ffn131330.base.BaseRepository;

import java.util.Optional;


public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUserName(String name);
    Optional<User> findByEmail(String email);
}
