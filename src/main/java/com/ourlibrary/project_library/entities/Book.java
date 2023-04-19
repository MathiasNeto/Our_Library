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
    @NotBlank(message = "the book_name field must not be blank")
    @NotNull(message = "the book_name field must not be null")
    private String name;

    @Column(unique = true)
    @Id
    private String isbn;

    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private Area area;
    @NotNull(message = "the isAvailable field must not be null")
    private Boolean isAvailable;

}
