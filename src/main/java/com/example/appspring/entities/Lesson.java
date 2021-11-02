package com.example.appspring.entities;

import javax.persistence.*;

@Entity
@Table
public class Lesson {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="teacher_id",nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="classes_id",nullable = false)
    private Class classes;




    public Lesson() {
    }

    public Lesson(String name, String description, Class Class) {
     setDescription(description);
     setName(name);
     setClasses(Class);
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class Class) {
        this.classes = Class;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
