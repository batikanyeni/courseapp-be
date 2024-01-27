package com.batikan.courseapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String weekday;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn()
    private Teacher teacher;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private List<Enroll> enrollList;

    public Course(String name, String weekday, Teacher teacher, List<Enroll> enrollList) {
        this.name = name;
        this.weekday = weekday;
        this.teacher = teacher;
        this.enrollList = enrollList;
    }
}
