package com.ourlibrary.project_library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "tb_loan")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan { //Emprestimo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Student student;
    @OneToOne
    private Teacher teacher;
//    @NotBlank(message = "the loan_date field must not be blank")
//    @NotNull(message = "the loan_date field must not be null")
    private LocalDate loanDate;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
