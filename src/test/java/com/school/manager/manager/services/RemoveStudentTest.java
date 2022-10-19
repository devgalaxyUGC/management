package com.school.manager.manager.services;

import com.school.manager.manager.entity.Student;
import com.school.manager.manager.entity.Subject;
import com.school.manager.manager.repository.StudentDAO;
import com.school.manager.manager.repository.SubjectDAO;
import com.school.manager.manager.utility.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import java.util.List;

class RemoveStudentTest {

    @Test
    public void execute(){

        EntityManager entityManager = JPAUtil.getEntityManager();

        Subject chemistry = new Subject("Chemistry");

        Student student = new Student("Bryan", "2B", chemistry);

        StudentDAO studentDAO = new StudentDAO(entityManager);

        entityManager.getTransaction().begin();
        studentDAO.remove(21);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Student.listOfStudents.forEach(System.out::println);
    }
}