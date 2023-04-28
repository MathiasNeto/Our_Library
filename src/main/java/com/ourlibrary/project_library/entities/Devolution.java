package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "tb_devolution")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Devolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Loan loan;

    //@NotNull(message = "the devolution_date field must not be null")
    private LocalDate devolution_date;

    @Transient
    private Double addition = 2.5;

    private Double price_Final;
    private String status;

}
