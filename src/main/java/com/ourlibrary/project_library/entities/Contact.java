package com.ourlibrary.project_library.entities;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Embeddable
@Data
@Builder
@Entity
@Table(name = "tb_contact")
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "Provide a valid email")
    private String gmail;
    @NotBlank(message = "the telephone field must not be blank")
    @NotNull(message = "the telephone field must not be null")
    private String telephone;
}
