package com.ourlibrary.project_library.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Login {
    private String registration;
    private String pass;
}
