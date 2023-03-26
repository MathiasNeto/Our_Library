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
    @Embedded
    @JoinColumn(name = "gender")
    private EnumGender enumGender;
    private Integer registration; //matricula;
    @Embedded
    @JoinColumn(name = "address")
    private Adress adress;
    @Embedded
    @OneToMany
    @JoinColumn(name = "contact_id")
    private List<Contact> contact;
    @OneToOne
    @JoinColumn(name = "login_id")
    private Login login;



}
