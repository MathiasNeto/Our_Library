package com.ourlibrary.project_library.entities;

import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public abstract class Users {
    private String CPF;
    private String name;
    private EnumGender enumGender;
    private Integer registration; //matricula;
    @Embedded
    private Adress adress;
    @Embedded
    private Contact contact;
    @Embedded
    private Login login;



}
