package com.example.appspring.entities;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Teacher extends Person  {

//    @OneToMany(mappedBy = "teacher")
//    @Cascade(CascadeType.ALL)
//    private List<Lesson> lessons;

//    @OneToOne
//    private Class coordinated_class;

    public Teacher(String name, String email, LocalDate dob ) {
        super(name, email, dob);
    }

    public Teacher() {
        super();
    }



}
