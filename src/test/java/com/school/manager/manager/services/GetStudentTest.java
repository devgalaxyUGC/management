package com.school.manager.manager.services;

import com.school.manager.manager.entity.Student;
import com.school.manager.manager.repository.StudentRepositoryImpl;
import com.school.manager.manager.utility.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

class GetStudentTest {

    @Test
    public void execute(){

        EntityManager entityManager =  JPAUtil.getEntityManager();

        StudentRepositoryImpl repository = new StudentRepositoryImpl(entityManager);

        entityManager.getTransaction().begin();
        Student student = repository.get(29);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(student);
    }
}