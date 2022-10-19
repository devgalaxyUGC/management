package com.school.manager.manager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String Name;
    public static List<Subject> listOfSubjects = new ArrayList<>();

    public Subject(String name) {
        Name = name;
    }

    protected Subject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String toString(){
        return "Subject: " + this.getName();
    }
}
