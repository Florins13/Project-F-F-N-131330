package com.ctw.ffn131330.base;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
public abstract class BaseService <T extends BaseEntity> {

    protected String var;

    public abstract BaseRepository<T> getRepository();

    @Transactional
    public T save(T entity){
        return this.getRepository().save(entity);
    }

    public T get(BigInteger id){
        return this.getRepository().findById(id).get();
    }

    @Transactional
    public void delete(BigInteger id){
        this.getRepository().deleteById(id);
    }
}
