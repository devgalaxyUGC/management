package com.school.manager.manager.repository;

import com.school.manager.manager.entity.Subject;
import jakarta.persistence.EntityManager;

public class ISubjectRepository implements IEntityGeneric<Subject> {

    private EntityManager entityManager;

    public ISubjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Subject get(Integer idEntity) {
        return this.entityManager.getReference(Subject.class, idEntity);
    }

    @Override
    public void add(Subject subject) {
        this.entityManager.persist(subject);
    }

    @Override
    public void put(Subject subject) {
        this.entityManager.merge(subject);
    }

    @Override
    public void delete(Integer idEntity) {
        Subject subjectReferenced = entityManager.find(Subject.class, idEntity);
        entityManager.remove(subjectReferenced);
    }
}
