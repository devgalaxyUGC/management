package com.school.manager.manager.repository;

import com.school.manager.manager.entity.Student;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentDAO {

    private EntityManager entityManager;

    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void register(Student student) {
        entityManager.persist(student);
    }

    public void remove(Integer studentID) {
        Student studentReferenced = entityManager.find(Student.class, studentID);
        entityManager.remove(studentReferenced);
    }

    public void update(Student student) {
        this.entityManager.merge(student);
    }

    public List<Student> getAllStudents() {
        String Jpql = "SELECT s FROM Student s";
        return entityManager.createQuery(Jpql).getResultList();
    }
}
