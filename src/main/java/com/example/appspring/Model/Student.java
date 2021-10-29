package com.example.appspring.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Student extends Person {

    public Student(String name, String email, LocalDate dob ) {
       super(name, email, dob);
    }

    public Student() {
        super();
    }

}
