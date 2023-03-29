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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private Librarian librarian;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private List<Book> books;
//    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL) //se o cascade aqui esta certo, pq pra mim nao faz
//    sentido eu apagando a biblioteca o usuario seja removido
//    private List<Teacher> teachers;
//    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL) //Aqui tbm
//    private List<Student> students;

    @OneToMany
    @JoinColumn(name = "library_id")
    private List<Users> users;
}
