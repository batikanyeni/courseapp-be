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

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private List<Enroll> enrollList;
}
