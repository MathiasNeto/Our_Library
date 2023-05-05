package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_loan")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan {
    public Double value; //Emprestimo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotNull(message = "the student field mus not be null")
    @OneToOne
    private Student student;
//    @NotNull(message = "the teacher field mus not be null")
    @OneToOne
    private Teacher teacher;
    private LocalDate loanDate;
    @NotNull(message = "the book field mus not be null")
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private String status;
    private LocalDate date_devolution;


}
