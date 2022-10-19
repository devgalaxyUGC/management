package com.school.manager.manager.services;

import com.school.manager.manager.entity.Student;
import com.school.manager.manager.entity.Subject;
import com.school.manager.manager.repository.StudentDAO;
import com.school.manager.manager.repository.SubjectDAO;
import com.school.manager.manager.utility.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

class InsertStudentTest {

    @Test
    public void execute(){

        EntityManager entityManager =  JPAUtil.getEntityManager();

        Subject chemistry = new Subject("Chemistry");
        Student student = new Student("Bryan", "2B", chemistry);

        Student.listOfStudents.add(student);
        Subject.listOfSubjects.add(chemistry);

        SubjectDAO subjectDAO = new SubjectDAO(entityManager);
        StudentDAO studentDAO = new StudentDAO(entityManager);

        entityManager.getTransaction().begin();

        studentDAO.register(student);
        subjectDAO.register(chemistry);

        entityManager.getTransaction().commit();
        entityManager.close();

        Student.listOfStudents.forEach(System.out::println);
        Subject.listOfSubjects.forEach(System.out::println);
    }
}