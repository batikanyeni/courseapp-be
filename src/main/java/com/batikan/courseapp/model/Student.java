package com.batikan.courseapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private  String telno;

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<Enroll> enrollList;

    public Student(String name, String surname, String email, String password, String telno,List<Enroll> enrollList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.telno = telno;
        this.enrollList = enrollList;
    }
}
