package com.ourlibrary.project_library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_teacher")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher extends Users{
    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;
}
