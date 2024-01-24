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


}
