package com.ctw.ffn131330.base;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
public abstract class BaseService <T extends BaseEntity> {

    public abstract BaseRepository<T> getRepository();

    @Transactional
    public T save(T entity){
        return this.getRepository().save(entity);
    }

    public T get(BigInteger id){
        return this.getRepository().findById(id).orElse(null);
    }

    @Transactional
    public void delete(BigInteger id){
        this.getRepository().deleteById(id);
    }

    @Transactional
    public List<T> getAll(){
        return this.getRepository().findAll();
    }
}
