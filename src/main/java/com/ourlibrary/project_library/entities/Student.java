package com.ourlibrary.project_library.entities;


import com.ourlibrary.project_library.enuns.EnumGender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_students")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Student extends Users {
    @NotBlank(message = "the period_course field must not be blank")
    @NotNull(message = "the period_course field must not be null")
    private String period_course;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public Student(String pe, Course course, String cpf, String name, EnumGender enumGender,
                    Address address, Contact contact, Login login
                   ){
        this.period_course = pe;
        this.course = course;
        this.setCpf(cpf);
        this.setName_user(name);
        this.setEnumGender(enumGender);
        this.setAddress(address);
        this.getContactList().add(contact);
        this.setLogin(login);
    }
}
