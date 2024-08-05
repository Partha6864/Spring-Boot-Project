package com.demo.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "student_Id")
    private String id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_address")
    private String address;
}