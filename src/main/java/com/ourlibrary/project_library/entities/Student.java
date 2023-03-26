package com.ourlibrary.project_library.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_students")
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Users {
    @ManyToOne
    private Course course;
}
