package com.ourlibrary.project_library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "tb_library")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "the library_name field must not be blank")
    @NotNull(message = "the library_name field must not be null")
    private String library_name;
    @NotBlank(message = "the institution_name field must not be blank")
    @NotNull(message = "the institution_name field must not be null")
    private String institution_name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Librarian_id")
    private Librarian librarian;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private List<Book> books = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Library_id")
   private List<Teacher> teachers;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Library_id")
    private List<Student> students;

}
