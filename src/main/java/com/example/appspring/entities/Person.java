package com.example.appspring.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;

    @Transient
    private Integer age;
    private LocalDate dob;
    private String email;

    public Person(Long id, String name, String email , LocalDate dob) {
        setId(id);
        setName(name);
        setEmail(email);
        setDob(dob);
    }

    public Person(String name, String email , LocalDate dob) {
        setName(name);
        setEmail(email);
        setDob(dob);
    }

    public Person() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {

        return Period.between(dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }

}
