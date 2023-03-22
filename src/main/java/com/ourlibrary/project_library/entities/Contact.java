package com.ourlibrary.project_library.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Contact {

    private String gmail;
    private String telephone;
}
