package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    private String name_user;
    private LocalDate date;
    private LocalDate date_devolution;
    private BookDTO bookDTO;
    private String status;
    private Double value;

    public LoanDTO(Loan loan) {
        this.name_user = loan.getStudent().getName_user();
        this.date = loan.getLoanDate();
        this.date_devolution = loan.getDate_devolution();
        this.bookDTO = new BookDTO(loan.getBook());
        this.status = loan.getStatus();
        this.value = loan.getValue();
    }
}
