package com.ctw.ffn131330.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigInteger;

@NoRepositoryBean
public interface BaseRepository <T extends BaseEntity> extends JpaRepository<T, BigInteger> {

}
