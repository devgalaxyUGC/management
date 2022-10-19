package com.school.manager.manager.services;

import com.school.manager.manager.entity.Student;
import com.school.manager.manager.entity.Subject;
import com.school.manager.manager.repository.IStudentRepository;
import com.school.manager.manager.repository.ISubjectRepository;
import com.school.manager.manager.utility.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

class GetStudentTest {

    @Test
    public void execute(){

        EntityManager entityManager =  JPAUtil.getEntityManager();

        IStudentRepository repository = new IStudentRepository(entityManager);

        entityManager.getTransaction().begin();
        Student student = repository.get(29);
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(student);
    }
}