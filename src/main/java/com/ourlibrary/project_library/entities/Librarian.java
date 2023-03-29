package com.ourlibrary.project_library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_librarian")

public class Librarian extends Users {
//    @OneToOne
//    private Library library;
//    @OneToMany
//    private List<Loan> loan;



}
