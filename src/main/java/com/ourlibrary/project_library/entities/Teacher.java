package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.Area;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_teacher")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Users{
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "library_id")
//    private Library library;
    @ManyToOne
    private Course course;
}
