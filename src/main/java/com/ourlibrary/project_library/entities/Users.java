package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@Data
public abstract class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "the name_user field must not be blank")
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
    private Adress adress;
    @Embedded
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Contact> contactList;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
    public boolean hasEmail(String email) {
        for (Contact contact : contactList) {
            if (contact.getGmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
}
