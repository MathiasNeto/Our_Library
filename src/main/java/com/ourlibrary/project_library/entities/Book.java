package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.Area;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Book {
    @NotBlank(message = "the book_name field must not be blank")
    @NotNull(message = "the book_name field must not be null")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "the isbn field must not be blank")
    @NotNull(message = "the isbn field must not be null")
    private String isbn;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "loan_id")
//    private Loan loan;

//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Library library;
    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private Area area;

}
