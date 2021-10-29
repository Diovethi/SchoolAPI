package com.example.appspring.Model;

import com.example.appspring.Model.Person;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Teacher extends Person {

    public Teacher(String name, String email, LocalDate dob ) {
        super(name, email, dob);
    }

    public Teacher() {
        super();
    }

}
