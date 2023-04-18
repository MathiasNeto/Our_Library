package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.ArrayList;
import java.util.List;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Librarian_id")
    private Librarian librarian;

    @NotFound(action = NotFoundAction.IGNORE) //Essa notação faz com que o hibernate igona e retorna null em vez de
    // entity not found exception.
    @OneToMany
    @JoinColumn(name = "library_id")
    private List<Book> books = new ArrayList<>();
    @NotFound(action = NotFoundAction.IGNORE) //Essa notação faz com que o hibernate igona e retorna null em vez de
    // entity not found exception.
    @OneToMany
    @JoinColumn(name = "Library_id")
    private List<Teacher> teachers;
    @NotFound(action = NotFoundAction.IGNORE) //Essa notação faz com que o hibernate ignora e retorna null em vez de
    // entity not found exception.
    @OneToMany
    @JoinColumn(name = "Library_id")
    private List<Student> students;


}
