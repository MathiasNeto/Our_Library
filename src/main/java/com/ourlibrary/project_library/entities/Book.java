package com.ourlibrary.project_library.entities;

import com.ourlibrary.project_library.enuns.Area;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_book")
public class Book {
    @Size(min = 3)
    private String book_name ;
    @Id
    private String isbn;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "loan_id")
//    private Loan loan;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "library_id")
//    private Library library;
    @Column(name = "area")
    @Enumerated(EnumType.STRING)
    private Area area;

}
