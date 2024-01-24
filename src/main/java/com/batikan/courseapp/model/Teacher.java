package com.batikan.courseapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String Surname;

    private String email;

    private String password;

    private String telno;

    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<Course> courses;

}
