package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.EnumGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Data
public abstract class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "the cpf field must not be null")
    @CPF(message = "Provide a valid CPF")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "the name_user field must not be blank")
    @NotNull(message = "the name_user field must not be null")
    @Size(min = 3)
    private String name_user;

//    @NotBlank
//    @Size(min = 3)
//    private String lastname;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private EnumGender enumGender;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Contact> contactList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
}

