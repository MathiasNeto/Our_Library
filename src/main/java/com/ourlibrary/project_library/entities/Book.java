package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.Area;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "the book_name field must not be blank")
    @NotNull(message = "the book_name field must not be null")
    private String name;

    @Column(unique = true)
    private String isbn;

    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private Area area;

    private Boolean isAvailable;

}
