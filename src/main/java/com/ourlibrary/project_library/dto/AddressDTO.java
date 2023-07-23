package com.ourlibrary.project_library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressDTO {
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

    public AddressDTO(String road, String number, String city, String uf, String neighborhood) {
        this.road = road;
        this.number = number;
        this.city = city;
        this.uf = uf;
        this.neighborhood = neighborhood;
    }

    public AddressDTO() {
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
