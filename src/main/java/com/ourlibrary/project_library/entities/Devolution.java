package com.ourlibrary.project_library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "the devolution_date field must not be blank")
    @NotNull(message = "the devolution_date field must not be null")
    private LocalDate devolution_date;

}
