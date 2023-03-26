package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "tb_devolution")
@AllArgsConstructor
@NoArgsConstructor
public class Devolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Loan loan;

    private LocalDate devolution_date;

}
