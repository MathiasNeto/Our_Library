package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "tb_library")
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3)
    private String library_name;
    @Size(min = 3)
    private String institution_name;
    @OneToOne
    private Librarian librarian;
    @OneToMany
    private List<Book> books;
    @OneToMany
    private List<Teacher> teachers;
    @OneToMany
    private List<Student> students;
}
