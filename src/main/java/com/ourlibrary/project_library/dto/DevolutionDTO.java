package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Devolution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevolutionDTO {
    private String name_user;
    private BookDTO bookDTO;
    private LocalDate devolution_Date;
    private Double price_final;
    private String status;

    public DevolutionDTO(Devolution devolution){
        this.bookDTO = new BookDTO(devolution.getLoan().getBook());
        this.devolution_Date = devolution.getDevolution_date();
        this.name_user = devolution.getLoan().getStudent().getName_user();
        this.status = devolution.getStatus();
    }
}
