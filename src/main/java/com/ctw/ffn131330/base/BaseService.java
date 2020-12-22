package com.ctw.ffn131330.base;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public abstract class BaseService <T extends BaseEntity> {

    public abstract BaseRepository<T> getRepository();

    @Transactional
    public T save(T entity){
        return this.getRepository().save(entity);
    }

    public T getById(Long id){
        return this.getRepository().findById(id).<RuntimeException>orElseThrow(() -> new RuntimeException("Entity not found!"));
    }

    @Transactional
    public void delete(Long id){
        this.getRepository().deleteById(id);
    }

    @Transactional
    public List<T> getAll(){
        return this.getRepository().findAll();
    }
}
