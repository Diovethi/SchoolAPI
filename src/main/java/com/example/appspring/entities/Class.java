package com.example.appspring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Class {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;

    @OneToMany(mappedBy = "classes")
    private List<Lesson> lessons;

    @OneToOne
    private Teacher  form_teacher;

    public Class() {
    }

    public Class(String name, List<Lesson> lessons) {
        this.name = name;
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
