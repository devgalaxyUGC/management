package com.school.manager.manager.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String student_name;
    private String student_class;
    private LocalDate student_entrance_date = LocalDate.now();

    @ManyToOne
    private Subject subject;

    public Student(String student_name, String student_class, Subject subject) {
        this.student_name = student_name;
        this.student_class = student_class;
        this.subject = subject;
    }

    protected Student(){

    }

    public static List<Student> listOfStudents = new ArrayList<>();

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_class() {
        return student_class;
    }

    public Long getId() {
        return id;
    }

    public String toString(){
        return "Student Name: " + getStudent_name() +
                "\nStudent Class: " + getStudent_class() +
                "\nID: " + getId();
    }
}
