package com.example.appspring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Class implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;

    @OneToOne
    private Teacher  form_teacher;

    public Class() {
    }

    public Class(String name) {
        this.name = name;
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
