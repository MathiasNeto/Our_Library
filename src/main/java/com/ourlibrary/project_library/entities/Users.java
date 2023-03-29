package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.EnumGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@Data
public abstract class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CPF(message = "CPF inválido")
    private String CPF;
    @NotBlank
    @Size(min = 3)
    private String name;
//    @NotBlank
//    @Size(min = 3)
//    private String lastname;
    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private EnumGender enumGender;
    @Embedded
    private Adress adress;
    @Embedded
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Contact> contact;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
}
