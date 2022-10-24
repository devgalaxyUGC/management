package com.school.manager.manager.services;

import com.school.manager.manager.repository.StudentRepositoryImpl;
import com.school.manager.manager.utility.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

class RemoveStudentTest {

    @Test
    public void execute(){

        EntityManager entityManager = JPAUtil.getEntityManager();

        StudentRepositoryImpl studentDAO = new StudentRepositoryImpl(entityManager);

        entityManager.getTransaction().begin();
        studentDAO.delete(29);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}