package com.ourlibrary.project_library.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ourlibrary.project_library.enuns.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private Area area;
    @NotBlank(message = "the name_course field must not be blank")
    @NotNull(message = "the loan_date field must not be null")
    private String name_Course;
}
