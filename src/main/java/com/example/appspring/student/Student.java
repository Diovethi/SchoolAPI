package com.example.appspring.student;

import com.example.appspring.person.Person;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student extends Person {

    public Student( Long id,String name, String email, LocalDate dob) {
        super(id,name,email,dob);
    }

    public Student(String name, String email, LocalDate dob ) {
       super(name, email, dob);
    }

    public Student() {
        super();
    }

}
