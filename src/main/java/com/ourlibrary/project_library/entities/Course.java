package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.Area;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private Area area;
    private String period;
    private String name;

    public Course(Area area, String name) {
        this.area = area;
        this.name = name;
    }

    public Course(String period, String name) {
        this.period = period;
        this.name = name;
    }
}
