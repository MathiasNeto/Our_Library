package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Adress {
    private String road; //rua
    private String number;
    private String city;
    private String uf;
    private String neighborhood; //bairro
}
