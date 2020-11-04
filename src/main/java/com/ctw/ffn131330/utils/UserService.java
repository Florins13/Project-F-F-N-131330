package com.ctw.ffn131330.utils;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
    public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

            public void insert(BaseEntity baseEntity){
            entityManager.persist(baseEntity);
        }

        public BaseEntity find(long id) {
            return entityManager.find(BaseEntity.class, id);
    }
}
