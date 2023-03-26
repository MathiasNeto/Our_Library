package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "tb_loan")
@AllArgsConstructor
@NoArgsConstructor
public class Loan { //Emprestimo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Student student;
    @OneToOne
    private Teacher teacher;

    private LocalDate date;
    @ManyToMany
    private List<Book> books;
}
