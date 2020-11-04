package com.ctw.ffn131330.utils;

import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EntityManager {

    @PersistenceContext
    private javax.persistence.EntityManager entityManager;

    public void saveObject(Object object){
        entityManager.persist(object);
//        entityManager.flush();
    }
}
