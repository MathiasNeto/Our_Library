package com.ourlibrary.project_library.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Data
@Builder
@Entity
@Table(name = "tb_login")
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank(message = "the registration field must not be blank")
    @NotNull(message = "the registration field must not be null")
    private String registration;
    @NotBlank(message = "the password field must not be blank")
    @NotNull(message = "the password field must not be null")
    private String password;
}
