package com.school.manager.manager.repository;

import com.school.manager.manager.entity.Student;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepositoryImpl implements IEntityGeneric<Student>{

    private final EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student get(Integer idEntity) {
        return entityManager.find(Student.class, idEntity);
    }

    public List<Student> getAllStudents() {
        String Jpql = "SELECT s FROM Student s";
        return entityManager.createQuery(Jpql).getResultList();
    }

    @Override
    public void add(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public void put(Student student) {
        Student studentReferenced = entityManager.merge(student);
    }

    @Override
    public void delete(Integer idStudent) {
        Student studentReferenced = entityManager.find(Student.class, idStudent);
        Student studentMerged = entityManager.merge(studentReferenced);
        entityManager.remove(studentMerged);
    }

    // TEntity create(String nome, String email);
}
