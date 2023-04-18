package com.ourlibrary.project_library.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Embeddable
@Data

public class Address {
    @NotBlank(message = "the street field must not be blank")
    @NotNull(message = "the street field must not be null")
    private String road; //rua
    @NotBlank(message = "the number field must not be blank")
    @NotNull(message = "the number field must not be null")
    private String number;
    @NotBlank(message = "the city field must not be blank")
    @NotNull(message = "the city field must not be null")
    private String city;
    @NotBlank(message = "the uf field must not be blank")
    @NotNull(message = "the uf field must not be null")
    private String uf;
    @NotBlank(message = "the neighborhood field must not be blank")
    @NotNull(message = "the neighborhood field must not be null")
    private String neighborhood; //bairro
}
