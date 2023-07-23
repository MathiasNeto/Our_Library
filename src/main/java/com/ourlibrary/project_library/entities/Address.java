package com.ourlibrary.project_library.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String road; //rua
    private String number;
    private String city;
    private String uf;
    private String neighborhood; //bairro
}
