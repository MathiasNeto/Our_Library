package com.ourlibrary.project_library.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
