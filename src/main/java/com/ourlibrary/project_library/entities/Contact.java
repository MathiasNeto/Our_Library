package com.ourlibrary.project_library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(unique = true)
    private String email;
    @NotBlank(message = "the telephone field must not be blank")
    @NotNull(message = "the telephone fiel  d must not be null")
    private String telephone;

    @ManyToOne//(fetch = FetchType.EAGER)
    @JsonIgnore()
    @JoinColumn(name = "user_id")
    private Users user;

//    public void setUsser(Librarian user) {
//        Contact.builder().id(user.getId());
//    }

//    public void insert_id_user(Long id){
//        con
//    }
}
