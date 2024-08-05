package com.demo.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @Column(name = "subject_id")
    private String id;

    @Column(name = "subject_name")
    private String name;
}