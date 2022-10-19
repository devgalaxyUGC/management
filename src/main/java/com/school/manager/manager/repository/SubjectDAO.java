package com.school.manager.manager.repository;

import com.school.manager.manager.entity.Subject;
import jakarta.persistence.EntityManager;

public class SubjectDAO {

    private EntityManager entityManager;

    public SubjectDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(Subject subject){
        entityManager.persist(subject);
    }
}
