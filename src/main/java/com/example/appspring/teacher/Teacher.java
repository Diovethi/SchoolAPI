package com.example.appspring.teacher;

import com.example.appspring.person.Person;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Teacher extends Person {
    public Teacher( Long id,String name, String email, LocalDate dob) {
        super(id,name,email,dob);
    }

    public Teacher(String name, String email, LocalDate dob ) {
        super(name, email, dob);
    }

    public Teacher() {
        super();
    }

}
