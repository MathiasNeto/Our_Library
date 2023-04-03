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
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "library_id")
//    private Library library;
    @ManyToOne
    private Course course;
}
