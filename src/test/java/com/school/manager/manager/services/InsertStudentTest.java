package com.school.manager.manager.services;

import com.school.manager.manager.entity.Student;
import com.school.manager.manager.entity.Subject;
import com.school.manager.manager.repository.StudentRepositoryImpl;
import com.school.manager.manager.repository.SubjectRepository;
import com.school.manager.manager.utility.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

class InsertStudentTest {

    @Test
    public void execute(){

        EntityManager entityManager =  JPAUtil.getEntityManager();

        Subject computerScience = new Subject("ComputerScience");
        Student student = new Student("Gabriel", "1A", computerScience);

        Student.listOfStudents.add(student);
        Subject.listOfSubjects.add(computerScience);

        SubjectRepository subjectDAO = new SubjectRepository(entityManager);
        StudentRepositoryImpl studentDAO = new StudentRepositoryImpl(entityManager);

        entityManager.getTransaction().begin();

        studentDAO.add(student);
        subjectDAO.add(computerScience);

        entityManager.getTransaction().commit();
        entityManager.close();

        Student.listOfStudents.forEach(System.out::println);
        Subject.listOfSubjects.forEach(System.out::println);
    }
}